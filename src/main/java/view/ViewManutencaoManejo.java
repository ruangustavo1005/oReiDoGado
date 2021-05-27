package view;

import java.awt.Container;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import model.Animal;
import model.Area;
import model.Baixa;
import model.Cobertura;
import model.Manejo;
import model.Medicacao;
import model.Medicamento;
import model.Pesagem;
import model.TransferenciaArea;
import model.UnidadeMedida;
import utils.DateUtils;
import utils.Lista;
import utils.NumberUtils;

/**
 *
 * @author Ruan
 */
public class ViewManutencaoManejo extends ViewManutencao<Manejo> {

    private Animal animal;
    
    public ViewManutencaoManejo() {
        initComponents();
        
        this.formataCamposManejo();
        this.loadTiposManejo();
        this.setOnChangeTipoManejo();
        this.setClickAbasWizard();
        
        this.campoData.setText(DateUtils.dateToString(new Date(System.currentTimeMillis())));
    }
    
    private void formataCamposManejo() {
        this.formataCampo(this.campoData,                MASCARA_DATE,       '0');
        this.formataCampo(this.campoPesoPesagem,         MASCARA_DOUBLE_9_3, '0');
        this.formataCampo(this.campoValorBaixa,          MASCARA_DOUBLE_8_2, '0');
        this.formataCampo(this.campoQuantidadeMedicacao, MASCARA_DOUBLE_9_3, '0');
        this.formataCampo(this.campoEntradaCobertura,    MASCARA_DATE,       '0');
        this.formataCampo(this.campoSaidaCobertura,      MASCARA_DATE,       '0');
    }
    
    private void loadTiposManejo() {
        Manejo.getListaTipos().forEach((Lista<Class, String> lista) -> {
            this.comboBoxTipoManejo.addItem(lista);
        });
    }
    
    private void setOnChangeTipoManejo() {
        this.comboBoxTipoManejo.addActionListener((e) -> {
            if (this.comboBoxTipoManejo != null && this.comboBoxTipoManejo.getSelectedIndex() >= 0) {
                Class tipo = this.comboBoxTipoManejo.getItemAt(this.comboBoxTipoManejo.getSelectedIndex()).getCodigo();
                
                if (tipo.equals(Manejo.TIPO_BAIXA)) {
                    this.telaWizard.setSelectedComponent(this.abaBaixa);
                }
                else if (tipo.equals(Manejo.TIPO_COBERTURA)) {
                    this.telaWizard.setSelectedComponent(this.abaCobertura);
                }
                else if (tipo.equals(Manejo.TIPO_MEDICACAO)) {
                    this.telaWizard.setSelectedComponent(this.abaMedicacao);
                }
                else if (tipo.equals(Manejo.TIPO_PESAGEM)) {
                    this.telaWizard.setSelectedComponent(this.abaPesagem);
                }
                else if (tipo.equals(Manejo.TIPO_TRANSFERENCIA_AREA)) {
                    this.telaWizard.setSelectedComponent(this.abaTransferenciaArea);
                }
            }
        });
    }
    
    private void setClickAbasWizard() {
        this.telaWizard.addChangeListener((e) -> {
            int index = this.telaWizard.getSelectedIndex();
            if (index >= 0) {
                this.comboBoxTipoManejo.setSelectedIndex(index);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoId = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botaoConfirmar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        campoData = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoObservacoes = new javax.swing.JTextArea();
        comboBoxTipoManejo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        telaWizard = new javax.swing.JTabbedPane();
        abaBaixa = new javax.swing.JDesktopPane();
        comboBoxTipoBaixa = new javax.swing.JComboBox<>();
        campoValorBaixa = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        abaCobertura = new javax.swing.JDesktopPane();
        campoEntradaCobertura = new javax.swing.JFormattedTextField();
        campoSaidaCobertura = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        abaMedicacao = new javax.swing.JDesktopPane();
        jLabel19 = new javax.swing.JLabel();
        comboBoxMedicamentoMedidacao = new javax.swing.JComboBox<>();
        campoQuantidadeMedicacao = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        comboBoxUnidadeMedidaMedicacao = new javax.swing.JComboBox<>();
        abaPesagem = new javax.swing.JDesktopPane();
        jLabel21 = new javax.swing.JLabel();
        campoPesoPesagem = new javax.swing.JFormattedTextField();
        abaTransferenciaArea = new javax.swing.JDesktopPane();
        jLabel6 = new javax.swing.JLabel();
        comboBoxAreaTransferenciaArea = new javax.swing.JComboBox<>();
        comboBoxAnimal = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manejo");
        setResizable(false);

        campoId.setEnabled(false);

        jLabel1.setText("Id:");

        jLabel3.setText("Data:");

        botaoConfirmar.setText("Confirmar");

        botaoFechar.setText("Fechar");

        jLabel2.setText("Observações:");

        campoObservacoes.setColumns(20);
        campoObservacoes.setRows(5);
        jScrollPane1.setViewportView(campoObservacoes);

        jLabel4.setText("Tipo do Manejo:");

        jLabel15.setText("Valor:");

        jLabel16.setText("Tipo:");

        abaBaixa.setLayer(comboBoxTipoBaixa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        abaBaixa.setLayer(campoValorBaixa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        abaBaixa.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        abaBaixa.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout abaBaixaLayout = new javax.swing.GroupLayout(abaBaixa);
        abaBaixa.setLayout(abaBaixaLayout);
        abaBaixaLayout.setHorizontalGroup(
            abaBaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaBaixaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaBaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaBaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxTipoBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoValorBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        abaBaixaLayout.setVerticalGroup(
            abaBaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaBaixaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaBaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxTipoBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaBaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoValorBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        telaWizard.addTab("Baixa", abaBaixa);

        jLabel17.setText("Data Saída:");

        jLabel18.setText("Data:");

        abaCobertura.setLayer(campoEntradaCobertura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        abaCobertura.setLayer(campoSaidaCobertura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        abaCobertura.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        abaCobertura.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout abaCoberturaLayout = new javax.swing.GroupLayout(abaCobertura);
        abaCobertura.setLayout(abaCoberturaLayout);
        abaCoberturaLayout.setHorizontalGroup(
            abaCoberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaCoberturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaCoberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaCoberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoEntradaCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoSaidaCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(310, Short.MAX_VALUE))
        );
        abaCoberturaLayout.setVerticalGroup(
            abaCoberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaCoberturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaCoberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEntradaCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaCoberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoSaidaCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        telaWizard.addTab("Cobertura", abaCobertura);

        jLabel19.setText("Medicamento:");

        jLabel20.setText("Quantidade:");

        abaMedicacao.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        abaMedicacao.setLayer(comboBoxMedicamentoMedidacao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        abaMedicacao.setLayer(campoQuantidadeMedicacao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        abaMedicacao.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        abaMedicacao.setLayer(comboBoxUnidadeMedidaMedicacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout abaMedicacaoLayout = new javax.swing.GroupLayout(abaMedicacao);
        abaMedicacao.setLayout(abaMedicacaoLayout);
        abaMedicacaoLayout.setHorizontalGroup(
            abaMedicacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaMedicacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaMedicacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaMedicacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaMedicacaoLayout.createSequentialGroup()
                        .addComponent(campoQuantidadeMedicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxUnidadeMedidaMedicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboBoxMedicamentoMedidacao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        abaMedicacaoLayout.setVerticalGroup(
            abaMedicacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaMedicacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaMedicacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxMedicamentoMedidacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaMedicacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoQuantidadeMedicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(comboBoxUnidadeMedidaMedicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        telaWizard.addTab("Medicação", abaMedicacao);

        jLabel21.setText("Peso:");

        abaPesagem.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        abaPesagem.setLayer(campoPesoPesagem, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout abaPesagemLayout = new javax.swing.GroupLayout(abaPesagem);
        abaPesagem.setLayout(abaPesagemLayout);
        abaPesagemLayout.setHorizontalGroup(
            abaPesagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaPesagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPesoPesagem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        abaPesagemLayout.setVerticalGroup(
            abaPesagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaPesagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaPesagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesoPesagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        telaWizard.addTab("Pesagem", abaPesagem);

        jLabel6.setText("Área de Destino:");

        abaTransferenciaArea.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        abaTransferenciaArea.setLayer(comboBoxAreaTransferenciaArea, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout abaTransferenciaAreaLayout = new javax.swing.GroupLayout(abaTransferenciaArea);
        abaTransferenciaArea.setLayout(abaTransferenciaAreaLayout);
        abaTransferenciaAreaLayout.setHorizontalGroup(
            abaTransferenciaAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaTransferenciaAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxAreaTransferenciaArea, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        abaTransferenciaAreaLayout.setVerticalGroup(
            abaTransferenciaAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaTransferenciaAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaTransferenciaAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxAreaTransferenciaArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        telaWizard.addTab("Transferência de Área", abaTransferenciaArea);

        jLabel5.setText("Animal:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxTipoManejo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(telaWizard)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxTipoManejo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telaWizard, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmar)
                    .addComponent(botaoFechar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Manejo getModelFromDadosTela() {
        Manejo model = this.getInstanceModel();
        
        if (!this.campoId.getText().equals("")) {
            model.setId(Integer.valueOf(campoId.getText()));
        }
        
        model.setAnimal(this.getAnimal());
        model.setData(DateUtils.stringToDate(this.campoData.getText()));
        model.setObservacoes(this.campoObservacoes.getText());
        
        if (model instanceof Baixa) {
            ((Baixa) model).setTipo(this.comboBoxTipoBaixa.getItemAt(this.comboBoxTipoBaixa.getSelectedIndex()).getCodigo());
            ((Baixa) model).setValor(NumberUtils.parseFloat(this.campoValorBaixa.getText()));
        }
        else if (model instanceof Cobertura) {
            ((Cobertura) model).setDataEntrada(DateUtils.stringToDate(this.campoEntradaCobertura.getText()));
            ((Cobertura) model).setDataProvavelSaida(DateUtils.stringToDate(this.campoSaidaCobertura.getText()));
        }
        else if (model instanceof Medicacao) {
            ((Medicacao) model).setMedicamento(this.comboBoxMedicamentoMedidacao.getItemAt(this.comboBoxMedicamentoMedidacao.getSelectedIndex()));
            ((Medicacao) model).setQuantidade(NumberUtils.parseInt(this.campoQuantidadeMedicacao.getText()));
            ((Medicacao) model).setUnidadeMedida(this.comboBoxUnidadeMedidaMedicacao.getItemAt(this.comboBoxUnidadeMedidaMedicacao.getSelectedIndex()));
        }
        else if (model instanceof Pesagem) {
            ((Pesagem) model).setPeso(NumberUtils.parseFloat(this.campoPesoPesagem.getText()));
        }
        else if (model instanceof TransferenciaArea) {
            ((TransferenciaArea) model).setArea(this.comboBoxAreaTransferenciaArea.getItemAt(this.comboBoxAreaTransferenciaArea.getSelectedIndex()));
        }
        
        return model;
    }

    @Override
    public void beanDados() {
        this.campoId.setText(String.valueOf(this.getModel().getId()));
        
    }

    @Override
    public Manejo getInstanceModel() {
        Manejo retorno = new Manejo() {};
        try {
            if (this.comboBoxTipoManejo != null && this.comboBoxTipoManejo.getSelectedIndex() >= 0) {
                retorno = (Manejo) this.comboBoxTipoManejo.getItemAt(this.comboBoxTipoManejo.getSelectedIndex()).getCodigo().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException ex) {}
        return retorno;
    }

    @Override
    public void trataCamposVisualizacao(Container container) {
        super.trataCamposVisualizacao(container);
        this.getBotaoConfirmar().setEnabled(false);
    }

    public Animal getAnimal() {
        return animal;
    }

    public ViewManutencaoManejo setAnimal(Animal animal) {
        this.animal = animal;
        return this;
    }
    
    public JButton getBotaoConfirmar() {
        return botaoConfirmar;
    }

    public JButton getBotaoFechar() {
        return botaoFechar;
    }

    public JComboBox<Lista<Class, String>> getComboBoxTipoManejo() {
        return comboBoxTipoManejo;
    }

    public JComboBox<Animal> getComboBoxAnimal() {
        return comboBoxAnimal;
    }

    public JComboBox<Medicamento> getComboBoxMedicamentoMedidacao() {
        return comboBoxMedicamentoMedidacao;
    }

    public JComboBox<Lista<Integer, String>> getComboBoxTipoBaixa() {
        return comboBoxTipoBaixa;
    }

    public JComboBox<UnidadeMedida> getComboBoxUnidadeMedidaMedicacao() {
        return comboBoxUnidadeMedidaMedicacao;
    }

    public JComboBox<Area> getComboBoxAreaTransferenciaArea() {
        return comboBoxAreaTransferenciaArea;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane abaBaixa;
    private javax.swing.JDesktopPane abaCobertura;
    private javax.swing.JDesktopPane abaMedicacao;
    private javax.swing.JDesktopPane abaPesagem;
    private javax.swing.JDesktopPane abaTransferenciaArea;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JFormattedTextField campoData;
    private javax.swing.JFormattedTextField campoEntradaCobertura;
    private javax.swing.JFormattedTextField campoId;
    private javax.swing.JTextArea campoObservacoes;
    private javax.swing.JFormattedTextField campoPesoPesagem;
    private javax.swing.JFormattedTextField campoQuantidadeMedicacao;
    private javax.swing.JFormattedTextField campoSaidaCobertura;
    private javax.swing.JFormattedTextField campoValorBaixa;
    private javax.swing.JComboBox<Animal> comboBoxAnimal;
    private javax.swing.JComboBox<Area> comboBoxAreaTransferenciaArea;
    private javax.swing.JComboBox<Medicamento> comboBoxMedicamentoMedidacao;
    private javax.swing.JComboBox<Lista<Integer, String>> comboBoxTipoBaixa;
    private javax.swing.JComboBox<Lista<Class, String>> comboBoxTipoManejo;
    private javax.swing.JComboBox<UnidadeMedida> comboBoxUnidadeMedidaMedicacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane telaWizard;
    // End of variables declaration//GEN-END:variables
}