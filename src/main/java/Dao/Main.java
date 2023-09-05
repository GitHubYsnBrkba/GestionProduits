package Dao;

import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ProduitDaoImpl pdao = new ProduitDaoImpl();
			/*
			Produit p1 = pdao.save(new Produit("SOURIS",120,190));
			Produit p2 = pdao.save(new Produit("CABLE",70,130));

			System.out.println(p1.toString());
			System.out.println(p2.toString());
			
			System.out.println("Liste des produits : ");
			*/
			//pdao.deleteProduit((long)17);
			List<Produit> listeProd = new ArrayList<Produit>();
			listeProd = pdao.produitsParMC("%R%");
			
			for(Produit p:listeProd) {
				System.out.println(p.toString());
			}
//			Produit p3 = pdao.getProduit((long)17);
//			System.out.println(p3.toString());
//			p3.setDesignation("SOURIS MODIFIEE");
//			p3.setPrix(200);
//			p3.setQuantite(500);
//			Produit p4 = pdao.update(p3);
//			System.out.println(p4.toString());
			/*
			Produit p3 = pdao.getProduit((long)20);
			System.out.println("Le produit avec ID = 19");
			System.out.println(p3.toString());
			*/
			
			
			
			
			
			
	}

}
