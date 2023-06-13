package com.passkeep.models.data;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "password", schema = "public", catalog = "PassKeep")
@Data
public class Password {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String password;
}
