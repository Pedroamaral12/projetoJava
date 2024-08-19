package com.desafioJava.dao;

import com.desafioJava.model.Endereco;
import com.desafioJava.model.Usuario;
import com.desafioJava.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioDAO {

	public void salvar(Usuario usuario) {
		if (usuario.getNome() != null) {
			Transaction transaction = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				session.save(usuario);
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
		}
	}

	public void alterar(Usuario usuario) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(usuario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void excluir(Usuario usuario) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.delete(usuario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Usuario buscarPorId(Integer id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Usuario.class, id);
		}
	}

	public List<Usuario> buscarTodos() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Usuario", Usuario.class).getResultList();
		}
	}

	public List<Endereco> buscarEnderecosPorUsuario(Integer usuarioId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session
					.createQuery("select e from Endereco e join e.usuarios u where u.id = :usuarioId", Endereco.class)
					.setParameter("usuarioId", usuarioId).getResultList();
		}
	}

	public List<Usuario> buscarPorNome(String nome) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Usuario where nome like :nome", Usuario.class)
					.setParameter("nome", "%" + nome + "%").getResultList();
		}
	}

	public List<Usuario> buscarPorNomeCriteria(String nome) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteriaQuery = builder.createQuery(Usuario.class);
			Root<Usuario> root = criteriaQuery.from(Usuario.class);
			criteriaQuery.select(root).where(builder.like(root.get("nome"), "%" + nome + "%"));
			return session.createQuery(criteriaQuery).getResultList();
		}
	}

	public List<Usuario> buscarComFiltros(String nome, String cpf, Date dataInicio, Date dataFim) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteriaQuery = builder.createQuery(Usuario.class);
			Root<Usuario> root = criteriaQuery.from(Usuario.class);

			List<Predicate> predicates = new ArrayList<>();

			if (nome != null && !nome.isEmpty()) {
				predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
			}
			if (cpf != null && !cpf.isEmpty()) {
				predicates.add(builder.like(root.get("cpf"), "%" + cpf + "%"));
			}
			if (dataInicio != null) {
				predicates.add(builder.greaterThanOrEqualTo(root.get("dataCadastro"), dataInicio));
			}
			if (dataFim != null) {
				predicates.add(builder.lessThanOrEqualTo(root.get("dataCadastro"), dataFim));
			}

			criteriaQuery.select(root).where(predicates.toArray(new Predicate[0]));

			return session.createQuery(criteriaQuery).getResultList();
		}
	}
}
