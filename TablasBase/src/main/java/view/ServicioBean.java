package view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import bussiness.ClienteBusiness;
import bussiness.EmpleadoBusiness;
import bussiness.ServicioBusiness;
import model.Cliente;
import model.Empleado;
import model.Servicio;

@ManagedBean
@ViewScoped
public class ServicioBean {

	@Inject
	private ServicioBusiness sB;
	private Servicio servicio;
	private List<Servicio> servicios;
	@Inject
	private FacesContext facesContext;
	private boolean editing = false;
	private int codigo;
	private int codigoEmpleado;
	private int codigoCliente;

	@Inject
	private EmpleadoBusiness eB;
	private List<Empleado> empleados;

	@Inject
	private ClienteBusiness cB;
	private List<Cliente> clientes;

	@PostConstruct
	public void init() {
		servicio = new Servicio();
		servicios = sB.listarServicios();
		empleados = eB.listarEmpleados();
		clientes = cB.listarClientes();
	}

	public void loadData() {

		System.out.println("load data " + codigo);
		if (codigo == 0)
			return;
		try {
			servicio = sB.leer(codigo);
			editing = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String registrar() {
		try {
			if (editing) {
				Empleado e = new Empleado();
				e.setCodigoEmpleado(codigoEmpleado);
				servicio.setCodigoEmpleado(e);

				Cliente c = new Cliente();
				c.setCodigoCliente(codigoCliente);
				servicio.setCodigoCliente(c);

				sB.actualizar(servicio);
			} else {
				Empleado e = new Empleado();
				e.setCodigoEmpleado(codigoEmpleado);
				servicio.setCodigoEmpleado(e);
				System.out.println("codigo de servicio..." + servicio.getCodigoServicio());
				System.out.println("codigo de cliente..." + servicio.getNombre());

				Cliente c = new Cliente();
				c.setCodigoCliente(codigoCliente);
				servicio.setCodigoCliente(c);

				sB.registrar(servicio);
				return "crearServicios?faces-redirect=true";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void eliminar(int codigo) {
		try {
			sB.eliminar(codigo);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Registro eliminado");
			facesContext.addMessage(null, m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String editar(Servicio s) {
		editing = true;
		return "crearServicios?faces-redirect=true&id=" + s.getCodigoServicio();
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
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

	public int getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}