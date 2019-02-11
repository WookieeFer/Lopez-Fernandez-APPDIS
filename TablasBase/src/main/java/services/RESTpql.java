package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import bussiness.CiudadBusiness;
import bussiness.ClienteBusiness;
import bussiness.ServicioBusiness;
import model.Cliente;
import model.MostrarSucursales;
import model.ServicioCliente;

/**
 * Esta clase programa todos los servicios REST para la comunicacion
 * cliente-servidor
 * 
 *
 */

@Path("/Servicio")
public class RESTpql {

	@Inject
	private ServicioBusiness sBusiness;

	@Inject
	private ClienteBusiness cBussiness;

	@Inject
	private CiudadBusiness ciuBussiness;

	/**
	 * Este metodo sirve para obtener el listado de los servicios
	 * 
	 * @return
	 */
	@GET
	@Path("/listadoServicios")
	@Produces("application/json")
	public List<ServicioCliente> listarServiciosCliente() {
		return sBusiness.listarServiciosCliente();
	}

	/**
	 * Este metodo sirve para actualizar clientes
	 * 
	 * @return
	 */
	@PUT
	@Path("/actualizar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response actualizar(Cliente c) {
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			cBussiness.actualizar(c);
			data.put("codigo", "1");
			data.put("mensaje", "Ok");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {

			e.printStackTrace();
			data.put("codigo", "99");
			data.put("mensaje", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
		}
		return builder.build();
	}

	/**
	 * Este metodo sirve para insertar clientes
	 * 
	 * @return
	 */
	@POST
	@Path("/insertar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response insertar(Cliente c) {

		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			cBussiness.registrar(c);
			data.put("codigo", "1");
			data.put("mensaje", "Ok");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {

			e.printStackTrace();
			data.put("codigo", "99");
			data.put("mensaje", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
		}
		return builder.build();
	}

	/**
	 * Este metodo sirve para el login de los clientes
	 * 
	 * @return
	 */
	@GET
	@Path("/login")
	@Produces("application/json")
	public Cliente login(@QueryParam("correo") String usuario, @QueryParam("cedula") String contrasenia) {
		Cliente aux = null;
		try {
			aux = cBussiness.login(usuario, contrasenia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aux;
	}

	/**
	 * Este metodo sirve para buscar clientes por cedula
	 * 
	 * @return
	 */
	@GET
	@Path("/buscar")
	@Produces("application/json")
	public Cliente buscarCliente(@QueryParam("cedula") String cedula) {

		Cliente aux = null;
		try {
			aux = cBussiness.leerCedula(cedula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aux;
	}

	/**
	 * Este metodo sirve para listar sucursales segun ciudad
	 * 
	 * @return
	 */
	@GET
	@Path("/buscarSucursal")
	@Produces("application/json")
	public List<MostrarSucursales> buscarSucursal(@QueryParam("nombre") String nombre) {
		List<MostrarSucursales> ms = ciuBussiness.listarSucursal(nombre);
		return ms;
	}

}
