package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "TB_MODULO")
@Data
public class ModuloEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_MODULO")
    private BigInteger idModulo;

    @Column (name = "DS_NOME")
    private String dsNome;

    @ManyToOne
    @JoinColumn (name = "ID_INSTRUTOR")
    private InstrutorEntity instrutor;

}
