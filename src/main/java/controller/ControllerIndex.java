package controller;

import dao.Dao;
import javax.swing.JOptionPane;
import model.Animal;
import view.ViewIndex;

/**
 * @author Ruan
 */
public class ControllerIndex extends ControllerConsulta<Animal, ViewIndex, Dao> {

    public ControllerIndex(Controller caller) {
        super(caller);
    }

    @Override
    public Animal getInstanceModel() {
        return new Animal();
    }

    @Override
    public ViewIndex getInstanceView() {
        return new ViewIndex();
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
        this.addListenerMenus();
    }
    
    private void addListenerAcoes() {
        this.addListenerAcaoInserir();
        this.addListenerAcaoAlterar();
        this.addListenerAcaoExcluir();
        this.addListenerAcaoVisualizar();
        this.addListenerAcaoInserirManejo();
        this.addListenerAcaoInserirManejoLote();
        this.addListenerAcaoGerenciarManejo();
        this.addListenerAcaoSair();
    }
    
    private void addListenerMenus() {
        this.addListenerMenuArea();
        this.addListenerMenuClassificacao();
        this.addListenerMenuMedicamento();
        this.addListenerMenuRaca();
        this.addListenerMenuTipoEntrada();
        this.addListenerMenuUnidadeMedida();
    }
    
    private void addListenerAcaoInserir() {
        this.getView().getBotaoInserir().addActionListener((e) -> {
            (new ControllerManutencaoAnimal(this, false)).montaTela();
        });
    }
    
    private void addListenerAcaoAlterar() {
        this.getView().getBotaoAlterar().addActionListener((e) -> {
            (new ControllerManutencaoAnimal(this, false)).setModel(this.getSelectedModel()).montaTela();
        });
    }
    
    private void addListenerAcaoExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja excluir os registros selecionados?", "Atenção", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                boolean sucesso = true;
                for (Animal selectedModel : this.getSelectedModels()) {
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
            (new ControllerManutencaoAnimal(this, true)).setModel(this.getSelectedModel()).montaTela();
        });
    }
    
    private void addListenerAcaoInserirManejo() {
        this.getView().getBotaoInserirManejo().addActionListener((e) -> {
            (new ControllerManutencaoManejo(this, false)).setAnimal(this.getSelectedModel()).montaTela();
        });
    }
    
    private void addListenerAcaoInserirManejoLote() {
        this.getView().getBotaoInserirManejoLote().addActionListener((e) -> {
            this.getView().showMensagem("Método ControllerIndex.addListenerAcaoInserirManejoLote() não implementado");
        });
    }
    
    private void addListenerAcaoGerenciarManejo() {
        this.getView().getBotaoGerenciarManejos().addActionListener((e) -> {
            (new ControllerConsultaManejo(this)).setAnimal(this.getSelectedModel()).montaTela();
        });
    }
    
    private void addListenerAcaoSair() {
        this.getView().getBotaoSair().addActionListener((e) -> {
            System.exit(0);
        });
    }
    
    private void addListenerMenuArea() {
        this.getView().getMenuArea().addActionListener((e) -> {
            (new ControllerConsultaArea(this)).montaTela();
        });
    }
    
    private void addListenerMenuClassificacao() {
        this.getView().getMenuClassificacao().addActionListener((e) -> {
            (new ControllerConsultaClassificacao(this)).montaTela();
        });
    }
    
    private void addListenerMenuMedicamento() {
        this.getView().getMenuMedicamento().addActionListener((e) -> {
            (new ControllerConsultaMedicamento(this)).montaTela();
        });
    }
    
    private void addListenerMenuRaca() {
        this.getView().getMenuRaca().addActionListener((e) -> {
            (new ControllerConsultaRaca(this)).montaTela();
        });
    }
    
    private void addListenerMenuTipoEntrada() {
        this.getView().getMenuTipoEntrada().addActionListener((e) -> {
            (new ControllerConsultaTipoEntrada(this)).montaTela();
        });
    }
    
    private void addListenerMenuUnidadeMedida() {
        this.getView().getMenuUnidadeMedida().addActionListener((e) -> {
            (new ControllerConsultaUnidadeMedida(this)).montaTela();
        });
    }
    
}