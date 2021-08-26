package controller;

import dao.Dao;
import java.util.ArrayList;
import model.Animal;
import model.Area;
import model.Baixa;
import model.Manejo;
import model.Medicamento;
import model.UnidadeMedida;
import utils.Lista;
import view.ViewManutencaoManejoLote;

/**
 * @author Ruan
 */
public class ControllerManutencaoManejoLote extends ControllerManutencao<Manejo, ViewManutencaoManejoLote, Dao> {

    private ArrayList<Animal> animais;
    
    public ControllerManutencaoManejoLote(Controller caller, boolean visualizacao) {
        super(caller, visualizacao);
    }

    @Override
    public boolean processaDados() {
        boolean retorno = true;
        for (Animal animal : this.getAnimais()) {
            this.setModel(this.getView().getModelFromDadosTela());
            this.getModel().setAnimal(animal);
            if (!this.getDao(true, this.getModel().getClass()).add(this.getModel())) {
                retorno = false;
                break;
            }
        }
        return retorno;
    }

    @Override
    public Manejo getInstanceModel() {
        Manejo retorno = new Manejo() {};
        try {
            if (this.getView().getComboBoxTipoManejo() != null && this.getView().getComboBoxTipoManejo().getSelectedIndex() >= 0) {
                retorno = (Manejo) this.getView().getComboBoxTipoManejo().getItemAt(this.getView().getComboBoxTipoManejo().getSelectedIndex()).getCodigo().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException ex) {}
        return retorno;
    }

    @Override
    public ViewManutencaoManejoLote getInstanceView() {
        return new ViewManutencaoManejoLote();
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
        this.setaListas();
    }
    
    private void setaListas() {
        this.getAnimais().forEach((Animal animal) -> {
            this.getView().getComboBoxAnimal().addItem(animal);
        });
        
        (new Dao(Area.class)).get().forEach((area) -> {
            this.getView().getComboBoxAreaTransferenciaArea().addItem((Area) area);
        });
        (new Dao(Medicamento.class)).get().forEach((medicamento) -> {
            this.getView().getComboBoxMedicamentoMedidacao().addItem((Medicamento) medicamento);
        });
        Baixa.getListaTipoBaixa().forEach((tipoBaixa) -> {
            this.getView().getComboBoxTipoBaixa().addItem((Lista<Integer, String>) tipoBaixa);
        });
        (new Dao(UnidadeMedida.class)).get().forEach((unidadeMedida) -> {
            this.getView().getComboBoxUnidadeMedidaMedicacao().addItem((UnidadeMedida) unidadeMedida);
        });
    }
    
    private void addListenerAcoes() {
        this.addListenerAcaoConfirmar();
        this.addListenerAcaoFechar();
    }
    
    private void addListenerAcaoConfirmar() {
        this.getView().getBotaoConfirmar().addActionListener((e) -> {
            String mensagemSucesso = "Registro inserido com sucesso!";
            
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

    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    public ControllerManutencaoManejoLote setAnimais(ArrayList<Animal> animais) {
        this.animais = animais;
        return this;
    }
    
}