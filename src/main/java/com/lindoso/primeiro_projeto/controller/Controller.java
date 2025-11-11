package com.lindoso.primeiro_projeto.controller;

import com.lindoso.primeiro_projeto.dto.DepartamentoDto;
import com.lindoso.primeiro_projeto.dto.FuncionarioDto;
import com.lindoso.primeiro_projeto.service.DepartamentoService;
import com.lindoso.primeiro_projeto.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Controller implements CommandLineRunner {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private FuncionarioService funcionarioService;

    @Override
    public void run(String... args) throws Exception {
        DepartamentoDto departamentoDto = new DepartamentoDto();

        // Create:
//        departamentoDto.setNomeDepartamento("Marketing");
//        departamentoService.cadastrarDepartamento(departamentoDto);

        // Read:
//        System.out.println(departamentoService.listarDepartamentos());

//        Update:
//        departamentoDto.setNomeDepartamento("");
//        departamentoService.atualizarDepartamento(, departamentoDto);

//         Delete:
//         departamentoService.deletarDepartamento(1);

        // ---------------------------------------------------------------------------------------
//
//        FuncionarioDto funcionarioDto = new FuncionarioDto();
//
//        funcionarioDto.setNome("Gilberto");
//        funcionarioDto.setSenha("hu7g");
//        funcionarioDto.setEmail("gilb777@gmail.com");
//        funcionarioDto.setSalario(2500);
//        funcionarioDto.setId_departamento(1);
//
        System.out.println(funcionarioService.listarFuncionarios());
    }
}
