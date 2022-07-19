package com.example.biblior;

        import com.example.biblior.entities.*;
        import com.example.biblior.repositories.PrintedRepository;
        import com.example.biblior.repositories.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BibliorApplication.class, args);
    }
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PrintedRepository printedRepository;
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        printedRepository.deleteAll();
        userRepository.save(new Librarian("Drake", "Ramorey", "123123@email.com", "qwerty"));
        userRepository.save(new WarehouseWorker("Droke", "Ramorey", "3q46@email.com", "qwerty"));
        userRepository.save(new Reader("Dan", "Ramorey", "3231@email.com", "qwerty"));
        printedRepository.save(new Article("LALA", "LALALA", 1999, 12, 20, "Neuroscience"));
        printedRepository.save(new Book("sfghshf", "asdkj", 1555, 12, 20, Genre.ADVENTURE.toString()));
    }
}
