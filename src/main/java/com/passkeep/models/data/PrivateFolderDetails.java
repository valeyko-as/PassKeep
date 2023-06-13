package com.passkeep.models.data;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "private_folder_details", schema = "public", catalog = "PassKeep")
@Data
public class PrivateFolderDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "password_id")
    private Password password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "private_folder_id")
    private PrivateFolder folder;
}
