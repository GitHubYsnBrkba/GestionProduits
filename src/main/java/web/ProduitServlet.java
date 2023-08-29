package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Dao.IProduitDao;
import Dao.ProduitDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.Produit;
import model.ProduitsModel;

public class ProduitServlet extends HttpServlet{

	private IProduitDao metier;
	
	@Override
	public void init() throws ServletException {
		metier = new ProduitDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		if(path.equals("/index.do")) {
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		}
		else if(path.equals("/chercher.do")) {
			String motcle=request.getParameter("motcle");
			ProduitsModel pm=new ProduitsModel();
			pm.setMc(motcle);
			List<Produit> produits=metier.produitsParMC("%"+motcle+"%");
			pm.setProduits(produits);
			request.setAttribute("model", pm);
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		}
		else {
			//response.sendError(response.SC_NOT_FOUND);
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		}
		
	}

}
