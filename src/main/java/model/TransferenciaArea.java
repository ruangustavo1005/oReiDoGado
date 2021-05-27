package model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Ruan
 */
@Entity
public class TransferenciaArea extends Manejo {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idarea")
    private Area area;

    public TransferenciaArea() {
        super();
    }

    public TransferenciaArea(Date data, String observacoes, Animal animal, Area area) {
        super(data, observacoes, animal);
        this.setArea(area);
    }

    public TransferenciaArea(int id, Date data, String observacoes, Animal animal, Area area) {
        super(id, data, observacoes, animal);
        this.setArea(area);
    }

    public Area getArea() {
        return area;
    }

    public TransferenciaArea setArea(Area area) {
        this.area = area;
        return this;
    }
    
}