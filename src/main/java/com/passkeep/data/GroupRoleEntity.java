package com.passkeep.data;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "group_role", schema = "public", catalog = "PassKeep")
@Data
public class GroupRoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private boolean isOnlyRead;
    private boolean isRolesAdmin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private List<GroupStructureEntity> groupStructure;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private List<GroupFolderDetailsEntity> groupFolders;
}
