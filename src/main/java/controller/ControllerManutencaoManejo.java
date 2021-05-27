package controller;

import dao.Dao;
import model.Animal;
import model.Area;
import model.Baixa;
import model.Manejo;
import model.Medicamento;
import model.UnidadeMedida;
import utils.Lista;
import view.ViewManutencaoManejo;

/**
 * @author Ruan
 */
public class ControllerManutencaoManejo extends ControllerManutencao<Manejo, ViewManutencaoManejo, Dao> {

    private Animal animal;
    
    public ControllerManutencaoManejo(Controller caller, boolean visualizacao) {
        super(caller, visualizacao);
    }

    @Override
    public boolean processaDados() {
        if (this.getModel().isChavePreenchida()) {
            return this.getDao(true, this.getModel().getClass()).update(this.getModel());
        }
        return this.getDao(true, this.getModel().getClass()).add(this.getModel());
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
    public ViewManutencaoManejo getInstanceView() {
        return new ViewManutencaoManejo();
    }

    @Override
    public void montaTela() {
        this.getView().setAnimal(this.getAnimal());
        super.montaTela();
        this.addListenerAcoes();
        this.setaListas();
    }
    
    private void setaListas() {
        this.getView().getComboBoxAnimal().addItem(this.getAnimal());
        
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

    public Animal getAnimal() {
        return animal;
    }

    public ControllerManutencaoManejo setAnimal(Animal animal) {
        this.animal = animal;
        return this;
    }
    
}