package com.lindoso.primeiro_projeto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcionario")

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private int idFuncionario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "salario")
    private double salario;

    @ManyToOne
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    private DepartamentoEntity departamento;


}
