package view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import bussiness.ClienteBusiness;
import model.Cliente;

@ManagedBean
@ViewScoped
public class ClienteBean {

	@Inject
	private ClienteBusiness cB;
	private Cliente cliente;
	private List<Cliente> clientes;
	@Inject
	private FacesContext facesContext;
	private boolean editing = false;
	private int codigo;

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		clientes = cB.listarClientes();
	}

	public void loadData() {

		System.out.println("load data " + codigo);
		if (codigo == 0)
			return;
		try {
			cliente = cB.leer(codigo);
			editing = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String registrar() {

		try {
			if (editing)
				cB.actualizar(cliente);
			else
				cB.registrar(cliente);
			return "crearClientes?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void eliminar(int codigo) {
		try {
			cB.eliminar(codigo);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Registro eliminado");
			facesContext.addMessage(null, m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String editar(Cliente c) {
		editing = true;
		return "crearClientes?faces-redirect=true&id=" + c.getCodigoCliente();
	}

	public String regresar() {
		return "index";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
