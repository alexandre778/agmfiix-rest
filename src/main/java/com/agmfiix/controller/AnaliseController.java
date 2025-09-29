package com.agmfiix.controller;

import com.agmfiix.model.Analise;
import com.agmfiix.service.AnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analises")
public class AnaliseController {

    @Autowired
    private AnaliseService analiseService;

    // GET - Listar todas as análises
    @GetMapping
    public ResponseEntity<List<Analise>> listarTodas() {
        List<Analise> analises = analiseService.listarTodos();
        return ResponseEntity.ok(analises);
    }

    // GET - Buscar análise por ID
    @GetMapping("/{id}")
    public ResponseEntity<Analise> buscarPorId(@PathVariable Long id) {
        Analise analise = analiseService.buscarPorId(id);
        if (analise == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(analise);
    }

    // POST - Criar nova análise
    @PostMapping
    public ResponseEntity<Analise> criarAnalise(@RequestBody Analise analise) {
        Analise novaAnalise = analiseService.salvar(analise);
        return ResponseEntity.ok(novaAnalise);
    }

    // PUT - Atualizar análise existente
    @PutMapping("/{id}")
    public ResponseEntity<Analise> atualizarAnalise(@PathVariable Long id, @RequestBody Analise analiseAtualizada) {
        Analise analise = analiseService.atualizar(id, analiseAtualizada);
        if (analise == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(analise);
    }

    // DELETE - Excluir análise
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnalise(@PathVariable Long id) {
        boolean removido = analiseService.deletar(id);
        if (!removido) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
