package controller;

import dao.Dao;
import model.Usuario;
import view.ViewPrimeiroLogin;

/**
 *
 * @author Ruan
 */
public class ControllerPrimeiroLogin extends ControllerManutencao<Usuario, ViewPrimeiroLogin, Dao> {

    static private Usuario usuarioLogado;

    public ControllerPrimeiroLogin(Controller caller, boolean visualizacao) {
        super(caller, visualizacao);
    }
    
    @Override
    public Usuario getInstanceModel() {
        return new Usuario();
    }

    @Override
    public ViewPrimeiroLogin getInstanceView() {
        return new ViewPrimeiroLogin();
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
    }

    @Override
    public boolean processaDados() {
        boolean retorno = false;
        this.setModel(this.getView().getModelFromDadosTela());
        if (this.getModel().getLogin() != null && this.getModel().getSenha() != null) {
            retorno = this.getDao().add(this.getModel());
        }
        return retorno;
    }

    private void addListenerAcoes() {
        this.addListenerCadastrar();
        this.addListenerSair();
    }
    
    private void addListenerCadastrar() {
        this.getView().getBotaoCadastrar().addActionListener((e) -> {
            if (this.getView().isSenhasIguais()) {
                if (this.processaDados()) {
                    this.getView().dispose();
                    (new ControllerLogin(this, false)).montaTela();
                }
                else {
                    this.getView().showMensagem("Houve um erro ao tentar inserir seu usuário.");
                }
            }
            else {
                this.getView().showMensagem("As senhas são diferentes");
            }
        });
    }
    
    private void addListenerSair() {
        this.getView().getBotaoSair().addActionListener((e) -> {
            System.exit(0);
        });
    }

    @Override
    public Dao getInstanceDao() {
        return new Dao(Usuario.class);
    }

}