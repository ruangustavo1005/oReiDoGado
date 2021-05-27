package interfaces;

import java.util.Map;

/**
 * Interface para listagens com títulos não dinâmicos, utilizada para "maquear" os dados
 * @author Ruan
 */
public interface ListagemMaqueada {
    
    /**
     * Map na estrutura ["nomeDoAtributo" : "Novo Título"]
     * Trata os campos adicionais que forem trazidos pela interface ListagemAdicional
     * @return 
     */
    public Map<String, String> getTitulosColunas();
    
}