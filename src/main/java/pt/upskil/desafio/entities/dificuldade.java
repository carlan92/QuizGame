package pt.upskil.desafio.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Duration;

@Entity
public class Dificuldade {

    @Id
    private long id;
    private String nome;
    private double pontos;
    private Duration tempo;

    public Dificuldade() {
    }

}
