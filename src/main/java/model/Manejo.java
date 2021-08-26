package model;

import interfaces.ListagemAdicional;
import interfaces.ListagemFiltravel;
import interfaces.ListagemMaqueada;
import interfaces.ListagemParcial;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import utils.CampoFiltro;
import utils.DateUtils;
import utils.Lista;

/**
 * @author Ruan
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract public class Manejo extends Model implements ListagemParcial, ListagemFiltravel, ListagemAdicional, ListagemMaqueada {

    static public final Class TIPO_BAIXA              = Baixa.class;
    static public final Class TIPO_COBERTURA          = Cobertura.class;
    static public final Class TIPO_MEDICACAO          = Medicacao.class;
    static public final Class TIPO_PESAGEM            = Pesagem.class;
    static public final Class TIPO_TRANSFERENCIA_AREA = TransferenciaArea.class;

    static public final String _TIPO_BAIXA              = "Baixa";
    static public final String _TIPO_COBERTURA          = "Cobertura";
    static public final String _TIPO_MEDICACAO          = "Medicação";
    static public final String _TIPO_PESAGEM            = "Pesagem";
    static public final String _TIPO_TRANSFERENCIA_AREA = "Transferência de Área";
    
    @Id
    @GeneratedValue
    private int    id;
    private Date   data;
    private String observacoes;
    @ManyToOne
    @JoinColumn(name = "idanimal")
    private Animal animal;

    public Manejo() {
        this.setAnimal(new Animal());
    }

    public Manejo(Date data, String observacoes, Animal animal) {
        this.setData(data)
            .setObservacoes(observacoes)
            .setAnimal(animal);
    }

    public Manejo(int id, Date data, String observacoes, Animal animal) {
        this.setId(id)
            .setData(data)
            .setObservacoes(observacoes)
            .setAnimal(animal);
    }
    
    @Override
    public int getId() {
        return id;
    }

    public Manejo setId(int id) {
        this.id = id;
        return this;
    }

    public Date getData() {
        return data;
    }

    public Manejo setData(Date data) {
        this.data = data;
        return this;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public Manejo setObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Manejo setAnimal(Animal animal) {
        this.animal = animal;
        return this;
    }
    
    public String getDataConsulta() {
        return DateUtils.dateToString(this.getData());
    }
    
    static public ArrayList<Lista<Class, String>> getListaTipos() {
        ArrayList<Lista<Class, String>> retorno = new ArrayList<>();
        retorno.add(new Lista(TIPO_BAIXA,              _TIPO_BAIXA));
        retorno.add(new Lista(TIPO_COBERTURA,          _TIPO_COBERTURA));
        retorno.add(new Lista(TIPO_MEDICACAO,          _TIPO_MEDICACAO));
        retorno.add(new Lista(TIPO_PESAGEM,            _TIPO_PESAGEM));
        retorno.add(new Lista(TIPO_TRANSFERENCIA_AREA, _TIPO_TRANSFERENCIA_AREA));
        return retorno;
    }

    @Override
    public List<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("this$0");
        campos.add("TIPO_BAIXA");
        campos.add("TIPO_COBERTURA");
        campos.add("TIPO_MEDICACAO");
        campos.add("TIPO_PESAGEM");
        campos.add("TIPO_TRANSFERENCIA_AREA");
        campos.add("_TIPO_BAIXA");
        campos.add("_TIPO_COBERTURA");
        campos.add("_TIPO_MEDICACAO");
        campos.add("_TIPO_PESAGEM");
        campos.add("_TIPO_TRANSFERENCIA_AREA");
        campos.add("data");
        return campos;
    }

    @Override
    public ArrayList<CampoFiltro> getCamposFiltraveis() {
        ArrayList<CampoFiltro> campos = new ArrayList<>();
        campos.add(new CampoFiltro(Integer.class, "id"));
        campos.add(new CampoFiltro(Date.class,    "data"));
        campos.add(new CampoFiltro(String.class,  "observacoes", "Observações"));
        return campos;
    }

    @Override
    public List<String> getCamposAdicionar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("descricaoManejo");
        campos.add("dataConsulta");
        return campos;
    }

    @Override
    public Map<String, String> getTitulosColunas() {
        HashMap<String, String> titulos = new HashMap<>();
        titulos.put("descricaoManejo", "Descrição");
        titulos.put("data",            "Data");
        return titulos;
    }
    
    public String getDescricaoManejo() {
        return "Manejo sem descrição";
    }

}