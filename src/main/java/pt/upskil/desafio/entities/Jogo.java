package pt.upskil.desafio.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Jogo {

    @Id
    private long id;
    private long user_id;
    @OneToMany
    private List<Ronda> rondas;
    @OneToOne
    private Ronda rondaAtual;

    public Jogo() {
    }

}
