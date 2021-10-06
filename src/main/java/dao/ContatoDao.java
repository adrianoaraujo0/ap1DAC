package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidades.Contato;
import util.JPAUtil;

public class ContatoDao {

	EntityManager em;

	public ContatoDao() {
		
	}

	public ContatoDao(EntityManager em) {
		this.em = em;
	}

	
	public void salvar(Contato contato) {
		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		em.getTransaction().begin();
		em.persist(contato);
		em.getTransaction().commit();
		em.close();
	}

	public void editar(Contato contato) {
		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		em.getTransaction().begin();
		this.em.merge(contato);
		em.getTransaction().commit();
		em.close();
	}

	public void remover(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		Contato contato = em.getReference(Contato.class, id);

		em.getTransaction().begin();
		this.em.remove(contato);
		em.getTransaction().commit();
		em.close();
	}

	public ArrayList<Contato> listar() {
		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		String jpql = "SELECT c FROM Contato c";
		return (ArrayList<Contato>) em.createQuery(jpql, Contato.class).getResultList();
	}

}
