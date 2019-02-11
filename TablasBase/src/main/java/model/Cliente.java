package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TBL_Cliente")
public class Cliente {
	@Id
	@GeneratedValue
	private int codigoCliente;
	@NotNull
	private String cedula;
	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	@NotNull
	@Email
	private String correo;
//	@JsonIgnore
//	@OneToMany(mappedBy = "codigoCliente")
//	private List<Equipo> equipos;
	@JsonIgnore
	@OneToMany(mappedBy = "codigoCliente")
	private List<Servicio> servicios;

	/**
	 * Este metodo obtiene el codigo del cliente, este codigo es autogenerado
	 * 
	 * @return
	 */
	public int getCodigoCliente() {
		return codigoCliente;
	}

	/**
	 * Este metodo setea el codigo del cliente
	 * 
	 * @return
	 */
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	/**
	 * Este metodo obtiene la cedula del cliente
	 * 
	 * @return
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * Este metodo setea la cedula del cliente
	 * 
	 * @return
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * Este metodo obtiene el nombre del cliente
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Este metodo setea el nombre del cliente
	 * 
	 * @return
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Este metodo obtiene el apellido del cliente
	 * 
	 * @return
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Este metodo setea el apellido del cliente
	 * 
	 * @return
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Este metodo obtiene el correo del cliente
	 * 
	 * @return
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Este metodo setea el correo del cliente
	 * 
	 * @return
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

//	public List<Equipo> getEquipos() {
//		return equipos;
//	}
//
//	public void setEquipos(List<Equipo> equipos) {
//		this.equipos = equipos;
//	}

	/**
	 * Este metodo lista los serivicios del cliente
	 * 
	 * @return
	 */
	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

}
