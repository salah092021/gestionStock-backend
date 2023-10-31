package com.web.gestiondestock.Dto;

import com.web.gestiondestock.Model.Adresse;
import com.web.gestiondestock.Model.Entreprises;
import com.web.gestiondestock.Model.Role;
import com.web.gestiondestock.Model.Utilisateurs;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UtilisateurDto {


    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private String motDePasse;

    private AdresseDto adresse;

    private String photo;

    private EntrepriseDto entrepriseDto;

    private RoleDto roleDto;

    public UtilisateurDto fromEntity(Utilisateurs utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .motDePasse(utilisateur.getMotDePasse())
                .adresse(adresse.fromEntity(utilisateur.getAdresse()))
                .photo(utilisateur.getPhoto())
                .build();

    }

    public Utilisateurs toEntity(UtilisateurDto utilisateurDto) {
        if (utilisateurDto == null) {
            return null;
        }
        Utilisateurs utilisateurs = new Utilisateurs();
        utilisateurs.setId(utilisateurDto.getId());
        utilisateurs.setNom(utilisateurDto.getNom());
        utilisateurs.setPrenom(utilisateurDto.getPrenom());
        utilisateurs.setEmail(utilisateurDto.getEmail());
        utilisateurs.setMotDePasse(utilisateurDto.getMotDePasse());
        utilisateurs.setAdresse(adresse.toEntity(utilisateurDto.getAdresse()));
        utilisateurs.setPhoto(utilisateurDto.getPhoto());
        return utilisateurs;
    }

}

