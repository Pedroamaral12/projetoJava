package com.desafioJava.dao;

import com.desafioJava.model.Endereco;
import com.desafioJava.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EnderecoDAO {
	public List<Endereco> buscarTodosEnderecos() {
		Transaction transaction = null;
		List<Endereco> enderecos = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			Query<Endereco> query = session.createQuery("FROM Endereco", Endereco.class);
			enderecos = query.list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return enderecos;
	}
}
