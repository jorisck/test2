package com.sdzee.servlets;

import java.io.IOException;  
//import java.io.PrintWriter;


import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import com.sdzee.beans.Coyote;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class Test3
 */
@WebServlet("/Test3")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/* Creation et initialisation du message */
		String paramAuteur = request.getParameter("auteur");
		
		String message = "Transmission de variables OK! " + paramAuteur;
				
		/*Création du bean*/
		Coyote premierBean = new Coyote();
		
		/*Initialisation de ses propriétés*/
		premierBean.setNom("Coyote");
		premierBean.setPrenom("Wile E.");
		
		/*création de la lsite et insertion de 4 élements*/
		java.util.List<Integer> premiereListe= new ArrayList<Integer>();
		premiereListe.add(27);
		premiereListe.add(12);
		premiereListe.add(138);
		premiereListe.add(6);
		
		DateTime dt = new DateTime();
		Integer jourDuMois = dt.getDayOfMonth();
		
		
		
		/*Stockage du message et du bean dans l'objet request*/
		request.setAttribute("test", message);
		request.setAttribute("coyote", premierBean);
		request.setAttribute("liste", premiereListe);
		request.setAttribute("jour", jourDuMois);
		
		/*transmission de la paire d'objets request/response à notre JSP*/
		this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
