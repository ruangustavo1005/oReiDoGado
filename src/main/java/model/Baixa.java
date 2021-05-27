package model;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import utils.Lista;

/**
 * @author Ruan
 */
@Entity
public class Baixa extends Manejo {

    static public int TIPO_BAIXA_VENDA  = 1;
    static public int TIPO_BAIXA_DOACAO = 2;
    static public int TIPO_BAIXA_MORTE  = 3;

    static public String _TIPO_BAIXA_VENDA  = "Venda";
    static public String _TIPO_BAIXA_DOACAO = "Doação";
    static public String _TIPO_BAIXA_MORTE  = "Morte";
    
    private int   tipo;
    private float valor;

    public Baixa() {
        super();
    }

    public Baixa(Date data, String observacoes, Animal animal, int tipo, float valor) {
        super(data, observacoes, animal);
        this.setTipo(tipo)
            .setValor(valor);
    }

    public Baixa(int id, Date data, String observacoes, Animal animal, int tipo, float valor) {
        super(id, data, observacoes, animal);
        this.setTipo(tipo)
            .setValor(valor);
    }

    public int getTipo() {
        return tipo;
    }

    public Baixa setTipo(int tipo) {
        this.tipo = tipo;
        return this;
    }

    public float getValor() {
        return valor;
    }

    public Baixa setValor(float valor) {
        this.valor = valor;
        return this;
    }
    
    static public ArrayList<Lista<Integer, String>> getListaTipoBaixa() {
        ArrayList<Lista<Integer, String>> lista = new ArrayList<>();
        lista.add(new Lista<>(TIPO_BAIXA_VENDA,  _TIPO_BAIXA_VENDA));
        lista.add(new Lista<>(TIPO_BAIXA_DOACAO, _TIPO_BAIXA_DOACAO));
        lista.add(new Lista<>(TIPO_BAIXA_MORTE,  _TIPO_BAIXA_MORTE));
        return lista;
    }
    
}