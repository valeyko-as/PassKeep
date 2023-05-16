package com.passkeep.data;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group", schema = "public", catalog = "PassKeep")
@Data
public class GroupEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    List<GroupStructureEntity> groupStructure = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    List<GroupRoleEntity> roles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    List<GroupFolderEntity> groupFolders = new ArrayList<>();
}
