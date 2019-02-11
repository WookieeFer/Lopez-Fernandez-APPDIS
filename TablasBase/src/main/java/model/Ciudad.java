package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Esta es la clase para la entidad Ciudad
 * 
 * @author Byron Fernandez y Jonnathan Lopez
 *
 */
@Entity
@Table(name = "TBL_Ciudad")
public class Ciudad {
	@Id
	@GeneratedValue
	private int codigoCiudad;
	@NotNull
	private String nombre;
	@NotNull
	private String direccion;
	@JsonIgnore
	@OneToMany(mappedBy = "codigoCiudad")
	private List<Sucursal> sucursales;

	/**
	 * Este metodo retorna el nombre de la ciudad
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Este metodo retorna el codigo de la ciudad, este codigo es autogenerado
	 * 
	 * @return
	 */
	public int getCodigoCiudad() {
		return codigoCiudad;
	}

	/**
	 * Este metodo setea el codigo de la ciudad
	 * 
	 * @return
	 */
	public void setCodigoCiudad(int codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}

	/**
	 * Este metodo setea el nombre de la ciudad
	 * 
	 * @return
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Este metodo obtiene la direccion de la ciudad
	 * 
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Este metodo setea la direccion de la ciudad
	 * 
	 * @return
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Este metodo obtiene la lista de sucursales de la ciudad
	 * 
	 * @return
	 */
	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

}