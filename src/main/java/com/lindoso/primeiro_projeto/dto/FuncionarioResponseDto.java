package com.lindoso.primeiro_projeto.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FuncionarioResponseDto {
    private int idFuncionario;
    private String nome;
    private String email;
    private double salario;

    private String nomeDepartamento;
}
