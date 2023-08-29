package Dao;

import java.util.List;

import metier.Produit;

public interface IProduitDao {
	public Produit save(Produit p);
	public List<Produit> produitsParMC(String mc);
	public Produit getProduit(Long id);
	public Produit update(Long id);
	public void deleteProduit(Long id);
}
