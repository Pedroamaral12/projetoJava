package com.desafioJava.dao;

import com.desafioJava.model.Usuario;
import com.desafioJava.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UsuarioDAO {
	public void salvar(Usuario usuario) {
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

	public Usuario buscarPorId(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Usuario.class, id);
		}
	}

	public List<Usuario> buscarPorNomeJPQL(String nome) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			org.hibernate.query.Query<Usuario> query = session.createQuery("FROM Usuario WHERE nome LIKE :nome",
					Usuario.class);
			query.setParameter("nome", "%" + nome + "%");
			return query.getResultList();
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

	public List<Usuario> buscarTodos() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Usuario", Usuario.class).getResultList();
		}
	}
}
