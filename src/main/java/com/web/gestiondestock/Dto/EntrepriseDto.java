package com.web.gestiondestock.Dto;

import com.web.gestiondestock.Model.Adresse;
import com.web.gestiondestock.Model.Entreprises;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EntrepriseDto {


    private Integer id;

    private String nom;

    private String description;

    private AdresseDto adresse;

    private String codeFiscal;

    private String photo;

    private String email;

    private String numTel;

    private String siteWeb;

    private List<UtilisateurDto> utilisateurDtos ;

    public EntrepriseDto fromEntity(Entreprises entreprises){
        if (entreprises==null){
            return null;
        }
       return EntrepriseDto.builder()
                .id(entreprises.getId())
                .nom(entreprises.getNom())
                .description(entreprises.getDescription())
                .adresse(adresse.fromEntity(entreprises.getAdresse()))
                .codeFiscal(entreprises.getCodeFiscal())
                .photo(entreprises.getPhoto())
                .email(entreprises.getEmail())
                .numTel(entreprises.getNumTel())
                .siteWeb(entreprises.getSiteWeb())
                .build();

    }
    public Entreprises toEntity(EntrepriseDto entrepriseDto){
        if (entrepriseDto==null){
            return null;
        }
        Entreprises entreprises= new Entreprises();
        entreprises.setId(entrepriseDto.getId());
        entreprises.setNom(entrepriseDto.getNom());
        entreprises.setDescription(entrepriseDto.getDescription());
        entreprises.setAdresse(adresse.toEntity(entrepriseDto.getAdresse()));
        entreprises.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprises.setPhoto(entrepriseDto.getPhoto());
        entreprises.setEmail(entrepriseDto.getEmail());
        entreprises.setNumTel(entrepriseDto.getNumTel());
        entreprises.setSiteWeb(entrepriseDto.getSiteWeb());
        return entreprises;
    }
}
