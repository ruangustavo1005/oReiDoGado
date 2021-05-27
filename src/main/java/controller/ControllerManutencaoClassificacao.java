package controller;

import dao.Dao;
import model.Classificacao;
import view.ViewManutencaoClassificacao;

/**
 * @author Ruan
 */
public class ControllerManutencaoClassificacao extends ControllerManutencao<Classificacao, ViewManutencaoClassificacao, Dao> {

    public ControllerManutencaoClassificacao(Controller caller, boolean visualizacao) {
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
    public Classificacao getInstanceModel() {
        return new Classificacao();
    }

    @Override
    public ViewManutencaoClassificacao getInstanceView() {
        return new ViewManutencaoClassificacao();
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