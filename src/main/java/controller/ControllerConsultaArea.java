package controller;

import dao.Dao;
import javax.swing.JOptionPane;
import model.Area;
import view.ViewConsultaArea;

/**
 * @author Ruan
 */
public class ControllerConsultaArea extends ControllerConsulta<Area, ViewConsultaArea, Dao> {

    public ControllerConsultaArea(Controller caller) {
        super(caller);
    }

    @Override
    public Area getInstanceModel() {
        return new Area();
    }

    @Override
    public ViewConsultaArea getInstanceView() {
        return new ViewConsultaArea();
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
    }
    
    private void addListenerAcoes() {
        this.addListenerAcaoInserir();
        this.addListenerAcaoAlterar();
        this.addListenerAcaoExcluir();
        this.addListenerAcaoVisualizar();
    }
    
    private void addListenerAcaoInserir() {
        this.getView().getBotaoInserir().addActionListener((e) -> {
            (new ControllerManutencaoArea(this, false)).montaTela();
        });
    }
    
    private void addListenerAcaoAlterar() {
        this.getView().getBotaoAlterar().addActionListener((e) -> {
            (new ControllerManutencaoArea(this, false)).setModel(this.getSelectedModel()).montaTela();
        });
    }
    
    private void addListenerAcaoExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja excluir os registros selecionados?", "Atenção", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                boolean sucesso = true;
                for (Area selectedModel : this.getSelectedModels()) {
                    if (!this.getDao().remove(selectedModel)) {
                        sucesso = false;
                    }
                }
                if (sucesso) {
                    this.getView().showMensagem("Registro(s) excluido(s) com sucesso!");
                }
                else {
                    this.getView().showMensagem("Houve um erro inesperado.");
                }
                this.atualizaConsulta();
            }
        });
    }
    
    private void addListenerAcaoVisualizar() {
        this.getView().getBotaoVisualizar().addActionListener((e) -> {
            (new ControllerManutencaoArea(this, true)).setModel(this.getSelectedModel()).montaTela();
        });
    }
    
}