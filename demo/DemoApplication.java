package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}

@RestController
class HealthController {
  @GetMapping("/healthz")
  public String healthCheck() {
    return "Application is healthy!";
  }

  @GetMapping("/readyz")
  public String readinessCheck() {
    return "Application is ready!";
  }
}
