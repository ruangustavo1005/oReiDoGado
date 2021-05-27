package view;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import model.Animal;
import utils.CampoFiltro;
import utils.OperadorFiltro;

/**
 *
 * @author Ruan
 */
public class ViewIndex extends ViewConsulta<Animal> {

    public ViewIndex() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        botaoConsultar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        botaoInserir = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoVisualizar = new javax.swing.JButton();
        botaoInserirManejoLote = new javax.swing.JButton();
        botaoInserirManejo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        listaCampo = new javax.swing.JComboBox<>();
        listaOperador = new javax.swing.JComboBox<>();
        campoFiltro = new javax.swing.JFormattedTextField();
        campoFiltro2 = new javax.swing.JFormattedTextField();
        botaoGerenciarManejos = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuArea = new javax.swing.JMenuItem();
        menuClassificacao = new javax.swing.JMenuItem();
        menuMedicamento = new javax.swing.JMenuItem();
        menuRaca = new javax.swing.JMenuItem();
        menuTipoEntrada = new javax.swing.JMenuItem();
        menuUnidadeMedida = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("O Rei do Gado");
        setResizable(false);

        table.setModel(this.getTableModel());
        jScrollPane1.setViewportView(table);

        botaoConsultar.setText("Consultar");

        botaoSair.setText("Sair");

        botaoInserir.setText("Inserir");

        botaoAlterar.setText("Alterar");

        botaoExcluir.setText("Excluir");

        botaoVisualizar.setText("Visualizar");

        botaoInserirManejoLote.setText("Inserir Manejo em Lote");

        botaoInserirManejo.setText("Inserir Manejo");

        jLabel1.setText("Filtros:");

        botaoGerenciarManejos.setText("Gerenciar Manejos");

        jMenu1.setText("Gerenciamento");

        menuArea.setText("Área");
        jMenu1.add(menuArea);

        menuClassificacao.setText("Classificação");
        jMenu1.add(menuClassificacao);

        menuMedicamento.setText("Medicamento");
        jMenu1.add(menuMedicamento);

        menuRaca.setText("Raça");
        jMenu1.add(menuRaca);

        menuTipoEntrada.setText("Tipo de Entrada");
        jMenu1.add(menuTipoEntrada);

        menuUnidadeMedida.setText("Unidade de Medida");
        jMenu1.add(menuUnidadeMedida);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoInserir)
                        .addGap(18, 18, 18)
                        .addComponent(botaoAlterar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listaCampo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listaOperador, 0, 110, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(346, 346, 346)
                        .addComponent(botaoConsultar)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVisualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoInserirManejo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoInserirManejoLote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoGerenciarManejos)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botaoSair)
                .addGap(16, 16, 16))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoInserir)
                    .addComponent(botaoAlterar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoVisualizar)
                    .addComponent(botaoInserirManejoLote)
                    .addComponent(botaoInserirManejo)
                    .addComponent(botaoGerenciarManejos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(listaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(listaOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSair)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public ArrayList<JButton> getAcoesGrid() {
        ArrayList<JButton> acoes = new ArrayList();
        acoes.add(this.getBotaoAlterar());
        acoes.add(this.getBotaoExcluir());
        acoes.add(this.getBotaoVisualizar());
        acoes.add(this.getBotaoInserirManejo());
        acoes.add(this.getBotaoInserirManejoLote());
        acoes.add(this.getBotaoGerenciarManejos());
        return acoes;
    }

    @Override
    public ArrayList<JButton> getAcoesGridMultiSelecao() {
        ArrayList<JButton> retorno = super.getAcoesGridMultiSelecao();
        retorno.add(this.getBotaoExcluir());
        retorno.add(this.getBotaoInserirManejoLote());
        return retorno;
    }
    
    @Override
    public JTable getTable() {
        return this.table;
    }

    @Override
    public Animal getInstanceModel() {
        return new Animal();
    }

    public JButton getBotaoAlterar() {
        return botaoAlterar;
    }

    public JButton getBotaoConsultar() {
        return botaoConsultar;
    }

    public JButton getBotaoExcluir() {
        return botaoExcluir;
    }

    public JButton getBotaoInserir() {
        return botaoInserir;
    }

    public JButton getBotaoInserirManejo() {
        return botaoInserirManejo;
    }

    public JButton getBotaoInserirManejoLote() {
        return botaoInserirManejoLote;
    }

    public JButton getBotaoGerenciarManejos() {
        return botaoGerenciarManejos;
    }

    public JButton getBotaoSair() {
        return botaoSair;
    }

    public JButton getBotaoVisualizar() {
        return botaoVisualizar;
    }

    public JMenuItem getMenuArea() {
        return menuArea;
    }

    public JMenuItem getMenuClassificacao() {
        return menuClassificacao;
    }

    public JMenuItem getMenuMedicamento() {
        return menuMedicamento;
    }

    public JMenuItem getMenuRaca() {
        return menuRaca;
    }

    public JMenuItem getMenuTipoEntrada() {
        return menuTipoEntrada;
    }

    public JMenuItem getMenuUnidadeMedida() {
        return menuUnidadeMedida;
    }

    @Override
    public JFormattedTextField getCampoValorFiltro() {
        return campoFiltro;
    }

    @Override
    public JFormattedTextField getCampoValorFiltro2() {
        return campoFiltro2;
    }

    @Override
    public JComboBox<CampoFiltro> getListaCampo() {
        return listaCampo;
    }

    @Override
    public JComboBox<OperadorFiltro> getListaOperador() {
        return listaOperador;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoConsultar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoGerenciarManejos;
    private javax.swing.JButton botaoInserir;
    private javax.swing.JButton botaoInserirManejo;
    private javax.swing.JButton botaoInserirManejoLote;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoVisualizar;
    private javax.swing.JFormattedTextField campoFiltro;
    private javax.swing.JFormattedTextField campoFiltro2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<CampoFiltro> listaCampo;
    private javax.swing.JComboBox<OperadorFiltro> listaOperador;
    private javax.swing.JMenuItem menuArea;
    private javax.swing.JMenuItem menuClassificacao;
    private javax.swing.JMenuItem menuMedicamento;
    private javax.swing.JMenuItem menuRaca;
    private javax.swing.JMenuItem menuTipoEntrada;
    private javax.swing.JMenuItem menuUnidadeMedida;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
