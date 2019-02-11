package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TBL_Empleado")
public class Empleado {
	@Id
	@GeneratedValue
	private int codigoEmpleado;
	@NotNull
	private String cedula;
	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	@NotNull
	@Email
	private String correo;

	@ManyToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "codigoSucursal")
	private Sucursal codigoSucursal;
	@JsonIgnore
	@OneToMany(mappedBy = "codigoEmpleado")
	private List<Servicio> servicios;

	/**
	 * Este metodo retorna el codigo del empleado, este codigo es autogenerado
	 * 
	 * @return
	 */
	public int getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Sucursal getCodigoSucursal() {
		return codigoSucursal;
	}

	public void setCodigoSucursal(Sucursal codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

}
