package com.agmfiix.service;

import com.agmfiix.model.Analise;
import com.agmfiix.repository.AnaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnaliseService {

    @Autowired
    private AnaliseRepository analiseRepository;

    // Listar todas as análises
    public List<Analise> listarTodos() {
        return analiseRepository.findAll();
    }

    // Buscar análise por ID
    public Analise buscarPorId(Long id) {
        return analiseRepository.findById(id).orElse(null);
    }

    // Salvar nova análise
    public Analise salvar(Analise analise) {
        return analiseRepository.save(analise);
    }

    // Atualizar análise existente
    public Analise atualizar(Long id, Analise analiseAtualizada) {
        Optional<Analise> optional = analiseRepository.findById(id);
        if (optional.isPresent()) {
            Analise existente = optional.get();
            existente.setFilmeId(analiseAtualizada.getFilmeId());
            existente.setAnalise(analiseAtualizada.getAnalise());
            existente.setNota(analiseAtualizada.getNota());
            existente.setComentario(analiseAtualizada.getComentario());
            return analiseRepository.save(existente);
        }
        return null;
    }

    // Deletar análise por ID
    public boolean deletar(Long id) {
        if (analiseRepository.existsById(id)) {
            analiseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
