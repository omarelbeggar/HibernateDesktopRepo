package controller;

import java.util.List;

import dto.CommandeDTO;
import dto.Ligne_CommandeDTO;
import dto.ProduitDTO;
import service.CommandeService;
import service.ProduitService;

public class ProduitController {
public List<ProduitDTO> getAllProduit(){
	ProduitService produitservice=new ProduitService();
	return produitservice.retreive();
}
public void decrease_stock(){
	
	ProduitService produitservice=new ProduitService();
	  produitservice.decrease_stock();
}
}
