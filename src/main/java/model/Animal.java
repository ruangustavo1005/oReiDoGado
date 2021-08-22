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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import utils.CampoFiltro;
import utils.DateUtils;
import utils.NumberUtils;

/**
 * @author Ruan
 */
@Entity
public class Animal extends Model implements ListagemMaqueada, ListagemFiltravel, ListagemParcial, ListagemAdicional {

    static public final String SEXO_MACHO = "M";
    static public final String SEXO_FEMEA = "F";
    
    static public final int STATUS_ATIVO   = 1;
    static public final int STATUS_INATIVO = 2;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int           id;
    private String        brinco;
    private String        nome;
    private Date          dataNascimento;
    private Date          dataAquisicao;
    private String        sexo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idclassificacao")
    private Classificacao classificacao;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idraca")
    private Raca          raca;
    private float         pesoEntrada;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idtipoentrada")
    private TipoEntrada   tipoEntrada;
    private float         valor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idanimalpai")
    private Animal        pai;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idanimalmae")
    private Animal        mae;
    private String        observacoes;
    private int           status;

    public Animal() {
        this.setClassificacao(new Classificacao())
            .setRaca(new Raca())
            .setTipoEntrada(new TipoEntrada());
    }

    public Animal(String brinco, String nome, Date dataNascimento, Date dataAquisicao, String sexo, Classificacao classificacao, Raca raca, float pesoEntrada, TipoEntrada tipoEntrada, float valor, Animal pai, Animal mae, String observacoes, int status) {
        this.setBrinco(brinco)
            .setNome(nome)
            .setDataNascimento(dataNascimento)
            .setDataAquisicao(dataAquisicao)
            .setSexo(sexo)
            .setClassificacao(classificacao)
            .setRaca(raca)
            .setPesoEntrada(pesoEntrada)
            .setTipoEntrada(tipoEntrada)
            .setValor(valor)
            .setPai(pai)
            .setMae(mae)
            .setObservacoes(observacoes)
            .setStatus(status);
    }

    public Animal(int id, String brinco, String nome, Date dataNascimento, Date dataAquisicao, String sexo, Classificacao classificacao, Raca raca, float pesoEntrada, TipoEntrada tipoEntrada, float valor, Animal pai, Animal mae, String observacoes, int status) {
        this.setId(id)
            .setBrinco(brinco)
            .setNome(nome)
            .setDataNascimento(dataNascimento)
            .setDataAquisicao(dataAquisicao)
            .setSexo(sexo)
            .setClassificacao(classificacao)
            .setRaca(raca)
            .setPesoEntrada(pesoEntrada)
            .setTipoEntrada(tipoEntrada)
            .setValor(valor)
            .setPai(pai)
            .setMae(mae)
            .setObservacoes(observacoes)
            .setStatus(status);
    }

    @Override
    public int getId() {
        return id;
    }

    public Animal setId(int id) {
        this.id = id;
        return this;
    }

    public String getBrinco() {
        return brinco;
    }

    public Animal setBrinco(String brinco) {
        this.brinco = brinco;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Animal setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Animal setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public Animal setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
        return this;
    }

    public String getSexo() {
        return sexo;
    }

    public Animal setSexo(String sexo) {
        this.sexo = sexo;
        return this;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public Animal setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
        return this;
    }

    public Raca getRaca() {
        return raca;
    }

    public Animal setRaca(Raca raca) {
        this.raca = raca;
        return this;
    }

    public float getPesoEntrada() {
        return pesoEntrada;
    }

    public Animal setPesoEntrada(float pesoEntrada) {
        this.pesoEntrada = pesoEntrada;
        return this;
    }

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public Animal setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
        return this;
    }

    public float getValor() {
        return valor;
    }

    public Animal setValor(float valor) {
        this.valor = valor;
        return this;
    }

    public Animal getPai() {
        return pai;
    }

    public Animal setPai(Animal pai) {
        this.pai = pai;
        return this;
    }

    public Animal getMae() {
        return mae;
    }

    public Animal setMae(Animal mae) {
        this.mae = mae;
        return this;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public Animal setObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Animal setStatus(int status) {
        this.status = status;
        return this;
    }
    
    public String getDataNascimentoConsulta() {
        return this.getDataNascimento() != null ? DateUtils.dateToString(this.getDataNascimento()) : "";
    }
    
    public String getDataAquisicaoConsulta() {
        return this.getDataAquisicao() != null ? DateUtils.dateToString(this.getDataAquisicao()) : "";
    }
    
    public String getStatusConsulta() {
        return this.getStatus() == STATUS_ATIVO ? "Ativo" : "Inativo";
    }
    
    public String getPesoEntradaConsulta() {
        return NumberUtils.formataValor(this.getPesoEntrada(), 3, true);
    }
    
    public String getValorConsulta() {
        return NumberUtils.formataValor(this.getValor(), 2, true);
    }
    
    @Override
    public String toString() {
        return this.getNome() + " (" + this.getBrinco() + ")";
    }

    @Override
    public Map<String, String> getTitulosColunas() {
        HashMap<String, String> titulos = new HashMap<>();
        titulos.put("dataNascimentoConsulta", "Data de Nascimento");
        titulos.put("dataAquisicaoConsulta",  "Data de Aquisição");
        titulos.put("classificacao",          "Classificação");
        titulos.put("raca",                   "Raça");
        titulos.put("pesoEntradaConsulta",    "Peso de Entrada");
        titulos.put("tipoEntrada",            "Tipo de Entrada");
        titulos.put("mae",                    "Mãe");
        titulos.put("observacoes",            "Observações");
        titulos.put("statusConsulta",         "Status");
        titulos.put("valorConsulta",          "Valor");
        return titulos;
    }

    @Override
    public ArrayList<CampoFiltro> getCamposFiltraveis() {
        ArrayList<CampoFiltro> filtros = new ArrayList<>();
        filtros.add(new CampoFiltro(Integer.class, "id"));
        filtros.add(new CampoFiltro(String.class,  "nome"));
        filtros.add(new CampoFiltro(Date.class,    "dataNascimento", "Data de Nascimento"));
        filtros.add(new CampoFiltro(Date.class,    "dataAquisicao",  "Data de Aquisição"));
        filtros.add(new CampoFiltro(String.class,  "sexo"));
        filtros.add(new CampoFiltro(Float.class,   "valor"));
        return filtros;
    }

    @Override
    public List<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("SEXO_MACHO");
        campos.add("SEXO_FEMEA");
        campos.add("STATUS_ATIVO");
        campos.add("STATUS_INATIVO");
        campos.add("dataNascimento");
        campos.add("dataAquisicao");
        campos.add("status");
        campos.add("pesoEntrada");
        campos.add("valor");
        campos.add("observacoes");
        return campos;
    }

    @Override
    public List<String> getCamposAdicionar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("dataNascimentoConsulta");
        campos.add("dataAquisicaoConsulta");
        campos.add("statusConsulta");
        campos.add("pesoEntradaConsulta");
        campos.add("valorConsulta");
        return campos;
    }
    
}