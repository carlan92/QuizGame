package pt.upskil.desafio.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

@Getter
@Entity
public enum Dificuldade {
    FACIL("fácil", 1, Duration.ofSeconds(20), 50),
    MEDIA("média", 2, Duration.ofSeconds(30), 75),
    DIFICIL("difícil", 3, Duration.ofSeconds(40), 100),
    IMPOSSIVEL("impossível", 4, Duration.ofSeconds(60), 200);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String apiText;
    private int type;
    private Duration duration; //Em segundos
    private int pontos;

    Dificuldade(String apiText, int type, Duration duration, int pontos) {
        this.apiText = apiText;
        this.type = type;
        this.duration = duration;
        this.pontos = pontos;
    }

    public static Dificuldade getDifficuldadeFromApiText(String apiText) {
        for (Dificuldade dificuldade : Dificuldade.values()) {
            if (dificuldade.apiText.equals(apiText)) {
                return dificuldade;
            }
        }
        return null;
    }
}

