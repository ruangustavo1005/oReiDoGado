package dao;

import exceptions.ValorInvalidoCampo;
import java.util.ArrayList;
import javax.persistence.Query;
import model.Animal;
import model.Manejo;
import utils.CampoFiltro;
import utils.OperadorFiltro;

/**
 * @author Ruan
 */
public class DaoManejo extends Dao<Manejo> {

    private Animal animalFiltroConsulta;
    
    public DaoManejo() {
        super(Manejo.class);
    }

    public void setAnimalFiltroConsulta(Animal animalFiltroConsulta) {
        this.animalFiltroConsulta = animalFiltroConsulta;
    }

    @Override
    public ArrayList<Manejo> get() {
        Query query = entityManager.createQuery("FROM Manejo manejo WHERE manejo.animal.id = :idAnimal");
        query.setParameter("idAnimal", this.animalFiltroConsulta.getId());
        return (ArrayList<Manejo>) query.getResultList();
    }
    
    public ArrayList<Manejo> get(CampoFiltro campoFiltro, OperadorFiltro operadorFiltro, String valor, String valor2) throws ValorInvalidoCampo {
        ArrayList<Manejo> lista = null;
        
        String campo    = campoFiltro.getNome();
        String operador = operadorFiltro.getNome();

        Query query = null;

        switch (operador) {
            case OperadorFiltro.operadorIgual : 
            case OperadorFiltro.operadorDiferente : 
            case OperadorFiltro.operadorMaiorQue : 
            case OperadorFiltro.operadorMaiorIgual : 
            case OperadorFiltro.operadorMenorQue : 
            case OperadorFiltro.operadorMenorIgual : {
                query = this.entityManager.createQuery("from Manejo tabela "
                                                    + "where tabela." + campo + " " + operador + " :param1"
                                                    + "  AND tabela.animal.id = :idAnimal");

                this.addParamQuery(query, campoFiltro, "param1", valor);
            } break;

            case OperadorFiltro.operadorContem : 
            case OperadorFiltro.operadorNaoContem : {
                query = this.entityManager.createQuery("from Manejo tabela "
                                                    + "where lower(tabela." + campo + ") " + operador + " :param1"
                                                    + "  AND tabela.animal.id = :idAnimal");

                this.addParamQuery(query, campoFiltro, "param1", "%" + valor.toLowerCase() + "%");
            } break;

            case OperadorFiltro.operadorEntre : 
            case OperadorFiltro.operadorNaoEntre : {
                query = this.entityManager.createQuery("from Manejo tabela "
                                                    + "where tabela." + campo + " " + operador + " :param1 and :param2"
                                                    + "  AND tabela.animal.id = :idAnimal");

                this.addParamQuery(query, campoFiltro, "param1", valor);
                this.addParamQuery(query, campoFiltro, "param2", valor2);
            } break;
        }

        if (query != null) {
            query.setParameter("idAnimal", this.animalFiltroConsulta.getId());
            lista = (ArrayList<Manejo>) query.getResultList();
        }
        
        return lista;
    }

}