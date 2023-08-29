package model;

import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class ProduitsModel {
	
	private String mc;
	private List<Produit> produits = new ArrayList<Produit>();
	
	public ProduitsModel() {
		super();
	}

	public ProduitsModel(String mc, List<Produit> produits) {
		super();
		this.mc = mc;
		this.produits = produits;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	

}
