package pt.upskil.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.upskil.desafio.entities.Jogo;
import pt.upskil.desafio.entities.User;
import pt.upskil.desafio.repositories.JogoRepository;

import java.util.List;

@Service
public class JogoServiceImpl implements JogoService{
    @Autowired
    JogoRepository jogoRepository;

    @Override
    public int highScore(User user){
        List<Jogo> jogos = jogoRepository.findAllByUserOrderByGameScoreDesc(user);
        if(jogos == null || jogos.isEmpty()){
            return 0;
        }
        return jogos.get(0).getGameScore();
    }

    @Override
    public List<Jogo> findAll() {
        return jogoRepository.findAll();
    }

}
