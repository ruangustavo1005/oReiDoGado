package controller;

import dao.Dao;
import javax.swing.JOptionPane;
import model.Animal;
import model.Manejo;
import view.ViewConsultaManejo;

/**
 * @author Ruan
 */
public class ControllerConsultaManejo extends ControllerConsulta<Manejo, ViewConsultaManejo, Dao> {

    private Animal animal;
    
    public ControllerConsultaManejo(Controller caller) {
        super(caller);
    }

    @Override
    public Manejo getInstanceModel() {
        return new Manejo() {};
    }

    @Override
    public ViewConsultaManejo getInstanceView() {
        return new ViewConsultaManejo();
    }

    public Animal getAnimal() {
        return animal;
    }

    public ControllerConsultaManejo setAnimal(Animal animal) {
        this.animal = animal;
        return this;
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
            (new ControllerManutencaoManejo(this, false)).setAnimal(this.getAnimal()).montaTela();
        });
    }
    
    private void addListenerAcaoAlterar() {
        this.getView().getBotaoAlterar().addActionListener((e) -> {
            (new ControllerManutencaoManejo(this, false)).setAnimal(this.getAnimal()).setModel(this.getSelectedModel()).montaTela();
        });
    }
    
    private void addListenerAcaoExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja excluir os registros selecionados?", "Atenção", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                boolean sucesso = true;
                for (Manejo selectedModel : this.getSelectedModels()) {
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
            (new ControllerManutencaoManejo(this, true)).setAnimal(this.getAnimal()).setModel(this.getSelectedModel()).montaTela();
        });
    }
    
}