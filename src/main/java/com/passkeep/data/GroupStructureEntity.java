package com.passkeep.data;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "group_structure", schema = "public", catalog = "PassKeep")
@Data
public class GroupStructureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private GroupRoleEntity role;
}
