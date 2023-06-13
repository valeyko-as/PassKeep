package com.passkeep.models.data;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group_folder", schema = "public", catalog = "PassKeep")
@Data
public class GroupFolder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_folder_id")
    private List<GroupFolderDetails> folderDetails = new ArrayList<>();
}
