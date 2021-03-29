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
    private long user_id;
    @OneToMany
    private List<Ronda> rondas;
    @OneToOne
    private Ronda rondaAtual;
    public Jogo() {
    }
}