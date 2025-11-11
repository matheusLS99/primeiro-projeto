package com.lindoso.primeiro_projeto.repo;

import com.lindoso.primeiro_projeto.entity.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Integer> {



}
