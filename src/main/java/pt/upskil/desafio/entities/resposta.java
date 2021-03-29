package pt.upskil.desafio.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Pergunta pergunta;
    private String texto;
    private boolean certa;

    public Resposta() {
    }

    public Resposta(Pergunta pergunta, String texto, boolean certa) {
        this.pergunta = pergunta;
        this.texto = texto;
        this.certa = certa;
    }
}
