package model;

public class ServicioCliente {

	private String cedula_cli;
	private String nombre_cli;
	private String ape_cli;
	private String email_cli;
	private String nombre_emp;
	private String email_emp;
	private String nombre_servicio;
	private String desc_servicio;

	public String getCedula_cli() {
		return cedula_cli;
	}

	public void setCedula_cli(String cedula_cli) {
		this.cedula_cli = cedula_cli;
	}

	public String getNombre_cli() {
		return nombre_cli;
	}

	public void setNombre_cli(String nombre_cli) {
		this.nombre_cli = nombre_cli;
	}

	public String getApe_cli() {
		return ape_cli;
	}

	public void setApe_cli(String ape_cli) {
		this.ape_cli = ape_cli;
	}

	public String getEmail_cli() {
		return email_cli;
	}

	public void setEmail_cli(String email_cli) {
		this.email_cli = email_cli;
	}

	public String getNombre_emp() {
		return nombre_emp;
	}

	public void setNombre_emp(String nombre_emp) {
		this.nombre_emp = nombre_emp;
	}

	public String getEmail_emp() {
		return email_emp;
	}

	public void setEmail_emp(String email_emp) {
		this.email_emp = email_emp;
	}

	public String getNombre_servicio() {
		return nombre_servicio;
	}

	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}

	public String getDesc_servicio() {
		return desc_servicio;
	}

	public void setDesc_servicio(String desc_servicio) {
		this.desc_servicio = desc_servicio;
	}

}
