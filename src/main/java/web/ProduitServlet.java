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

@WebServlet(name="cs",urlPatterns = {"*.do"})
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
		else if(path.equals("/SaisieProduit.do")) {
			request.setAttribute("produit", new Produit());
			request.getRequestDispatcher("SaisieProduit.jsp").forward(request, response);
		}
		else if(path.equals("/SaveProduit.do")&&(request.getMethod().equals("POST"))) {
			String desig 	= request.getParameter("designation");
			double prix 	= Double.parseDouble(request.getParameter("prix"));
			int qte 		= Integer.parseInt(request.getParameter("quantite"));
			
			Produit p = metier.save(new Produit(desig, prix, qte));
			request.setAttribute("produit", p);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);

		}
		else if(path.equals("/Suppression.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteProduit(id);
			//request.getRequestDispatcher("produits.jsp").forward(request, response);
			response.sendRedirect("chercher.do?motcle=");
		}
		else if(path.equals("/Edit.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Produit p = metier.getProduit(id);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("EditProduit.jsp").forward(request, response);
		}
		else if(path.equals("/UpdateProduit.do")&&(request.getMethod().equals("POST"))) {
			Long id 		= Long.parseLong(request.getParameter("id"));
			String desig 	= request.getParameter("designation");
			double prix 	= Double.parseDouble(request.getParameter("prix"));
			int qte 		= Integer.parseInt(request.getParameter("quantite"));
			
			Produit p = new Produit(desig,prix,qte);
			p.setId(id);
			Produit p1 = metier.update(p);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);

		}
		else {
			//response.sendError(response.SC_NOT_FOUND);
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
