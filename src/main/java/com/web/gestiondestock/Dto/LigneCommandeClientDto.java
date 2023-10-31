package com.web.gestiondestock.Dto;

import com.web.gestiondestock.Model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDto {

    private Integer id;

    private ArticleDto articleDto;

    private CommandeClientDto commandeClientDto;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    public LigneCommandeClientDto fomEntity(LigneCommandeClient ligneCommandeClient){
        if (ligneCommandeClient==null){
            return null;
        }
       return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .articleDto(articleDto.fromEntity(ligneCommandeClient.getArticle()))
                .commandeClientDto(commandeClientDto.fromEntity(ligneCommandeClient.getCommandeClient()))
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .build();

    }
    public LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
        if (ligneCommandeClientDto==null){
            return null;
        }
        LigneCommandeClient ligneCommandeClient= new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setArticle(articleDto.toEntity(ligneCommandeClientDto.getArticleDto()));
        ligneCommandeClient.setCommandeClient(commandeClientDto.toEntity(ligneCommandeClientDto.getCommandeClientDto()));
        ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
        return ligneCommandeClient;

    }
}
