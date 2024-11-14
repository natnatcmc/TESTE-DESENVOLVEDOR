package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostMapping("/dados")
    public Response mensagem(@RequestBody Request request) {
        if (request.getIdade() < 0) {
            return new Response(false, "A idade não pode ser menor que zero");
        }
        return new Response(true, "Olá, " + request.getNome() + " de " + request.getIdade() + " anos! Amanhã será " + request.getData());
    }
}

class Request {
    private String nome;
    private int idade;
    private String data;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
}

class Response {
    private boolean success;
    private String message;

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // Getters e Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
