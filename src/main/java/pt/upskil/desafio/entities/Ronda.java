package pt.upskil.desafio.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Ronda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numero;

    @OneToOne
    private Pergunta pergunta;

    @OneToOne
    private Resposta respostaEscolhida;

    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;
    private int score;



    public Ronda() {
    }

    public int getScore(Dificuldade difficult,Resposta resposta, int secondsLeft) {
        if (resposta.isCerta()) {
            return secondsLeft + difficult.getPontos();

        }
        return 0;
    }
}