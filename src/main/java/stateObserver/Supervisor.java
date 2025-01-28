package stateObserver;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Supervisor implements Observer {
    private String matricula;
    private String nome;
    private String ultimaNotificacao;

    public Supervisor(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getUltimaNotificacao(){
        return this.ultimaNotificacao;
    }

    public void supervisionar(FoodBatch foodBatch) {
        foodBatch.addObserver(this);
    }

    public void update(Observable foodBatch, Object arg ) {
        this.ultimaNotificacao = "O lote " + foodBatch.toString() + " foi enviado para reanálise!";
    }
}
