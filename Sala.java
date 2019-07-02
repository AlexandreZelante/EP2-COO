/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep2coo;

/**
 *
 * @author alexa
 */
public class Sala {
    String nome;
    String local;
    int capacidade;
    String observacoes;
    
    public Sala(String nome, int capacidade, String observacoes){
        this.nome = nome;
        this.capacidade = capacidade;
        this.observacoes = observacoes;
    }
    
    public Sala(String nome, String local, int capacidade, String observacoes){
        this.nome = nome;
        this.local = local;
        this.capacidade = capacidade;
        this.observacoes = observacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getObservacoes() {
        return observacoes;
    }
}
