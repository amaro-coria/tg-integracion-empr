package net.tecgurus.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.persistence.CatalogoGeneralDAO;

/**
 * Servlet implementation class CatalogoServlet
 */
public class CatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CatalogoGeneralDAO catalogoDAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener resultado de los finders
		/*
		 * StringBuilder sb1 = new StringBuilder("Metodo 1: "); StringBuilder
		 * sb2 = new StringBuilder("Metodo 2: "); StringBuilder sb3 = new
		 * StringBuilder("Metodo 3: "); // 1 for (CatalogoGeneral c :
		 * catalogoDAO.findAll()) {
		 * sb1.append("| - Resultado parcial: ").append(c.getIdCat()).
		 * append(" - ").append(c.getDscCorCat()); } // 2 for (CatalogoGeneral c
		 * : catalogoDAO.findAll2()) {
		 * sb2.append("| - Resultado parcial: ").append(c.getIdCat()).
		 * append(" - ").append(c.getDscCorCat()); } // 3 for (CatalogoGeneral c
		 * : catalogoDAO.findAll3()) {
		 * sb3.append("| - Resultado parcial: ").append(c.getIdCat()).
		 * append(" - ").append(c.getDscCorCat()); } PrintWriter writter =
		 * response.getWriter(); writter.println(sb1.toString());
		 * writter.println(sb2.toString()); writter.println(sb3.toString());
		 * writter.close();
		 */
		//Primer ejercicio de la practica
		int daysToSearch = 15;
		StringBuilder sb = new StringBuilder("Busqueda por dias: ");
		catalogoDAO.findFromDays(daysToSearch).forEach(
				c -> sb.append("|Registro parcial: ")
						.append(c.getIdCat())
						.append(c.getDscCorCat())
						.append("|"));
		PrintWriter writter = response.getWriter();
		writter.println(sb.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
