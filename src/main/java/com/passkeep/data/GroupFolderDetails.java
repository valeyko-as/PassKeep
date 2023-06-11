package com.passkeep.data;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "group_folder_details", schema = "public", catalog = "PassKeep")
@Data
public class GroupFolderDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private Integer url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "password_id")
    private Password password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_folder_id")
    private GroupFolder groupFolder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private GroupRole role;
}
