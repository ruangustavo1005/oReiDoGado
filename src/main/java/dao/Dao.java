package dao;

import exceptions.ValorInvalidoCampo;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import utils.CampoFiltro;
import utils.DateUtils;
import utils.OperadorFiltro;

/**
 * Dao padrão para uso em consultas e manuseios básicos do banco de dados
 * @author Ruan
 * @param <Type> Tipo do dado (modelo) persistido
 */
public class Dao<Type> {
    
    protected final EntityManager entityManager;

    private final Class<Type> classe;

    public Dao(Class<Type> classe) {
        this.classe        = classe;
        this.entityManager = Connection.getInstance().getEntityManager();
    }
    
    public ArrayList<Type> get() {
        ArrayList<Type> lista = null;
        try {
            lista = (ArrayList<Type>) this.entityManager.createQuery("from " + this.classe.getName()).getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList<Type> get(CampoFiltro campoFiltro, OperadorFiltro operadorFiltro, String valor) throws ValorInvalidoCampo {
        return this.get(campoFiltro, operadorFiltro, valor, "");
    }
    
    public ArrayList<Type> get(CampoFiltro campoFiltro, OperadorFiltro operadorFiltro, String valor, String valor2) throws ValorInvalidoCampo {
        ArrayList<Type> lista = null;
        
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
                query = this.entityManager.createQuery("from " + this.classe.getName() + " tabela "
                                                    + "where tabela." + campo + " " + operador + " :param1");

                this.addParamQuery(query, campoFiltro, "param1", valor);
            } break;

            case OperadorFiltro.operadorContem : 
            case OperadorFiltro.operadorNaoContem : {
                query = this.entityManager.createQuery("from " + this.classe.getName() + " tabela "
                                                    + "where lower(tabela." + campo + ") " + operador + " :param1");

                this.addParamQuery(query, campoFiltro, "param1", "%" + valor.toLowerCase() + "%");
            } break;

            case OperadorFiltro.operadorEntre : 
            case OperadorFiltro.operadorNaoEntre : {
                query = this.entityManager.createQuery("from " + this.classe.getName() + " tabela "
                                                    + "where tabela." + campo + " " + operador + " :param1 and :param2");

                this.addParamQuery(query, campoFiltro, "param1", valor);
                this.addParamQuery(query, campoFiltro, "param2", valor2);
            } break;
        }

        if (query != null) {
            lista = (ArrayList<Type>) query.getResultList();
        }
        
        return lista;
    }

    protected void addParamQuery(Query query, CampoFiltro campoFiltro, String paramName, String paramValue) throws ValorInvalidoCampo {
        if (campoFiltro.isTipoString()) {
            query.setParameter(paramName, paramValue);
        }
        else if (campoFiltro.isTipoInteger()) {
            try {
                query.setParameter(paramName, Integer.valueOf(paramValue));
            }
            catch (NumberFormatException exception) {
                throw new ValorInvalidoCampo();
            }
        }
        else if (campoFiltro.isTipoFloat()) {
            query.setParameter(paramName, Float.valueOf(paramValue));
        }
        else if (campoFiltro.isTipoDate()) {
            query.setParameter(paramName, DateUtils.stringToDate(paramValue));
        }
    }
    
    public boolean add(Type object) {
        boolean retorno = true;
        try {
            this.begin();
            this.entityManager.persist(object);
            this.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            retorno = false;
            if (this.entityManager.getTransaction().isActive()) {
                this.rollback();
            }
        }
        return retorno;
    }

    public boolean remove(int id) {
        return this.remove(this.get(id));
    }
    
    public boolean remove(Type object) {
        boolean retorno = true;
        try {
            this.begin();
            this.entityManager.remove(object);
            this.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            retorno = false;
            if (this.entityManager.getTransaction().isActive()) {
                this.rollback();
            }
        }
        return retorno;
    }
    
    public boolean update(Type object) {
        boolean retorno = true;
        try {
            this.begin();
            this.entityManager.merge(object);
            this.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            retorno = false;
            if (this.entityManager.getTransaction().isActive()) {
                this.rollback();
            }
        }
        return retorno;
    }
    
    public Type get(Object id) {
        Type object = null;
        try {
            object = this.entityManager.find(this.classe, id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
    
    protected final void begin() {
        this.entityManager.getTransaction().begin();
    }

    protected final void commit() {
        if (this.entityManager.getTransaction().isActive()) {
            this.entityManager.getTransaction().commit();
        }
    }

    protected final void rollback() {
        this.entityManager.getTransaction().rollback();
    }
    
}