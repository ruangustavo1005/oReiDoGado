package controller;

import dao.Dao;
import exceptions.ValorInvalidoCampo;
import model.Animal;
import model.Classificacao;
import model.Raca;
import model.TipoEntrada;
import utils.CampoFiltro;
import utils.OperadorFiltro;
import view.ViewManutencaoAnimal;

/**
 * @author Ruan
 */
public class ControllerManutencaoAnimal extends ControllerManutencao<Animal, ViewManutencaoAnimal, Dao> {

    public ControllerManutencaoAnimal(Controller caller, boolean visualizacao) {
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
    public Animal getInstanceModel() {
        return new Animal();
    }

    @Override
    public ViewManutencaoAnimal getInstanceView() {
        return new ViewManutencaoAnimal();
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
    }

    @Override
    protected void beanDadosTela() {
        this.loadDadosComboBox();
        super.beanDadosTela();
    }
    
    private void loadDadosComboBox() {
        (new Dao(TipoEntrada.class)).get().forEach((tipoEntrada) -> {
            this.getView().getComboBoxTipoEntrada().addItem((TipoEntrada) tipoEntrada);
        });
        
        (new Dao(Raca.class)).get().forEach((raca) -> {
            this.getView().getComboBoxRaca().addItem((Raca) raca);
        });
        
        (new Dao(Classificacao.class)).get().forEach((classificacao) -> {
            this.getView().getComboBoxClassificacao().addItem((Classificacao) classificacao);
        });
        
        try {
            this.getView().getComboBoxPai().addItem(null);
            this.getDao().get(new CampoFiltro(String.class, "sexo"), OperadorFiltro.getInstanceOperadorIgual(), Animal.SEXO_MACHO).forEach((animal) -> {
                this.getView().getComboBoxPai().addItem((Animal) animal);
            });
            
            this.getView().getComboBoxMae().addItem(null);
            this.getDao().get(new CampoFiltro(String.class, "sexo"), OperadorFiltro.getInstanceOperadorIgual(), Animal.SEXO_FEMEA).forEach((animal) -> {
                this.getView().getComboBoxMae().addItem((Animal) animal);
            });
        } catch (ValorInvalidoCampo ex) {}
    }
    
    private void addListenerAcoes() {
        this.addListenerAcaoConfirmar();
        this.addListenerAcaoFechar();
        this.addListenerAcaoBuscarDados();
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
    
    private void addListenerAcaoBuscarDados() {
        this.getView().getBotaoBuscarInfoWebService().addActionListener((e) -> {
            this.getView().showMensagem("Infelizmente esta funcionalidade ainda não foi desenvolvida.");
        });
    }
    
}