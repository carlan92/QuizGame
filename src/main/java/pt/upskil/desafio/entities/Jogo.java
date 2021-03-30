package pt.upskil.desafio.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "jogo")
    private List<Ronda> rondas;

    @OneToOne
    private Ronda rondaAtual;

    private int gameScore;

    // Constructors
    public Jogo() {
    }

    public int getGameScore(List<Ronda> rondas){
        for(Ronda ronda: rondas){
            gameScore+=ronda.getScore();
        }
        return gameScore;
    }
}