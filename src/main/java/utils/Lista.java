package utils;

/**
 * @author Ruan
 */
public class Lista<Chave, Valor> {

    private Chave codigo;
    private Valor nome;

    public Lista() {
        
    }
    
    public Lista(Chave codigo, Valor nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Chave getCodigo() {
        return codigo;
    }

    public void setCodigo(Chave codigo) {
        this.codigo = codigo;
    }

    public Valor getNome() {
        return nome;
    }

    public void setNome(Valor nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getCodigo() == ((Lista) obj).getCodigo();
    }
    
}