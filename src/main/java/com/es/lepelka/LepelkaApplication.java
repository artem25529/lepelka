package com.es.lepelka;

import com.es.lepelka.model.Authority;
import com.es.lepelka.model.User;
import com.es.lepelka.repository.AuthorityRepository;
import com.es.lepelka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class LepelkaApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(LepelkaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*User user = new User("artem", "artem", "marti", encoder.encode("password"), true, List.of(new Authority("ADMIN"), new Authority("USER")));

        userRepository.save(user);
        System.out.println();*/

    }
}
