package com.fatecrl.viagens.exception;

public class ErrorField {
    private String nome;
    private String mensagem;

    public ErrorField(String nome, String mensagem) {
        this.nome = nome;
        this.mensagem = mensagem; 
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
