package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
import model.Model;

/**
 * Tela base para as diversas telas do sistema
 * @author Ruan
 * @param <TypeModel>
 */
abstract public class View<TypeModel extends Model> extends JFrame {
    
    static public final String MASCARA_DOUBLE_11_2 = "###.###.###,##";
    static public final String MASCARA_DOUBLE_9_3  = "###.###,###";
    static public final String MASCARA_DOUBLE_8_2  = "###.###,##";
    static public final String MASCARA_DOUBLE_7_2  = "##.###,##";
    static public final String MASCARA_DATE        = "##/##/####";
    
    protected TypeModel model;

    public View() throws HeadlessException {
        this.model = this.getInstanceModel();
    }

    abstract public TypeModel getInstanceModel();
    
    /**
     * Dispara uma mensagem 
     */
    public void showMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    /**
     * Dispara uma mensagem de pergunta
     * @param mensagem          Mensagem
     * @param titulo            Título
     * @param opcoesDisponiveis Opções na tela: <code>JOptionPane.YES_NO_OPTION</code>, <code>JOptionPane.YES_NO_CANCEL_OPTION</code> ou <code>JOptionPane.OK_CANCEL_OPTION</code>
     * @return int <code>JOptionPane.YES_OPTION</code>, <code>JOptionPane.NO_OPTION</code>, <code>JOptionPane.CANCEL_OPTION</code>, <code>JOptionPane.OK_OPTION</code>, <code>JOptionPane.CLOSED_OPTION</code>
     */
    public int showDialog(String mensagem, String titulo, int opcoesDisponiveis) {
        return JOptionPane.showConfirmDialog(this, mensagem, titulo, opcoesDisponiveis);
    }
    
    protected void formataCampo(JFormattedTextField campo, String formato) {
        this.formataCampo(campo, formato, ' ');
    }
    
    protected void formataCampo(JFormattedTextField campo, String formato, char placeHolder) {
        try {
            MaskFormatter mask = new MaskFormatter(formato);
            mask.setPlaceholderCharacter(placeHolder);
            campo.setFormatterFactory(new DefaultFormatterFactory(mask));
        }
        catch (ParseException ex) {
            this.showMensagem("Erro ao formatar o campo " + campo.getName());
        }
    }
    
    public TypeModel getModel() {
        if (this.model == null) {
            this.model = this.getInstanceModel();
        }
        return model;
    }

    public void setModel(TypeModel model) {
        this.model = model;
    }

    public void clearAll() {
        for (Component c : this.getComponents()) {
            if (c instanceof JTextField || c instanceof JTextArea) {
                ((JTextComponent) c).setText("");
            }
            else if (c instanceof JRadioButton) {
                ((JRadioButton) c).setSelected(false);
            }
            else if (c instanceof JComboBox) {
                if (((JComboBox) c).getItemCount() > 0) {
                    ((JComboBox) c).setSelectedIndex(0);
                }
            }
            else if (c instanceof Container) {
                this.clearAll((Container) c);
            }
        }
    }
    
    public void clearAll(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof JTextField || c instanceof JTextArea) {
                ((JTextComponent) c).setText("");
            }
            else if (c instanceof JRadioButton) {
                ((JRadioButton) c).setSelected(false);
            }
            else if (c instanceof JComboBox) {
                if (((JComboBox) c).getItemCount() > 0) {
                    ((JComboBox) c).setSelectedIndex(0);
                }
            }
            else if (c instanceof Container) {
                this.clearAll((Container) c);
            }
        }
    }
    
}