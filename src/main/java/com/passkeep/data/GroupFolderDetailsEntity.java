package com.passkeep.data;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "group_folder_details", schema = "public", catalog = "PassKeep")
@Data
public class GroupFolderDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private Integer url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "password_id")
    private PasswordEntity password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_folder_id")
    private GroupFolderEntity groupFolder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private GroupRoleEntity role;
}
