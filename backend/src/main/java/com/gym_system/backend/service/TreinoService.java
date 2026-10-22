package com.gym_system.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gym_system.backend.dto.TreinoDTO;
import com.gym_system.backend.mapper.TreinoMapper;
import com.gym_system.backend.repository.TreinoRepository;

@Service
public class TreinoService {

    // Componente usado pelo Service.
    private final TreinoRepository treinoRepository;

    // Inicializa o Repository.
    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    // Busca todos os treinos e transforma em DTO.
    public List<TreinoDTO> getAllTreinos() {
        return treinoRepository.findAll()
                .stream()
                .map(TreinoMapper::toDTO)
                .toList();
    }

    // Busca um treino pelo ID.
    public Optional<TreinoDTO> getTreinoById(Long id) {
        return treinoRepository.findById(id)
                .map(TreinoMapper::toDTO);
    }

    // Cria e salva um novo treino.
    public TreinoDTO createTreino(TreinoDTO treinoDTO) {
        return TreinoMapper.toDTO(
                treinoRepository.save(
                        TreinoMapper.toEntity(treinoDTO)
                )
        );
    }

    // Busca um treino pelo ID e atualiza seus dados.
    public Optional<TreinoDTO> updateTreino(Long id,
                                             TreinoDTO treinoDTO) {
        return treinoRepository.findById(id)
                .map(treino -> {
                    treino.setExercicio(treinoDTO.getExercicio());
                    treino.setSeries(treinoDTO.getSeries());
                    treino.setrepeticoes(treinoDTO.getRepeticoes());
                    treino.setGrupoMuscular(treinoDTO.getGrupoMuscular());
                    treino.setfeitohoje(treinoDTO.isFeitohoje());

                    return TreinoMapper.toDTO(
                            treinoRepository.save(treino)
                    );
                });
    }

      // Marca o treino como feito hoje.
    public Optional<TreinoDTO> concluirTreino(Long id) {
        return treinoRepository.findById(id)
                .map(treino -> {
                    treino.setfeitohoje(true);
                    return TreinoMapper.toDTO(
                            treinoRepository.save(treino)
                    );
                });
    }

    // Verifica se o treino existe e o exclui.
    public boolean deleteTreino(Long id) {
        if (!treinoRepository.existsById(id)) {
            return false;
        }

        treinoRepository.deleteById(id);
        return true;
    }
}