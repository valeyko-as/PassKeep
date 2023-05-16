package com.passkeep.data;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group_folder", schema = "public", catalog = "PassKeep")
@Data
public class GroupFolderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_folder_id")
    private List<GroupFolderDetailsEntity> folderDetails = new ArrayList<>();
}
