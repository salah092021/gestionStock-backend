package com.web.gestiondestock.Dto;
import com.web.gestiondestock.Model.CommandeClient;
import lombok.Builder;
import lombok.Data;


import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeClientDto {


    private Integer id;

    private String code;

    private Instant dateCommande;

    private ClientDto clientDto;

    private List<LigneCommandeClientDto> ligneCommandeClientDtos;

    public CommandeClientDto fromEntity(CommandeClient commandeClient){
        if (commandeClient==null){
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .clientDto(clientDto.fromEntity(commandeClient.getClient()))
                .build();
    }
    public CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if (commandeClientDto==null){
            return null;
        }
        CommandeClient commandeClient= new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        commandeClient.setClient(clientDto.toEntity(commandeClientDto.getClientDto()));
        return commandeClient;
    }
}
