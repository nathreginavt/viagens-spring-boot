package com.fatecrl.viagens.exception;

import java.time.LocalDateTime;
import java.util.List;

public class APIError {
    private int status;
    private LocalDateTime dataHora;
    private String path;
    private String mensagem;
    private List<ErrorField> campo;

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public List<ErrorField> getCampo() {
        return campo;
    }
    public void setCampo(List<ErrorField> campo) {
        this.campo = campo;
    }

}
