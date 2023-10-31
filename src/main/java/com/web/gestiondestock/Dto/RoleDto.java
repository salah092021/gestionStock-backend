package com.web.gestiondestock.Dto;


import com.web.gestiondestock.Model.Role;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RoleDto {


    private Integer id;

    private String roleName;

    private List<UtilisateurDto> utilisateurDtos;

    public RoleDto fromEntity(Role role){
        if (role==null){
            return null;
        }
        return RoleDto.builder()
                .id(role.getId())
                .roleName(role.getRoleName())
                .build();

    }
    public Role toEntity(RoleDto roleDto){
        if (roleDto==null){
            return null;
        }
        Role role= new Role();
        role.setId(roleDto.getId());
        role.setRoleName(roleDto.getRoleName());
        return role;
    }
}
