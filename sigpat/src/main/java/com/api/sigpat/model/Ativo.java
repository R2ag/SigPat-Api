package com.api.sigpat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_ATIVO")
@Getter
@Setter
public class Ativo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String idPatrimonio;
    @ManyToOne
    @JoinColumn(name = "tipo_ativo_id")
    private TipoAtivo tipoAtivo;

}
