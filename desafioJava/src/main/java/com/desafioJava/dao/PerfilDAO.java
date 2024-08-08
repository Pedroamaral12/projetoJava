package com.desafioJava.dao;

import com.desafioJava.model.Perfil;
import com.desafioJava.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PerfilDAO {
	public List<Perfil> buscarTodosPerfis() {
		Transaction transaction = null;
		List<Perfil> perfis = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			Query<Perfil> query = session.createQuery("FROM Perfil", Perfil.class);
			perfis = query.list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return perfis;
	}
}
