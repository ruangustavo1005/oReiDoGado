package view;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import model.UnidadeMedida;
import utils.CampoFiltro;
import utils.OperadorFiltro;

/**
 *
 * @author Ruan
 */
public class ViewConsultaUnidadeMedida extends ViewConsulta<UnidadeMedida> {

    public ViewConsultaUnidadeMedida() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoInserir = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoVisualizar = new javax.swing.JButton();
        botaoConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        listaCampo = new javax.swing.JComboBox<>();
        listaOperador = new javax.swing.JComboBox<>();
        campoFiltro = new javax.swing.JFormattedTextField();
        campoFiltro2 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Unidades de Medida");
        setResizable(false);

        botaoInserir.setText("Inserir");

        botaoAlterar.setText("Alterar");

        botaoExcluir.setText("Excluir");

        botaoVisualizar.setText("Visualizar");

        botaoConsultar.setText("Consultar");

        table.setModel(this.getTableModel());
        jScrollPane1.setViewportView(table);

        jLabel1.setText("Filtros:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listaCampo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoInserir)
                        .addGap(18, 18, 18)
                        .addComponent(botaoAlterar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVisualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listaOperador, 0, 110, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)))
                .addComponent(botaoConsultar)
                .addGap(12, 12, 12))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoInserir)
                    .addComponent(botaoAlterar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoVisualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConsultar)
                    .addComponent(jLabel1)
                    .addComponent(listaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listaOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public ArrayList<JButton> getAcoesGrid() {
        ArrayList<JButton> acoes = new ArrayList<>();
        acoes.add(this.getBotaoAlterar());
        acoes.add(this.getBotaoExcluir());
        acoes.add(this.getBotaoVisualizar());
        return acoes;
    }

    @Override
    public JTable getTable() {
        return this.table;
    }

    @Override
    public UnidadeMedida getInstanceModel() {
        return new UnidadeMedida();
    }

    @Override
    public ArrayList<JButton> getAcoesGridMultiSelecao() {
        ArrayList<JButton> retorno = super.getAcoesGridMultiSelecao();
        retorno.add(this.getBotaoExcluir());
        return retorno;
    }
    
    public JButton getBotaoAlterar() {
        return botaoAlterar;
    }

    public void setBotaoAlterar(JButton botaoAlterar) {
        this.botaoAlterar = botaoAlterar;
    }

    public JButton getBotaoConsultar() {
        return botaoConsultar;
    }

    public void setBotaoConsultar(JButton botaoConsultar) {
        this.botaoConsultar = botaoConsultar;
    }

    public JButton getBotaoExcluir() {
        return botaoExcluir;
    }

    public void setBotaoExcluir(JButton botaoExcluir) {
        this.botaoExcluir = botaoExcluir;
    }

    public JButton getBotaoInserir() {
        return botaoInserir;
    }

    public void setBotaoInserir(JButton botaoInserir) {
        this.botaoInserir = botaoInserir;
    }

    public JButton getBotaoVisualizar() {
        return botaoVisualizar;
    }

    public void setBotaoVisualizar(JButton botaoVisualizar) {
        this.botaoVisualizar = botaoVisualizar;
    }

    @Override
    public JFormattedTextField getCampoValorFiltro() {
        return this.campoFiltro;
    }

    @Override
    public JFormattedTextField getCampoValorFiltro2() {
        return this.campoFiltro2;
    }

    @Override
    public JComboBox<CampoFiltro> getListaCampo() {
        return this.listaCampo;
    }

    @Override
    public JComboBox<OperadorFiltro> getListaOperador() {
        return this.listaOperador;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoConsultar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoInserir;
    private javax.swing.JButton botaoVisualizar;
    private javax.swing.JFormattedTextField campoFiltro;
    private javax.swing.JFormattedTextField campoFiltro2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<CampoFiltro> listaCampo;
    private javax.swing.JComboBox<OperadorFiltro> listaOperador;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
