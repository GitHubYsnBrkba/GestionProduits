package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class ProduitDaoImpl implements IProduitDao{

	@Override
	public Produit save(Produit p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("INSERT INTO PRODUITS (DESIGNATION,PRIX,QUANTITE) VALUES (?,?,?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			ps.close();
			
			PreparedStatement ps2=connection.prepareStatement
					("SELECT MAX(ID) AS MAX_ID FROM PRODUITS");
			ResultSet rs= ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			
			ps2.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		
		List<Produit> listeProduit = new ArrayList<Produit>();
		Connection connection = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE PRODUITS.DESIGNATION LIKE ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				
				listeProduit.add(p);
			}
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listeProduit;
	}

	@Override
	public Produit getProduit(Long id) {
		
		Connection connexion = SingletonConnection.getConnection();
		Produit p = new Produit();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM PRODUITS WHERE ID = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
			}
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public Produit update(Produit p) {
		Connection connexion = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = connexion.prepareStatement("UPDATE PRODUITS SET DESIGNATION=?,PRIX=?,QUANTITE=? WHERE ID=?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4, p.getId());
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public void deleteProduit(Long id) {
		 Connection connexion = SingletonConnection.getConnection();
		 try {
			PreparedStatement ps = connexion.prepareStatement("DELETE FROM PRODUITS WHERE ID=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
