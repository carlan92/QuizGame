package pt.upskil.desafio.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ronda {

    @Id
    private long id;
    private int numero;
    @OneToOne
    private Pergunta pergunta;
    @OneToOne
    private Resposta respostaEscolhida;
    @ManyToOne
    private Jogo jogo;

    public Ronda() {
    }
}
