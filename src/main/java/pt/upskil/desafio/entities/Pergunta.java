package pt.upskil.desafio.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter

public class Pergunta {

    public static final int NUM_RESPOSTAS = 4;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    @OneToMany
    List<Resposta> respostas;
    @ManyToOne
    Dificuldade dificuldade;

    public Pergunta() {
    }

    @Override
    public String toString() {
        return "Pergunta{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", dificuldade=" + dificuldade +
                '}';
    }
}