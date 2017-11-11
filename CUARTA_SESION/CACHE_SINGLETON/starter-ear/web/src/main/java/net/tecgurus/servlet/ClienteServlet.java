package net.tecgurus.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tecgurus.entities.Cliente;
import net.tecgurus.persistence.interfaces.ClienteDAO;

/**
 * Servlet implementation class ClienteServlet
 */
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ClienteDAO clienteDAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Si viene por listado de clientes
		PrintWriter writter = response.getWriter();
		String type = request.getParameter("type");
		switch (type) {
		case "LISTADO":
			StringBuilder sb = new StringBuilder("Resultado \n");
			clienteDAO.findByA("A").forEach(
					c -> sb.append("Cliente encontrado").append(c.getNomCte()).append(" ").append(c.getApePatCte()).append("\n"));
			writter.println(sb.toString());
			break;
		case "ALTA":
			String nombre = request.getParameter("nombre");
			String apellidoPaterno = request.getParameter("apellidoP");
			String telefono = request.getParameter("telefono");
			Cliente cliente = new Cliente();
			cliente.setNomCte(nombre);
			cliente.setApePatCte(apellidoPaterno);
			cliente.setTelCte(telefono);
			clienteDAO.saveCliente(cliente);
			writter.println("GUARDADO");
			break;
		case "MODIFICACION":
			Integer idCliente = Integer.parseInt(request.getParameter("idCte"));
			String telefonoRetrieved = request.getParameter("telefono");
			Cliente clienteRetrieved = clienteDAO.findById(idCliente);
			clienteRetrieved.setTelCte(telefonoRetrieved);
			clienteDAO.updateCliente(clienteRetrieved);
			writter.println("ACTUALIZADO");
			break;
		}
		writter.flush();
		writter.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
