package com.gym_system.backend.mapper;

import com.gym_system.backend.dto.TreinoDTO;
import com.gym_system.backend.model.Treino;

// Classe utilitária com métodos estáticos — não deve ser instanciada
public class TreinoMapper {

    private TreinoMapper() {}

    // Converte uma entidade Treino em DTO para ser enviado como resposta da API
    public static TreinoDTO toDTO(Treino treino) {
        return new TreinoDTO(
                treino.getId(),
                treino.getExercicio(),
                treino.getSeries(),
                treino.getrepeticoes(),
                treino.grupoMuscular(),
                treino.isFeitohoje()
        );
    }

    // Converte um DTO recebido na requisição em entidade para ser salva no banco
    // O ID não é passado pois ainda não existe — o banco vai gerar na hora do save
    public static Treino toEntity(TreinoDTO treinoDTO) {
        Treino treino = new Treino();
        treino.setExercicio(treinoDTO.getExercicio());
        treino.setSeries(treinoDTO.getSeries());
        treino.setrepeticoes(treinoDTO.getRepeticoes());
        treino.setGrupoMuscular(treinoDTO.getGrupoMuscular());
        treino.setfeitohoje(treinoDTO.isFeitohoje());
        return treino;
    }
}