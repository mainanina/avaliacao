package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public ResponseEntity gravar(AlunoDTO aluno){
        AlunoEntity entity = new AlunoEntity();

        List<AlunoEntity> cpfs = alunoRepository.findByCpf(aluno.getCpf());
        System.out.println(cpfs);

        if (cpfs.size()==0){
            entity.setNomeAluno(aluno.getNome());
            entity.setCpf(aluno.getCpf());
            entity = alunoRepository.save(entity);

            ResultData resultData = new ResultData(HttpStatus.CREATED.value(), "Aluno cadastrado com sucesso", entity.getIdAluno());
            return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O CPF já está cadastrado");
        }



    }
}
