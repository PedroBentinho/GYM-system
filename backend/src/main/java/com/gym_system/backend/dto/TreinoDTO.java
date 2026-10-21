package com.gym_system.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

// Documenta o DTO na interface Swagger.
@Schema(description = "DTO responsável pelos dados do treino")
public class TreinoDTO {

    // ID gerado pelo sistema, apenas para leitura.
    @Schema(description = "Identificador do treino",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    // Nome do exercício, obrigatório.
    @NotBlank(message = "O exercício é obrigatório")
    @Size(min = 2, max = 100,
          message = "O exercício deve ter entre 2 e 100 caracteres")
    @Schema(description = "Nome do exercício",
            example = "Supino reto")
    private String exercicio;

    // Quantidade de séries, deve ser maior que zero.
    @Positive(message = "As séries devem ser maiores que zero")
    @Schema(description = "Quantidade de séries",
            example = "4")
    private Integer series;

    // Quantidade de repetições, deve ser maior que zero.
    @Positive(message = "As repetições devem ser maiores que zero")
    @Schema(description = "Quantidade de repetições",
            example = "12")
    private Integer repeticoes;

    // Grupo muscular trabalhado.
    @Schema(description = "Grupo muscular",
            example = "Peito")
    private String grupoMuscular;

    // Indica se foi feito hoje.
    private boolean feitohoje;

    // Construtor vazio para o Spring ler o JSON recebido.
    public TreinoDTO() {
    }

    // Construtor usado para criar o DTO com os dados do treino.
    public TreinoDTO(Long id, String exercicio, Integer series,
                     Integer repeticoes, String grupoMuscular,
                     boolean feitohoje) {
        this.id = id;
        this.exercicio = exercicio;
        this.series = series;
        this.repeticoes = repeticoes;
        this.grupoMuscular = grupoMuscular;
        this.feitohoje = feitohoje;
    }

    // Retorna o ID do treino.
    public Long getId() {
        return id;
    }

    // Retorna o nome do exercício.
    public String getExercicio() {
        return exercicio;
    }

    // Retorna a quantidade de séries.
    public Integer getSeries() {
        return series;
    }

    // Retorna a quantidade de repetições.
    public Integer getRepeticoes() {
        return repeticoes;
    }

    // Retorna o grupo muscular.
    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    // Retorna se foi feito hoje.
    public boolean isFeitohoje() {
        return feitohoje;
    }

    // Define o ID do treino.
    public void setId(Long id) {
        this.id = id;
    }

    // Define o nome do exercício.
    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    // Define a quantidade de séries.
    public void setSeries(Integer series) {
        this.series = series;
    }

    // Define a quantidade de repetições.
    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }

    // Define o grupo muscular.
    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    // Define se foi feito hoje.
    public void setFeitohoje(boolean feitohoje) {
        this.feitohoje = feitohoje;
    }
}