package tn.esprit.rh.achat.dto;

import java.util.Date;

import lombok.Data;

@Data
public class FactureDto {
	private Long idFacture;
	private float montantRemise;
	private float montantFacture;
	
	private Date dateCreationFacture;
	
	private Date dateDerniereModificationFacture;
	private Boolean archivee;

}
