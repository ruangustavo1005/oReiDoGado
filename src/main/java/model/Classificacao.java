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
public class Classificacao extends Model implements ListagemMaqueada, ListagemFiltravel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    private String descricao;

    public Classificacao() {
        
    }

    public Classificacao(String descricao) {
        this.setDescricao(descricao);
    }

    public Classificacao(int id, String descricao) {
        this.setId(id)
            .setDescricao(descricao);
    }

    @Override
    public int getId() {
        return id;
    }

    public Classificacao setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Classificacao setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
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
        campos.add(new CampoFiltro(String.class,  "descricao", "Descrição"));
        return campos;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Classificacao) {
//            return ((Classificacao) obj).getId() == this.getId();
//        }
//        return super.equals(obj);
//    }
    
}