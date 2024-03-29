package br.com.eduardoformiga.minicms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MiniCmsApplication {

    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication.run(MiniCmsApplication.class, args);
    }

    @PostConstruct
    public void setUp() {
        objectMapper.findAndRegisterModules();
    }

}
