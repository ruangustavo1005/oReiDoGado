package controller;

import dao.Dao;
import javax.swing.JOptionPane;
import model.Medicamento;
import view.ViewConsultaMedicamento;

/**
 * @author Ruan
 */
public class ControllerConsultaMedicamento extends ControllerConsulta<Medicamento, ViewConsultaMedicamento, Dao> {

    public ControllerConsultaMedicamento(Controller caller) {
        super(caller);
    }

    @Override
    public Medicamento getInstanceModel() {
        return new Medicamento();
    }

    @Override
    public ViewConsultaMedicamento getInstanceView() {
        return new ViewConsultaMedicamento();
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
            (new ControllerManutencaoMedicamento(this, false)).montaTela();
        });
    }
    
    private void addListenerAcaoAlterar() {
        this.getView().getBotaoAlterar().addActionListener((e) -> {
            (new ControllerManutencaoMedicamento(this, false)).setModel(this.getSelectedModel()).montaTela();
        });
    }
    
    private void addListenerAcaoExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja excluir os registros selecionados?", "Atenção", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                boolean sucesso = true;
                for (Medicamento selectedModel : this.getSelectedModels()) {
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
            (new ControllerManutencaoMedicamento(this, true)).setModel(this.getSelectedModel()).montaTela();
        });
    }
    
}