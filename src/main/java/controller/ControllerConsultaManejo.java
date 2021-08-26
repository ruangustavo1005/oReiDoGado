package controller;

import dao.DaoManejo;
import javax.swing.JOptionPane;
import model.Animal;
import model.Manejo;
import view.ViewConsultaManejo;

/**
 * @author Ruan
 */
public class ControllerConsultaManejo extends ControllerConsulta<Manejo, ViewConsultaManejo, DaoManejo> {

    private Animal animal;
    
    public ControllerConsultaManejo(Controller caller) {
        super(caller);
    }
 
    @Override
    public Manejo getInstanceModel() {
        return null;
    }

    @Override
    public ViewConsultaManejo getInstanceView() {
        return new ViewConsultaManejo();
    }

    @Override
    public DaoManejo getDao() {
        return super.getDao(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public DaoManejo getInstanceDao() {
        return this.getInstanceDao(Manejo.class);
    }

    @Override
    public DaoManejo getInstanceDao(Class classe) {
        return new DaoManejo();
    }
    
    public Animal getAnimal() {
        return animal;
    }

    public ControllerConsultaManejo setAnimal(Animal animal) {
        this.animal = animal;
        this.getDao().setAnimalFiltroConsulta(animal);
        return this;
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
    }
    
    private void addListenerAcoes() {
        this.addListenerAcaoInserir();
        this.addListenerAcaoExcluir();
    }
    
    private void addListenerAcaoInserir() {
        this.getView().getBotaoInserir().addActionListener((e) -> {
            (new ControllerManutencaoManejo(this, false)).setAnimal(this.getAnimal()).montaTela();
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
    
}