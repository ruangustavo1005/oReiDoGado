package view;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.text.MaskFormatter;
import model.Area;
import model.UnidadeMedida;
import utils.NumberUtils;

/**
 *
 * @author Ruan
 */
public class ViewManutencaoArea extends ViewManutencao<Area> {

    public ViewManutencaoArea() {
        initComponents();
        this.formataCampo(this.campoAreaOcupada, MASCARA_DOUBLE_7_2, '0');
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoId = new javax.swing.JFormattedTextField();
        campoDescricao = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botaoConfirmar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        campoAreaOcupada = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        comboBoxUnidadeMedida = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Área");
        setResizable(false);

        campoId.setEnabled(false);

        jLabel1.setText("Id:");

        jLabel3.setText("Descrição:");

        botaoConfirmar.setText("Confirmar");

        botaoFechar.setText("Fechar");

        jLabel2.setText("Área:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoFechar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoAreaOcupada, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxUnidadeMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
                    .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoAreaOcupada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmar)
                    .addComponent(botaoFechar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Area getModelFromDadosTela() {
        Area model = new Area();
        if (!this.campoId.getText().equals("")) {
            model.setId(Integer.valueOf(campoId.getText()));
        }
        model.setDescricao(this.campoDescricao.getText());
        model.setAreaOcupada(NumberUtils.parseFloat(this.campoAreaOcupada.getText()));
        model.setUnidadeMedida(this.getComboBoxUnidadeMedida().getItemAt(this.getComboBoxUnidadeMedida().getSelectedIndex()));
        return model;
    }

    @Override
    public void beanDados() {
        this.campoId.setText(String.valueOf(this.getModel().getId()));
        this.campoDescricao.setText(this.getModel().getDescricao());
        this.campoAreaOcupada.setText(NumberUtils.formataValor(this.getModel().getAreaOcupada(), 2, true, ((MaskFormatter) this.campoAreaOcupada.getFormatter()).getMask().length() + 1));
        this.comboBoxUnidadeMedida.setSelectedItem(this.getModel().getUnidadeMedida());
    }

    @Override
    public Area getInstanceModel() {
        return new Area();
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

    public JComboBox<UnidadeMedida> getComboBoxUnidadeMedida() {
        return comboBoxUnidadeMedida;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JFormattedTextField campoAreaOcupada;
    private javax.swing.JFormattedTextField campoDescricao;
    private javax.swing.JFormattedTextField campoId;
    private javax.swing.JComboBox<UnidadeMedida> comboBoxUnidadeMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
