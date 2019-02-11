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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TBL_Sucursal")
public class Sucursal {

	@Id
	@GeneratedValue
	private int codigoSucursal;
	@NotNull
	private String direccion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoCiudad")
	private Ciudad codigoCiudad;

	@JsonIgnore
	@OneToMany(mappedBy = "codigoSucursal")
	private List<Empleado> empleados;

	public int getCodigoSucursal() {
		return codigoSucursal;
	}

	public void setCodigoSucursal(int codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Ciudad getCodigoCiudad() {
		return codigoCiudad;
	}

	public void setCodigoCiudad(Ciudad codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}

}