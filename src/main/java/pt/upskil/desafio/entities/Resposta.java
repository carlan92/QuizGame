package pt.upskil.desafio.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Resposta {

    @Id
    private long id;
    @ManyToOne
    private Pergunta pergunta;
    private String texto;
    private boolean certa;

    public Resposta() {
    }
}
