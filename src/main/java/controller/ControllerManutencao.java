package controller;

import dao.Dao;
import model.Model;
import view.ViewManutencao;

/**
 * Controlador base para controladores de manutenção
 * @author Ruan
 * @param <TypeModel>
 * @param <TypeView>
 * @param <TypeDao>
 */
abstract public class ControllerManutencao<TypeModel extends Model, TypeView extends ViewManutencao, TypeDao extends Dao> extends Controller<TypeModel, TypeView, TypeDao> {
    
    private boolean onlyVisualizacao;
    
    public ControllerManutencao(Controller caller, boolean onlyVisualizacao) {
        super(caller);
        this.onlyVisualizacao = onlyVisualizacao;
    }
    
    @Override
    public void montaTela() {
        super.montaTela();
        this.getView().setOnlyVisualizacao(this.isOnlyVisualizacao());
        this.beanDadosTela();
    }
    
    protected void beanDadosTela() {
        if (this.getModel().isChavePreenchida()) {
            this.getView().setModel(this.getModel());
            this.getView().beanDados();
        }
    }

    public boolean isOnlyVisualizacao() {
        return this.onlyVisualizacao;
    }

    public ControllerManutencao setOnlyVisualizacao(boolean onlyVisualizacao) {
        this.onlyVisualizacao = onlyVisualizacao;
        return this;
    }

}