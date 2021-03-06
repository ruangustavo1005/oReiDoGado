 package model;

import java.util.Date;
import javax.persistence.Entity;
import utils.NumberUtils;

/**
 * @author Ruan
 */
@Entity
public class Pesagem extends Manejo {

    private float peso;

    public Pesagem() {
        super();
    }

    public Pesagem(Date data, String observacoes, Animal animal, float peso) {
        super(data, observacoes, animal);
        this.setPeso(peso);
    }

    public Pesagem(int id, Date data, String observacoes, Animal animal, float peso) {
        super(id, data, observacoes, animal);
        this.setPeso(peso);
    }
    
    public float getPeso() {
        return peso;
    }

    public Pesagem setPeso(float peso) {
        this.peso = peso;
        return this;
    }

    @Override
    public String getDescricaoManejo() {
        return "Pesagem de " + NumberUtils.formataValor(this.getPeso(), 2, true) + " KG";
    }
    
}