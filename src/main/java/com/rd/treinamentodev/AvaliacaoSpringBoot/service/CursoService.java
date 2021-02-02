package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    @Transactional
    public String cadastrar(CursoDTO curso){
        CursoEntity entity = new CursoEntity();
        entity.setNomeCurso(curso.getNome());
        entity.setNrCargaHoraria(curso.getCargaHoraria());
        repository.save(entity);

        System.out.println(curso.getNome() + " . " + curso.getCargaHoraria());

        return "Curso cadastrado com sucesso";
    }
}
