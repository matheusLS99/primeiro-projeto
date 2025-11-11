package com.lindoso.primeiro_projeto.service;

import com.lindoso.primeiro_projeto.dto.DepartamentoDto;
import com.lindoso.primeiro_projeto.dto.FuncionarioDto;
import com.lindoso.primeiro_projeto.entity.DepartamentoEntity;
import com.lindoso.primeiro_projeto.repo.DepartamentoRepository;
import com.lindoso.primeiro_projeto.repo.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepo;

    @Autowired
    private FuncionarioRepository funcionarioRepo;

    // :: CRUD ::

    // Create
    public void cadastrarDepartamento(@Valid DepartamentoDto departamentoDto) {
        DepartamentoEntity departamentoEntity = new DepartamentoEntity();
        departamentoEntity.setNomeDepartamento(departamentoDto.getNomeDepartamento());

        departamentoRepo.save(departamentoEntity);
    }

    // Read
    public List<DepartamentoDto> listarDepartamentos() {
        List<DepartamentoEntity> listaDepartamentoEntity = departamentoRepo.findAll();

        List<DepartamentoDto> listaDepartamentoDto = new ArrayList<>();

        for (DepartamentoEntity d : listaDepartamentoEntity) {
            DepartamentoDto departamentoDto = new DepartamentoDto();

            departamentoDto.setId_departamento(d.getIdDepartamento());
            departamentoDto.setNomeDepartamento(d.getNomeDepartamento());

            listaDepartamentoDto.add(departamentoDto);
        }

        return listaDepartamentoDto;
    }

    // Update
    public void atualizarDepartamento(int id, @Valid DepartamentoDto departamentoDto) {
                                                // Validaçao
        DepartamentoEntity departamentoEntity = departamentoRepo.findById(id).orElseThrow(() -> new RuntimeException("Departamento não existe. "));

        departamentoEntity.setNomeDepartamento(departamentoDto.getNomeDepartamento());

        departamentoRepo.save(departamentoEntity);

    }

    // Delete
    public void deletarDepartamento(int id) {
        // Validaçao
        departamentoRepo.findById(id).orElseThrow(() -> new RuntimeException("Departamento não existe. "));

        if (funcionarioRepo.existsByDepartamentoIdDepartamento(id)) {
            throw new RuntimeException("Departamento possui funcionario(s) cadastrados. ");
        }

        departamentoRepo.deleteById(id);

    }

}
