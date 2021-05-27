package controller;

import dao.Dao;
import model.TipoEntrada;
import view.ViewManutencaoTipoEntrada;

/**
 * @author Ruan
 */
public class ControllerManutencaoTipoEntrada extends ControllerManutencao<TipoEntrada, ViewManutencaoTipoEntrada, Dao> {

    public ControllerManutencaoTipoEntrada(Controller caller, boolean visualizacao) {
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
    public TipoEntrada getInstanceModel() {
        return new TipoEntrada();
    }

    @Override
    public ViewManutencaoTipoEntrada getInstanceView() {
        return new ViewManutencaoTipoEntrada();
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
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