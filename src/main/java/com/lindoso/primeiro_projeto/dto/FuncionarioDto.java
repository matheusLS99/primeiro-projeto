package com.lindoso.primeiro_projeto.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FuncionarioDto {
    private int idFuncionario;

    @NotBlank
    @Size(max = 50)
    private String nome;

    @NotBlank
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 50)
    private String senha;

    @Digits(integer = 10, fraction = 2)
    @PositiveOrZero
    private double salario;

    private int id_departamento;

}
