package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_Servicio")
public class Servicio {

	@Id
	@GeneratedValue
	private int codigoServicio;
	@NotNull
	private String nombre;
	@NotNull
	private String Descripcion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoEmpleado")
	private Empleado codigoEmpleado;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoCliente")
	private Cliente codigoCliente;

	public int getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(int codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Empleado getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(Empleado codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public Cliente getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Cliente codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

}
