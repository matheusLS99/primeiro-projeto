package com.lindoso.primeiro_projeto.repo;

import com.lindoso.primeiro_projeto.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {

    boolean existsByEmail(String email);
    boolean existsByEmailAndIdFuncionarioNot(String email, int id);

    boolean existsByDepartamentoIdDepartamento(int idDepartamento);


}
