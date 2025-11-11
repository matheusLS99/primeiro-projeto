package com.lindoso.primeiro_projeto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departamento")

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private int idDepartamento;

    @Column(name = "nm_departamento")
    private String nomeDepartamento;

}
