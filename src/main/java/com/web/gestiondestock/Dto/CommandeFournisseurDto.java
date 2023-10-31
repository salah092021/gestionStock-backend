package com.web.gestiondestock.Dto;
import com.web.gestiondestock.Model.CommandeFournisseur;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeFournisseurDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private FournisseurDto fournisseurDto;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurDtos;

    public CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        if (commandeFournisseur==null){
            return null;
        }
        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .fournisseurDto(fournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
                .build();
    }
    public CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if (commandeFournisseurDto==null){
            return null;
        }
        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setFournisseur(fournisseurDto.toEntity(commandeFournisseurDto.getFournisseurDto()));
        return commandeFournisseur;
    }
}
