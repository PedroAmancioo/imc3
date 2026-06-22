package com.example.imc2;

public class Usuario {
    private String nome;
    private String email;
    private double imc;
    private String status;

    public Usuario(String nome, String email, double imc, String status) {
        this.nome = nome;
        this.email = email;
        this.imc = imc;
        this.status = status;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public double getImc() { return imc; }
    public String getStatus() { return status; }
}

