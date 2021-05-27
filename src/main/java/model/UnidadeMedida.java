package model;

import interfaces.ListagemFiltravel;
import interfaces.ListagemMaqueada;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import utils.CampoFiltro;

/**
 * @author Ruan
 */
@Entity
public class UnidadeMedida extends Model implements ListagemMaqueada, ListagemFiltravel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    private String descricao;
    private String sigla;

    public UnidadeMedida() {
        
    }

    public UnidadeMedida(String descricao, String sigla) {
        this.setDescricao(descricao)
            .setSigla(sigla);
    }

    public UnidadeMedida(int id, String descricao, String sigla) {
        this.setId(id)
            .setDescricao(descricao)
            .setSigla(sigla);
    }

    @Override
    public int getId() {
        return id;
    }

    public UnidadeMedida setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public UnidadeMedida setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getSigla() {
        return sigla;
    }

    public UnidadeMedida setSigla(String sigla) {
        this.sigla = sigla;
        return this;
    }

    @Override
    public String toString() {
        return this.getSigla();
    }

    @Override
    public Map<String, String> getTitulosColunas() {
        Map<String, String> colunas = new HashMap<>();
        colunas.put("descricao", "Descrição");
        return colunas;
    }

    @Override
    public ArrayList<CampoFiltro> getCamposFiltraveis() {
        ArrayList<CampoFiltro> campos = new ArrayList<>();
        campos.add(new CampoFiltro(Integer.class, "id"));
        campos.add(new CampoFiltro(String.class,  "sigla"));
        campos.add(new CampoFiltro(String.class,  "descricao", "Descrição"));
        return campos;
    }

}