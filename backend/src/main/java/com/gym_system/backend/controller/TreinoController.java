package com.gym_system.backend.controller;

import com.gym_system.backend.dto.TreinoDTO;
import com.gym_system.backend.service.TreinoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treinos")
public class TreinoController {

    private final TreinoService treinoService;

    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @GetMapping
    public List<TreinoDTO> listarTodos() {
        return treinoService.getAllTreinos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinoDTO> buscarPorId(@PathVariable Long id) {
        return treinoService.getTreinoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TreinoDTO criar(@Valid @RequestBody TreinoDTO dto) {
        return treinoService.createTreino(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody TreinoDTO dto) {
        return treinoService.updateTreino(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (treinoService.deleteTreino(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<TreinoDTO> concluir(@PathVariable Long id) {
        return treinoService.concluirTreino(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}