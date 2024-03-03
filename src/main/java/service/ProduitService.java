package service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import bo.Client;
import bo.Produit;
import dao.ProduitDAO;
import dto.ClientDTO;
import dto.CommandeDTO;
import dto.Ligne_CommandeDTO;
import dto.ProduitDTO;

public class ProduitService implements ProduitServiceInterface{

	@Override
	public List<ProduitDTO> retreive() {
		
		 List<ProduitDTO> produitdtos=new ProduitDAO().retreive().stream().map(p->fromProduit(p)).collect(Collectors.toList());
		 return produitdtos;
	}
	public ProduitDTO fromProduit(Produit produit) {
		ProduitDTO produitdto=new ProduitDTO();
		produitdto.setId(produit.getId());
		produitdto.setQtstock(produit.getQtstock());
		produitdto.setLibelle(produit.getLibelle());
		produitdto.setPrix(produit.getPrix());
		
		return produitdto;
		
		
	}
	public Produit toProduit(ProduitDTO produitdto) {
		Produit produit=new Produit();
		produit.setId(produitdto.getId());
		produit.setQtstock(produitdto.getQtstock());
		produit.setLibelle(produitdto.getLibelle());
		produit.setPrix(produitdto.getPrix());
		
		return produit;
		
		
	}
	public void decrease_stock() {
		CommandeDTO cmd=new CommandeService().getCommandeDTO();
		for(Ligne_CommandeDTO l:cmd.getLignes()) {
			ProduitDTO p=l.getProduit();
			p.setQtstock(p.getQtstock()-l.getQuantite());
			new ProduitDAO().update(this.toProduit(p));
		}
		
	}
}
