package com.web.gestiondestock.Dto;
import com.web.gestiondestock.Model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class LigneCommandeFournisseurDto {

    private Integer id;

    private ArticleDto articleDto;

    private CommandeFournisseurDto commandeFournisseurDto;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    public LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){
        if (ligneCommandeFournisseur == null){
            return null;
        }
        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .articleDto(articleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
                .commandeFournisseurDto(commandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandeFournisseur()))
                .quantite(ligneCommandeFournisseur.getQuantite())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .build();


    }
    public LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        if (ligneCommandeFournisseurDto==null){
            return null;
        }
        LigneCommandeFournisseur ligneCommandeFournisseur= new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
        ligneCommandeFournisseur.setArticle(articleDto.toEntity(ligneCommandeFournisseurDto.getArticleDto()));
        ligneCommandeFournisseur.setCommandeFournisseur(commandeFournisseurDto.toEntity(ligneCommandeFournisseurDto.getCommandeFournisseurDto()));
        ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.getQuantite());
        ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.getPrixUnitaire());
        return ligneCommandeFournisseur;

    }
}
