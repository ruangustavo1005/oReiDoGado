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
public class Medicacao extends Manejo {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idmedicamento")
    private Medicamento   medicamento;
    private float         quantidade;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idunidademedida")
    private UnidadeMedida unidadeMedida;

    public Medicacao() {
        super();
        this.setMedicamento(new Medicamento())
            .setUnidadeMedida(new UnidadeMedida());
    }

    public Medicacao(Date data, String observacoes, Animal animal, Medicamento medicamento, float quantidade, UnidadeMedida unidadeMedida) {
        super(data, observacoes, animal);
        this.setMedicamento(medicamento)
            .setQuantidade(quantidade)
            .setUnidadeMedida(unidadeMedida);
    }

    public Medicacao(int id, Date data, String observacoes, Animal animal, Medicamento medicamento, float quantidade, UnidadeMedida unidadeMedida) {
        super(id, data, observacoes, animal);
        this.setMedicamento(medicamento)
            .setQuantidade(quantidade)
            .setUnidadeMedida(unidadeMedida);
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public Medicacao setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
        return this;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public Medicacao setQuantidade(float quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public Medicacao setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
        return this;
    }

}