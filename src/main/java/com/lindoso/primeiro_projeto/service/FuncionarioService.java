package com.lindoso.primeiro_projeto.service;

import com.lindoso.primeiro_projeto.dto.FuncionarioDto;
import com.lindoso.primeiro_projeto.dto.FuncionarioResponseDto;
import com.lindoso.primeiro_projeto.entity.DepartamentoEntity;
import com.lindoso.primeiro_projeto.entity.FuncionarioEntity;
import com.lindoso.primeiro_projeto.repo.DepartamentoRepository;
import com.lindoso.primeiro_projeto.repo.FuncionarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepo;
    private final DepartamentoRepository departamentoRepo;

    public void cadastrarFuncionario(@Valid FuncionarioDto funcionarioDto) {
        if (funcionarioRepo.existsByEmail(funcionarioDto.getEmail())) {
            throw new RuntimeException("Email já cadastrado. ");
        }

        // foreign key id_departamento
        DepartamentoEntity departamento = departamentoRepo.findById(funcionarioDto.getId_departamento()).orElseThrow(() -> new RuntimeException("Departamento não existe. ") );

        FuncionarioEntity funcionarioEntity = new FuncionarioEntity();

        funcionarioEntity.setNome(funcionarioDto.getNome());
        funcionarioEntity.setEmail(funcionarioDto.getEmail());
        funcionarioEntity.setSenha(funcionarioDto.getSenha());
        funcionarioEntity.setSalario(funcionarioDto.getSalario());
        funcionarioEntity.setDepartamento(departamento);

        funcionarioRepo.save(funcionarioEntity);

    }

    public List<FuncionarioResponseDto> listarFuncionarios() {

        List<FuncionarioEntity> funcionarioEntityList = funcionarioRepo.findAll();

        List<FuncionarioResponseDto> funcionarioDtoList = new ArrayList<>();

        for (FuncionarioEntity f : funcionarioEntityList) {
            FuncionarioResponseDto funcionarioDto = new FuncionarioResponseDto();

            funcionarioDto.setIdFuncionario(f.getIdFuncionario());
            funcionarioDto.setNome(f.getNome());
//            funcionarioDto.setSenha(f.getSenha());
            funcionarioDto.setEmail(f.getEmail());
            funcionarioDto.setSalario(f.getSalario());
            funcionarioDto.setNomeDepartamento(f.getDepartamento().getNomeDepartamento());

            funcionarioDtoList.add(funcionarioDto);
        }
        return funcionarioDtoList;
    }

    public void atualizarFuncionario(int id, @Valid FuncionarioDto funcionarioDto) {
        FuncionarioEntity funcionarioEntity = funcionarioRepo.findById(id).orElseThrow(() -> new RuntimeException("Funcionário nâo existe. "));
        DepartamentoEntity departamento = departamentoRepo.findById(funcionarioDto.getId_departamento()).orElseThrow(() -> new RuntimeException("Departamento não existe. ") );

        if (funcionarioRepo.existsByEmailAndIdFuncionarioNot(funcionarioDto.getEmail(), id)) {
            throw new RuntimeException("Email já cadastrado. ");
        }

        funcionarioEntity.setIdFuncionario(id);
        funcionarioEntity.setNome(funcionarioDto.getNome());
        funcionarioEntity.setEmail(funcionarioDto.getEmail());
        funcionarioEntity.setSenha(funcionarioDto.getSenha());
        funcionarioEntity.setSalario(funcionarioDto.getSalario());
        funcionarioEntity.setDepartamento(departamento);

        funcionarioRepo.save(funcionarioEntity);
    }

    public void delatarFuncionario(int id) {
        funcionarioRepo.findById(id).orElseThrow(() -> new RuntimeException("Funcionário nâo existe. "));

        funcionarioRepo.deleteById(id);

    }

}
