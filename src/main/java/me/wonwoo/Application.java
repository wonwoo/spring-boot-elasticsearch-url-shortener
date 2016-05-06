package me.wonwoo;

import me.wonwoo.shrotener.domain.Sequence;
import me.wonwoo.shrotener.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Autowired
  private SequenceRepository sequenceRepository;

  @Bean
  public CommandLineRunner commandLineRunner() {
    return args -> {
      Sequence sequence = sequenceRepository.findOne("urlShort");
      if (sequence == null) {
        sequence = new Sequence("urlShort", 1L);
        sequenceRepository.save(sequence);
      }
    };
  }
}
