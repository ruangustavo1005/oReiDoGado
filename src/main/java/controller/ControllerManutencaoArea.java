package controller;

import dao.Dao;
import model.Area;
import model.UnidadeMedida;
import view.ViewManutencaoArea;

/**
 * @author Ruan
 */
public class ControllerManutencaoArea extends ControllerManutencao<Area, ViewManutencaoArea, Dao> {

    public ControllerManutencaoArea(Controller caller, boolean visualizacao) {
        super(caller, visualizacao);
    }

    @Override
    public boolean processaDados() {
        if (this.getModel().isChavePreenchida()) {
            return this.getDao().update(this.getModel());
        }
        return this.getDao().add(this.getModel());
    }

    @Override
    public Area getInstanceModel() {
        return new Area();
    }

    @Override
    public ViewManutencaoArea getInstanceView() {
        return new ViewManutencaoArea();
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
        this.setaUnidadesMedida();
    }
    
    private void setaUnidadesMedida() {
        (new Dao(UnidadeMedida.class)).get().forEach((unidadeMedida) -> {
            this.getView().getComboBoxUnidadeMedida().addItem((UnidadeMedida) unidadeMedida);
        });
    }
    
    private void addListenerAcoes() {
        this.addListenerAcaoConfirmar();
        this.addListenerAcaoFechar();
    }
    
    private void addListenerAcaoConfirmar() {
        this.getView().getBotaoConfirmar().addActionListener((e) -> {
            this.setModel(this.getView().getModelFromDadosTela());
            
            String mensagemSucesso = "Registro inserido com sucesso!";
            
            if (this.getModel().isChavePreenchida()) {
                mensagemSucesso = "Registro alterado com sucesso!";
            }
            
            if (this.processaDados()) {
                this.getView().showMensagem(mensagemSucesso);
                if (this.getCaller() instanceof  ControllerConsulta) {
                    ((ControllerConsulta) this.getCaller()).atualizaConsulta();
                }
                this.getView().dispose();
            }
            else {
                this.getView().showMensagem("Houve um erro inesperado.");
            }
        });
    }
    
    private void addListenerAcaoFechar() {
        this.getView().getBotaoFechar().addActionListener((e) -> {
            this.getView().dispose();
        });
    }
    
}