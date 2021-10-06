package entidades;

import java.util.List;

import javax.persistence.EntityManager;

import dao.ContatoDao;
import util.JPAUtil;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	EntityManager em = JPAUtil.getEntityManager();
	
	ContatoDao dao = new ContatoDao();
	Contato c1 = new Contato();
	
	c1.setId(4);
	c1.setNome("GABY");
	
	dao.editar(c1);
	
	}

}
