package controller;

import dao.Dao;
import model.Model;
import view.View;

/**
 * Controlador base para os outros diversos
 * @author Ruan
 * @param <TypeModel>
 * @param <TypeView>
 * @param <TypeDao>
 */
abstract public class Controller<TypeModel extends Model, TypeView extends View, TypeDao extends Dao> {
    
    protected Controller caller;
    protected TypeModel  model;
    protected TypeView   view;
    protected TypeDao    dao;

    public Controller(Controller caller) {
        this.caller = caller;
        this.createInstances();
    }

    protected final void createInstances() {
        try {
            this.model = this.getInstanceModel();
            this.view  = this.getInstanceView();
            this.dao   = this.getInstanceDao();
        }
        catch (UnsupportedOperationException exception) {}
    }
    
    abstract public boolean processaDados();
    
    abstract public TypeModel getInstanceModel();
    
    abstract public TypeView getInstanceView();
    
    public TypeDao getInstanceDao() {
        return this.getInstanceDao(this.getModel().getClass());
    }
    
    public TypeDao getInstanceDao(Class classe) {
        return (TypeDao) new Dao(classe);
    }
    
    public void montaTela() {
        this.getView().setVisible(true);
    }

    public TypeModel getModel() {
        if (this.model == null) {
            this.model = this.getInstanceModel();
        }
        return model;
    }

    public Controller setModel(TypeModel model) {
        this.model = model;
        return this;
    }

    public TypeView getView() {
        if (this.view == null) {
            this.view = this.getInstanceView();
        }
        return view;
    }

    public TypeDao getDao() {
        return this.getDao(false);
    }
    
    public TypeDao getDao(boolean newInstance) {
        if (this.dao == null || newInstance) {
            this.dao = this.getInstanceDao();
        }
        return dao;
    }

    public TypeDao getDao(boolean newInstance, Class classe) {
        if (this.dao == null || newInstance) {
            this.dao = this.getInstanceDao(classe);
        }
        return dao;
    }
    
    public Controller getCaller() {
        return caller;
    }

}