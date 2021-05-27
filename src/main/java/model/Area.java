package model;

import interfaces.ListagemAdicional;
import interfaces.ListagemFiltravel;
import interfaces.ListagemMaqueada;
import interfaces.ListagemParcial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import utils.CampoFiltro;
import utils.NumberUtils;

/**
 * @author Ruan
 */
@Entity
public class Area extends Model implements ListagemMaqueada, ListagemFiltravel, ListagemParcial, ListagemAdicional {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int           id;
    private String        descricao;
    private float         areaOcupada;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idunidademedida")
    private UnidadeMedida unidadeMedida;

    public Area() {
        this.setUnidadeMedida(new UnidadeMedida());
    }

    public Area(String descricao, float areaOcupada, UnidadeMedida unidadeMedida) {
        this.setDescricao(descricao)
            .setAreaOcupada(areaOcupada)
            .setUnidadeMedida(unidadeMedida);
    }

    public Area(int id, String descricao, float areaOcupada, UnidadeMedida unidadeMedida) {
        this.setId(id)
            .setDescricao(descricao)
            .setAreaOcupada(areaOcupada)
            .setUnidadeMedida(unidadeMedida);
    }

    @Override
    public int getId() {
        return id;
    }

    public Area setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Area setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public float getAreaOcupada() {
        return areaOcupada;
    }

    public Area setAreaOcupada(float areaOcupada) {
        this.areaOcupada = areaOcupada;
        return this;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public Area setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
        return this;
    }

    public String getAreaOcupadaConsulta() {
        return NumberUtils.formataValor(this.getAreaOcupada(), 2, true) + " " + this.getUnidadeMedida();
    }
    
    @Override
    public String toString() {
        return this.getDescricao();
    }

    @Override
    public Map<String, String> getTitulosColunas() {
        HashMap<String, String> titulos = new HashMap<>();
        titulos.put("descricao", "Descrição");
        titulos.put("areaOcupadaConsulta", "Área Ocupada");
        return titulos;
    }

    @Override
    public ArrayList<CampoFiltro> getCamposFiltraveis() {
        ArrayList<CampoFiltro> filtros = new ArrayList<>();
        filtros.add(new CampoFiltro(Integer.class, "id"));
        filtros.add(new CampoFiltro(String.class,  "descricao",   "Descrição"));
        filtros.add(new CampoFiltro(Float.class,   "areaOcupada", "Área Ocupada"));
        return filtros;
    }

    @Override
    public List<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("areaOcupada");
        campos.add("unidadeMedida");
        return campos;
    }

    @Override
    public List<String> getCamposAdicionar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("areaOcupadaConsulta");
        return campos;
    }
    
}