package com.passkeep.models.data;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "group_structure", schema = "public", catalog = "PassKeep")
@Data
public class GroupStructure {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private GroupRole role;
}
