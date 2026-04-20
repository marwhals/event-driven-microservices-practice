package reactive.elastic.query.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "microservice.practice")
public class ReactiveElasticQuertServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReactiveElasticQuertServiceApplication.class, args);
    }

}
