package com.passkeep.data;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group", schema = "public", catalog = "PassKeep")
@Data
public class Group {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    List<GroupStructure> groupStructure = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    List<GroupRole> roles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    List<GroupFolder> groupFolders = new ArrayList<>();
}
