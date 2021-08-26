package model;

import java.util.Date;
import javax.persistence.Entity;
import utils.DateUtils;

/**
 * @author Ruan
 */
@Entity
public class Cobertura extends Manejo {

    private Date dataEntrada;
    private Date dataProvavelSaida;

    public Cobertura() {
        super();
    }

    public Cobertura(Date data, String observacoes, Animal animal, Date dataEntrada, Date dataProvavelSaida) {
        super(data, observacoes, animal);
        this.setDataEntrada(dataEntrada)
            .setDataProvavelSaida(dataProvavelSaida);
    }

    public Cobertura(int id, Date data, String observacoes, Animal animal, Date dataEntrada, Date dataProvavelSaida) {
        super(id, data, observacoes, animal);
        this.setDataEntrada(dataEntrada)
            .setDataProvavelSaida(dataProvavelSaida);
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Cobertura setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
        return this;
    }

    public Date getDataProvavelSaida() {
        return dataProvavelSaida;
    }

    public Cobertura setDataProvavelSaida(Date dataProvavelSaida) {
        this.dataProvavelSaida = dataProvavelSaida;
        return this;
    }

    @Override
    public String getDescricaoManejo() {
        return "Cobertura de " + DateUtils.dateToString(this.getDataEntrada()) + " até " + DateUtils.dateToString(this.getDataProvavelSaida());
    }
    
}