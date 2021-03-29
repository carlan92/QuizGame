package pt.upskil.desafio.services.apiUtils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListaPerguntasResponse {

    List<PerguntaResponse> perguntas;
    public String status;
    public String error;

}
