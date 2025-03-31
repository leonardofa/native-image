package br.com.leonardo.estudos.springbootgraalvm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringbootGraalvmApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootGraalvmApplication.class, args);
  }

  @Value("${DB_HOST}")
  private String dbHost;

  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationReadyEvent() {
    System.out.println("DB_HOST value: " + dbHost);
  }

}
