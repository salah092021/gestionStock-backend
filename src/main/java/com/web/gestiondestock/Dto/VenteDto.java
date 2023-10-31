package com.web.gestiondestock.Dto;

import com.web.gestiondestock.Model.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;


@Data
@Builder
public class VenteDto {


    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    public VenteDto fromEntity(Ventes vente){
        if (vente==null){
            return null;
        }
        return VenteDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .dateVente(vente.getDateVente())
                .commentaire(vente.getCommentaire())
                .build();
    }
    public Ventes toEntity(VenteDto venteDto){
        if (venteDto==null){
            return null;
        }
        Ventes ventes= new Ventes();
        ventes.setId(venteDto.getId());
        ventes.setCode(venteDto.getCode());
        ventes.setDateVente(venteDto.getDateVente());
        ventes.setCommentaire(venteDto.getCommentaire());
        return ventes;
    }
}
