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

    // Nome obrigatório do treino.
    @NotBlank(message = "O nome do treino é obrigatório")
    @Size(min = 2, max = 100,
          message = "O nome deve ter entre 2 e 100 caracteres")
    @Schema(description = "Nome do treino",
            example = "Treino de Peito")
    private String nome;

    // Descrição do treino.
    @NotBlank(message = "A descrição do treino é obrigatória")
    @Schema(description = "Descrição do treino",
            example = "Treino focado em peito e tríceps")
    private String descricao;

    // Duração do treino em minutos, deve ser maior que zero.
    @Positive(message = "A duração deve ser maior que zero")
    @Schema(description = "Duração do treino em minutos",
            example = "60")
    private Integer duracaoMinutos;

    // Construtor usado para criar o DTO com os dados do treino.
    public TreinoDTO(Long id, String nome,
                     String descricao, Integer duracaoMinutos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
    }

    // Retorna o ID do treino.
    public Long getId() {
        return id;
    }

    // Retorna o nome do treino.
    public String getNome() {
        return nome;
    }

    // Retorna a descrição do treino.
    public String getDescricao() {
        return descricao;
    }

    // Retorna a duração do treino.
    public Integer getDuracaoMinutos() {
        return duracaoMinutos;
    }

    // Define o ID do treino.
    public void setId(Long id) {
        this.id = id;
    }

    // Define o nome do treino.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Define a descrição do treino.
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Define a duração do treino.
    public void setDuracaoMinutos(Integer duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
}