package pt.upskil.desafio.services;

import org.springframework.security.core.GrantedAuthority;
import pt.upskil.desafio.configuration.Role;
import pt.upskil.desafio.entities.User;

import java.util.List;

public interface UserService {

    boolean validateUser(String username, String password);

    void addUser(User user);

    User findByUsername(String username);

    User findByUserId(Long userId);

    User findUser(String username);

    User currentUser();

    List<GrantedAuthority> getAuthorities(String username);

    Role getUserRole(User user);

    String getUserMainPage(User user);

    boolean validateUserMail(String username, String email);
}
