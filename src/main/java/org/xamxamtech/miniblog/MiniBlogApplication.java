package org.xamxamtech.miniblog;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xamxamtech.miniblog.dao.PostRepository;
import org.xamxamtech.miniblog.dao.UserRepository;
import org.xamxamtech.miniblog.entities.Post;
import org.xamxamtech.miniblog.entities.User;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class MiniBlogApplication implements CommandLineRunner {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(MiniBlogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Ajout de 10 utilisateurs
        for(int i=0;i<10;i++) {
            userRepository.save(new User(null,RandomString.make(5), RandomString.make(8), null));
        }
        //Ajout de 10 posts, 1 pour chaque utilisateur
        Random rnd = new Random();
        userRepository.findAll().forEach(u->{
            Post p = new Post();
            p.setAuthor(1+rnd.nextInt(10000));
            p.setDate(new Date());
            p.setContent(RandomString.make(20+rnd.nextInt(100)));
            p.setTitle(RandomString.make(10));
            p.setStatus(RandomString.make(18));
            p.setName(RandomString.make(10));
            p.setType(RandomString.make(10));
            p.setCategory(RandomString.make(10));
            p.setUser(u);
            postRepository.save(p);
        }
        );
    }
}
