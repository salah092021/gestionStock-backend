package com.web.gestiondestock.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="role")
public class Role extends AbstractEntity {

    @Column(name = "rolename")
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<Utilisateurs> utilisateurs;
}
