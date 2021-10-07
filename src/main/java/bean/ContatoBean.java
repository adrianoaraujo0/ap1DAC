package bean;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

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

	public void editar() {

		ContatoDao dao = new ContatoDao();
		contatos = dao.listar();

		dao.merge(contato);

	}

	public void excluir() {

		ContatoDao dao = new ContatoDao();

		dao.remover(contato);

		contatos = dao.listar();

	}
	
	 public void showMessage() {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
	        		"Ligação em andamento para " + contato.getNome() + " -- " + contato.getTelefone());

	        PrimeFaces.current().dialog().showMessageDynamic(message);
	    }
}
