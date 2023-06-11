package com.passkeep.data;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "private_folder", schema = "public", catalog = "PassKeep")
@Data
public class PrivateFolder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "private_folder_id")
    private List<PrivateFolderDetails> privateFolderDetails = new ArrayList<>();
}
