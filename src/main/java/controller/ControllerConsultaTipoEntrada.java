package controller;

import dao.Dao;
import javax.swing.JOptionPane;
import model.TipoEntrada;
import view.ViewConsultaTipoEntrada;

/**
 * @author Ruan
 */
public class ControllerConsultaTipoEntrada extends ControllerConsulta<TipoEntrada, ViewConsultaTipoEntrada, Dao> {

    public ControllerConsultaTipoEntrada(Controller caller) {
        super(caller);
    }

    @Override
    public TipoEntrada getInstanceModel() {
        return new TipoEntrada();
    }

    @Override
    public ViewConsultaTipoEntrada getInstanceView() {
        return new ViewConsultaTipoEntrada();
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
            (new ControllerManutencaoTipoEntrada(this, false)).montaTela();
        });
    }
    
    private void addListenerAcaoAlterar() {
        this.getView().getBotaoAlterar().addActionListener((e) -> {
            (new ControllerManutencaoTipoEntrada(this, false)).setModel(this.getSelectedModel()).montaTela();
        });
    }
    
    private void addListenerAcaoExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja excluir os registros selecionados?", "Atenção", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                boolean sucesso = true;
                for (TipoEntrada selectedModel : this.getSelectedModels()) {
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
            (new ControllerManutencaoTipoEntrada(this, true)).setModel(this.getSelectedModel()).montaTela();
        });
    }
    
}