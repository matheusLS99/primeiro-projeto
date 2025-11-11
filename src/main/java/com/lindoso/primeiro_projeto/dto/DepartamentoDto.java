package com.lindoso.primeiro_projeto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartamentoDto {
    private int id_departamento;

    @NotBlank
    @Size(max = 50)
    private String nomeDepartamento;
}
