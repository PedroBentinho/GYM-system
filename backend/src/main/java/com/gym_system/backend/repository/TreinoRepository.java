// pacote onde fica o repository
package com.gym_system.backend.repository;

// interface do Spring Data JPA que fornece os métodos de acesso ao banco
import org.springframework.data.jpa.repository.JpaRepository;
// anotação que marca a interface como repository do Spring
import org.springframework.stereotype.Repository;

// entidade Treino, que representa a tabela de treinos no banco
import com.gym_system.backend.model.Treino;

// indica que é um repository
@Repository

// interface que herda do JpaRepository, usando a entidade Treino e o id do tipo Long
public interface TreinoRepository extends JpaRepository<Treino, Long> {
}