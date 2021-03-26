package pt.upskil.desafio.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Pergunta {

    @Id
    private long id;
    private String descricao;
    @OneToMany
    List<Resposta> respostas;
    @ManyToOne
    Dificuldade dificuldade;

    public Pergunta() {
    }

}
