package Dao;

import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ProduitDaoImpl pdao = new ProduitDaoImpl();
			Produit p1 = pdao.save(new Produit("SOURIS",120,190));
			Produit p2 = pdao.save(new Produit("CABLE",70,130));

			System.out.println(p1.toString());
			System.out.println(p2.toString());
			
			System.out.println("Liste des produits : ");
			
			List<Produit> listeProd = new ArrayList<Produit>();
			listeProd = pdao.produitsParMC("%R%");
			
			for(Produit p:listeProd) {
				System.out.println(p.toString());
			}
	}

}
