package com.passkeep.data;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "private_folder_details", schema = "public", catalog = "PassKeep")
@Data
public class PrivateFolderDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "password_id")
    private PasswordEntity password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "private_folder_id")
    private PrivateFolderEntity folder;
}
