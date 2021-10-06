package bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.ContatoDao;
import entidades.Contato;

@ManagedBean
@ViewScoped
public class ContatoBean {

	private Contato contato;
	private ArrayList<Contato> contatos;
	

	public ArrayList<Contato> getContatos() {
		return contatos;
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public void prepararInserir() {
	
		this.contato = new Contato();
		
	}
	
	public void Inserir() {
		
		
		ContatoDao dao = new ContatoDao();
		dao.salvar(contato);
		contatos = dao.listar();
		

	}

	public void carregarListagem() {

		ContatoDao dao = new ContatoDao();
		contatos = dao.listar();
		
	}
}
