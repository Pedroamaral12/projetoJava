package com.desafioJava.dao;

import com.desafioJava.model.Usuario;
import com.desafioJava.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Usuario> buscarPorNomeCriteria(String nome) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.like("nome", "%" + nome + "%"));
			return criteria.list();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Usuario").list();
		}
	}
}
