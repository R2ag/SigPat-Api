package com.api.sigpat.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "TB_AMBIENTE")
@Data
public class Ambiente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;
    @ManyToOne
    @JoinColumn(name = "filiacao_id", nullable = true)
    private Ambiente filiacao;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String Estado;

}
