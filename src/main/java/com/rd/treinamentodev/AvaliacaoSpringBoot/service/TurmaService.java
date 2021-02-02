package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.InstrutorDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.InstrutorEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.InstrutorRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public List<TurmaDTO> listar() {
        List<TurmaEntity> listEntity = turmaRepository.findAll();
        List<TurmaDTO> listDTO = new ArrayList<>();

        for (TurmaEntity turmaEntity : listEntity) {
            TurmaDTO turmaDTO = new TurmaDTO();
            CursoDTO cursoDTO = new CursoDTO();
            CursoEntity cursoEntity = new CursoEntity();
            cursoDTO.setNome(cursoEntity.getNomeCurso());

            turmaDTO.setCurso(cursoDTO);
            turmaDTO.setDtInicio(turmaEntity.getDtInicio().toString());
            turmaDTO.setDtFim(turmaEntity.getDtFinal().toString());

            List<InstrutorEntity> instrutoresEntity = turmaEntity.getInstrutores();

            List<InstrutorDTO> instrutoresDTO = new ArrayList<>();
            for(InstrutorEntity instrutorEntity : instrutoresEntity){
                InstrutorDTO instrutor = new InstrutorDTO();
                instrutor.setNome(instrutorEntity.getNomeInstrutor());
                instrutor.setValorHora(instrutorEntity.getValorHora());

                instrutoresDTO.add(instrutor);
            }

            turmaDTO.setInstrutores(instrutoresDTO);

            List<AlunoEntity> alunosEntity = turmaEntity.getAlunos();

            List<AlunoDTO> alunosDTO = new ArrayList<>();
            for(AlunoEntity alunoEntity : alunosEntity){
                AlunoDTO aluno = new AlunoDTO();
                aluno.setNome(alunoEntity.getNomeAluno());
                aluno.setCpf(alunoEntity.getCpf());

                alunosDTO.add(aluno);
            }

            turmaDTO.setAlunos(alunosDTO);

            listDTO.add(turmaDTO);
        }
        return listDTO;
    }
}