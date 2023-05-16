package com.passkeep.data;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "password", schema = "public", catalog = "PassKeep")
@Data
public class PasswordEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String password;
}
