package com.passkeep.models.data;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "group_role", schema = "public", catalog = "PassKeep")
@Data
public class GroupRole {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private boolean isOnlyRead;
    private boolean isRolesAdmin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private List<GroupStructure> groupStructure;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private List<GroupFolderDetails> groupFolders;
}
