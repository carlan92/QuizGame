package pt.upskil.desafio.entities;

import lombok.Getter;

import java.time.Duration;

@Getter
public enum Dificuldade {
    FACIL("fácil", "Fácil", 1, Duration.ofSeconds(20), 50),
    MEDIA("média","Média", 2, Duration.ofSeconds(30), 75),
    DIFICIL("difícil","Difícil", 3, Duration.ofSeconds(40), 100),
    IMPOSSIVEL("impossível","Impossível", 4, Duration.ofSeconds(60), 200);


    private final String apiText;
    private final String buttonText;
    private final int type;
    private final Duration duration;
    private final int pontos;

    Dificuldade(String apiText, String buttonText, int type, Duration duration, int pontos) {
        this.apiText = apiText;
        this.buttonText = buttonText;
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