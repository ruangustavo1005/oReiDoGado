package utils;

/**
 * @author Ruan
 */
public class OperadorFiltro {

    static public final String operadorIgual      = "=";
    static public final String operadorDiferente  = "!=";
    static public final String operadorContem     = "like";
    static public final String operadorNaoContem  = "not like";
    static public final String operadorMaiorQue   = ">";
    static public final String operadorMaiorIgual = ">=";
    static public final String operadorMenorQue   = "<";
    static public final String operadorMenorIgual = "<=";
    static public final String operadorEntre      = "between";
    static public final String operadorNaoEntre   = "not between";
    
    static public final String _operadorIgual      = "Igual";
    static public final String _operadorDiferente  = "Diferente";
    static public final String _operadorContem     = "Contém";
    static public final String _operadorNaoContem  = "Não Contem";
    static public final String _operadorMaiorQue   = "Maior Que";
    static public final String _operadorMaiorIgual = "Maior Igual";
    static public final String _operadorMenorQue   = "Menor Que";
    static public final String _operadorMenorIgual = "Menor Igual";
    static public final String _operadorEntre      = "Entre";
    static public final String _operadorNaoEntre   = "Não Entre";
    
    private String nome;
    private String descricao;

    public OperadorFiltro() {
        
    }

    public OperadorFiltro(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public OperadorFiltro setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public OperadorFiltro setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }
    
    public boolean usaCampo2() {
        return this.getNome().equals(OperadorFiltro.operadorEntre)
            || this.getNome().equals(OperadorFiltro.operadorNaoEntre);
    }
    
    static public OperadorFiltro getInstanceOperadorIgual() {
        return new OperadorFiltro(OperadorFiltro.operadorIgual, OperadorFiltro._operadorIgual);
    }
    
    static public OperadorFiltro getInstanceOperadorDiferente() {
        return new OperadorFiltro(OperadorFiltro.operadorDiferente, OperadorFiltro._operadorDiferente);
    }
    
    static public OperadorFiltro getInstanceOperadorContem() {
        return new OperadorFiltro(OperadorFiltro.operadorContem, OperadorFiltro._operadorContem);
    }
    
    static public OperadorFiltro getInstanceOperadorNaoContem() {
        return new OperadorFiltro(OperadorFiltro.operadorNaoContem, OperadorFiltro._operadorNaoContem);
    }
    
    static public OperadorFiltro getInstanceOperadorMaiorQue() {
        return new OperadorFiltro(OperadorFiltro.operadorMaiorQue, OperadorFiltro._operadorMaiorQue);
    }
    
    static public OperadorFiltro getInstanceOperadorMaiorIgual() {
        return new OperadorFiltro(OperadorFiltro.operadorMaiorIgual, OperadorFiltro._operadorMaiorIgual);
    }
    
    static public OperadorFiltro getInstanceOperadorMenorQue() {
        return new OperadorFiltro(OperadorFiltro.operadorMenorQue, OperadorFiltro._operadorMenorQue);
    }
    
    static public OperadorFiltro getInstanceOperadorMenorIgual() {
        return new OperadorFiltro(OperadorFiltro.operadorMenorIgual, OperadorFiltro._operadorMenorIgual);
    }
    
    static public OperadorFiltro getInstanceOperadorEntre() {
        return new OperadorFiltro(OperadorFiltro.operadorEntre, OperadorFiltro._operadorEntre);
    }
    
    static public OperadorFiltro getInstanceOperadorNaoEntre() {
        return new OperadorFiltro(OperadorFiltro.operadorNaoEntre, OperadorFiltro._operadorNaoEntre);
    }
    
    @Override
    public String toString() {
        return this.getDescricao();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            return this.getNome().equals(((OperadorFiltro) obj).getNome());
        }
        return false;
    }
    
}