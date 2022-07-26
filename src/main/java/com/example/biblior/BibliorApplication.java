package com.example.biblior;

        import com.example.biblior.entities.*;
        import com.example.biblior.repositories.PrintedRepository;
        import com.example.biblior.repositories.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliorApplication.class, args);
    }
}
