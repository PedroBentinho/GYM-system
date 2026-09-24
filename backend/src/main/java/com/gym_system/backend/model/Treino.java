package com.gym_system.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Entity diz ao JPA q essa representa uma 
// tabela no banco de dados.
@Entity

// Define o nome da tabela q vai ser criada.
@Table(name = "treinos")
public class Treino {
        // ID marca essa campo como uma chave primaria
        @Id
        // @GeneratedValue diz q ira gerar id automático
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        // @column configura a tabela q sera criada bo banco de dados:
        // nullable = false significa q nao pode ser nulo
        @Column(nullable = false, length = 100)
        private String Exercicio;

        @Column(nullable = false)
        private Integer Series;

        @Column(nullable = false)
        private Integer repeticoes;

        @Column(length = 50)
        private String grupoMuscular;

        @Column(nullable = false)
        private boolean feitohoje = false;

        // Construtor vazio para o JPA instanciar a classe internamente
        public Treino() {
        }

        public long getId() {
                return id;
        }

        public String getExercicio() {
                return Exercicio;
        }

        public Integer getSeries() {
                return Series;
        }

        public Integer getrepeticoes() {
                return repeticoes;
        }

        public String grupoMuscular() {
                return grupoMuscular;
        }

        public void setfeitohoje(boolean feitohoje) {
                this.feitohoje = feitohoje;
        }

        public void setId(long id){
                this.id = id;
        }

        public void setExercicio(String Exercicio){
                this.Exercicio = Exercicio;
        }

        public void setSeries(Integer Series){
                this.Series = Series;
        }

        public void setrepeticoes(Integer repeticoes) {
                this.repeticoes = repeticoes;
        }

        @Override
        public String toString(){
                   return "[ id: " + id + " | Exercicio: " + Exercicio + " | Series: " + Series + " | repeticoes: " + repeticoes + " ]";
        }



}
