package view;

import java.awt.Container;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.text.MaskFormatter;
import model.Animal;
import model.TipoEntrada;
import model.Raca;
import model.Classificacao;
import utils.DateUtils;
import utils.NumberUtils;

/**
 *
 * @author Ruan
 */
public class ViewManutencaoAnimal extends ViewManutencao<Animal> {

    public ViewManutencaoAnimal() {
        initComponents();
        this.agrupaRadioButtonsSexo();
        this.formataCampos();
        this.radioButtonMacho.setSelected(true);
        this.campoDataAquisicao.setText(DateUtils.dateToString(new Date(System.currentTimeMillis())));
    }
    
    private void agrupaRadioButtonsSexo() {
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.radioButtonMacho);
        buttonGroup.add(this.radioButtonFemea);
    }

    private void formataCampos() {
        this.formataCampo(this.campoPesoEntrada,    MASCARA_DOUBLE_9_3, '0');
        this.formataCampo(this.campoValor,          MASCARA_DOUBLE_8_2, '0');
        this.formataCampo(this.campoDataAquisicao,  MASCARA_DATE,       '0');
        this.formataCampo(this.campoDataNascimento, MASCARA_DATE,       '0');
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoId = new javax.swing.JFormattedTextField();
        campoBrinco = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botaoConfirmar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        campoNome = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        comboBoxTipoEntrada = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboBoxRaca = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboBoxClassificacao = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        radioButtonMacho = new javax.swing.JRadioButton();
        radioButtonFemea = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        campoPesoEntrada = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        comboBoxPai = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        comboBoxMae = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        campoDataAquisicao = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        campoDataNascimento = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaObservacoes = new javax.swing.JTextArea();
        botaoBuscarInfoWebService = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        campoValor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Classificação");
        setResizable(false);

        campoId.setEnabled(false);

        jLabel1.setText("Id:");

        jLabel3.setText("Nº do Brinco:");

        botaoConfirmar.setText("Confirmar");

        botaoFechar.setText("Fechar");

        jLabel2.setText("Nome:");

        jLabel4.setText("Tipo de Entrada:");

        jLabel5.setText("Raça:");

        jLabel6.setText("Classificação:");

        jLabel7.setText("Sexo:");

        radioButtonMacho.setText("Macho");

        radioButtonFemea.setText("Fêmea");

        jLabel8.setText("Peso Entrada:");

        jLabel9.setText("Pai:");

        jLabel10.setText("Mãe:");

        jLabel11.setText("Data de Aquisição:");

        jLabel12.setText("Data de Nascimento:");

        jLabel13.setText("Observações:");

        textAreaObservacoes.setColumns(20);
        textAreaObservacoes.setRows(5);
        jScrollPane1.setViewportView(textAreaObservacoes);

        botaoBuscarInfoWebService.setText("Buscar Info");

        jLabel14.setText("Valor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoFechar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoBrinco)
                                .addComponent(campoNome)
                                .addComponent(comboBoxTipoEntrada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxRaca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxClassificacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(radioButtonMacho)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(radioButtonFemea))
                                .addComponent(comboBoxPai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxMae, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(campoPesoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoDataAquisicao, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(campoDataNascimento)))
                            .addComponent(botaoBuscarInfoWebService))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBrinco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(botaoBuscarInfoWebService))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboBoxTipoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(campoDataAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboBoxRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(campoDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboBoxClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(radioButtonMacho)
                            .addComponent(radioButtonFemea))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(campoPesoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(comboBoxPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(comboBoxMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmar)
                    .addComponent(botaoFechar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Animal getModelFromDadosTela() {
        Animal model = new Animal();
        if (!this.campoId.getText().equals("")) {
            model.setId(Integer.valueOf(campoId.getText()));
        }
        model.setBrinco(this.campoBrinco.getText());
        model.setNome(this.campoNome.getText());
        model.setDataNascimento(DateUtils.stringToDate(this.campoDataNascimento.getText()));
        model.setDataAquisicao(DateUtils.stringToDate(this.campoDataAquisicao.getText()));
        model.setPesoEntrada(NumberUtils.parseFloat(this.campoPesoEntrada.getText()));
        model.setValor(NumberUtils.parseFloat(this.campoValor.getText()));
        model.setObservacoes(this.textAreaObservacoes.getText());
        model.setStatus(Animal.STATUS_ATIVO);
        
        if (this.radioButtonMacho.isSelected()) {
            model.setSexo(Animal.SEXO_MACHO);
        }
        else if (this.radioButtonFemea.isSelected()) {
            model.setSexo(Animal.SEXO_FEMEA);
        }
        
        model.setClassificacao(this.comboBoxClassificacao.getItemAt(this.comboBoxClassificacao.getSelectedIndex()));
        model.setRaca(this.comboBoxRaca.getItemAt(this.comboBoxRaca.getSelectedIndex()));
        model.setTipoEntrada(this.comboBoxTipoEntrada.getItemAt(this.comboBoxTipoEntrada.getSelectedIndex()));
        
        Animal pai = this.comboBoxPai.getItemAt(this.comboBoxPai.getSelectedIndex());
        if (pai != null && pai.getId() > 0) {
            model.setPai(pai);
        }
        Animal mae = this.comboBoxMae.getItemAt(this.comboBoxMae.getSelectedIndex());
        if (mae != null && mae.getId() > 0) {
            model.setMae(mae);
        }
        return model;
    }

    @Override
    public void beanDados() {
        this.campoId.setText(String.valueOf(this.getModel().getId()));
        this.campoBrinco.setText(this.getModel().getBrinco());
        this.campoNome.setText(this.getModel().getNome());
        this.campoDataNascimento.setText(DateUtils.dateToString(this.getModel().getDataNascimento()));
        this.campoDataAquisicao.setText(DateUtils.dateToString(this.getModel().getDataAquisicao()));
        this.campoPesoEntrada.setText(NumberUtils.formataValor(this.getModel().getPesoEntrada(), 3, true, ((MaskFormatter) this.campoPesoEntrada.getFormatter()).getMask().length() + 1));
        this.campoValor.setText(NumberUtils.formataValor(this.getModel().getValor(), 2, true, ((MaskFormatter) this.campoValor.getFormatter()).getMask().length() + 1));
        this.textAreaObservacoes.setText(this.getModel().getObservacoes());
        
        this.radioButtonMacho.setSelected(this.getModel().getSexo().equalsIgnoreCase(Animal.SEXO_MACHO));
        this.radioButtonFemea.setSelected(this.getModel().getSexo().equalsIgnoreCase(Animal.SEXO_FEMEA));
        
        this.comboBoxClassificacao.setSelectedItem(this.getModel().getClassificacao());
        this.comboBoxRaca.setSelectedItem(this.getModel().getRaca());
        this.comboBoxTipoEntrada.setSelectedItem(this.getModel().getTipoEntrada());
        
        Animal pai = this.getModel().getPai();
        if (pai != null && pai.isChavePreenchida()) {
            this.comboBoxPai.setSelectedItem(pai);
        }
        Animal mae = this.getModel().getMae();
        if (mae != null && mae.isChavePreenchida()) {
            this.comboBoxMae.setSelectedItem(mae);
        }
    }

    @Override
    public Animal getInstanceModel() {
        return new Animal();
    }

    @Override
    public void trataCamposVisualizacao(Container container) {
        super.trataCamposVisualizacao(container);
        this.getBotaoConfirmar().setEnabled(false);
    }
    
    public JButton getBotaoConfirmar() {
        return botaoConfirmar;
    }

    public JButton getBotaoFechar() {
        return botaoFechar;
    }

    public JButton getBotaoBuscarInfoWebService() {
        return botaoBuscarInfoWebService;
    }

    public JComboBox<Classificacao> getComboBoxClassificacao() {
        return comboBoxClassificacao;
    }

    public JComboBox<Animal> getComboBoxMae() {
        return comboBoxMae;
    }

    public JComboBox<Animal> getComboBoxPai() {
        return comboBoxPai;
    }

    public JComboBox<Raca> getComboBoxRaca() {
        return comboBoxRaca;
    }

    public JComboBox<TipoEntrada> getComboBoxTipoEntrada() {
        return comboBoxTipoEntrada;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBuscarInfoWebService;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JFormattedTextField campoBrinco;
    private javax.swing.JFormattedTextField campoDataAquisicao;
    private javax.swing.JFormattedTextField campoDataNascimento;
    private javax.swing.JFormattedTextField campoId;
    private javax.swing.JFormattedTextField campoNome;
    private javax.swing.JFormattedTextField campoPesoEntrada;
    private javax.swing.JFormattedTextField campoValor;
    private javax.swing.JComboBox<Classificacao> comboBoxClassificacao;
    private javax.swing.JComboBox<Animal> comboBoxMae;
    private javax.swing.JComboBox<Animal> comboBoxPai;
    private javax.swing.JComboBox<Raca> comboBoxRaca;
    private javax.swing.JComboBox<TipoEntrada> comboBoxTipoEntrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioButtonFemea;
    private javax.swing.JRadioButton radioButtonMacho;
    private javax.swing.JTextArea textAreaObservacoes;
    // End of variables declaration//GEN-END:variables
}
