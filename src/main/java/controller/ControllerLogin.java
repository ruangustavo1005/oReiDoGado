package controller;

import dao.Dao;
import dao.DaoLogin;
import model.Usuario;
import view.ViewLogin;

/**
 *
 * @author Ruan
 */
public class ControllerLogin extends ControllerManutencao<Usuario, ViewLogin, DaoLogin> {

    static private Usuario usuarioLogado;

    public ControllerLogin(Controller caller, boolean visualizacao) {
        super(caller, visualizacao);
    }
    
    @Override
    public Usuario getInstanceModel() {
        return new Usuario();
    }

    @Override
    public ViewLogin getInstanceView() {
        return new ViewLogin();
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
            int id = this.getDao().dadosLoginCorretos(this.getModel());
            retorno = id != 0;
            if (retorno) {
                this.setModel(this.getDao().get(id));
                ControllerLogin.usuarioLogado = this.getModel();
            }
        }
        return retorno;
    }

    private void addListenerAcoes() {
        this.addListenerEntrar();
        this.addListenerSair();
    }
    
    private void addListenerEntrar() {
        this.getView().getBotaoEntrar().addActionListener((e) -> {
            if (this.processaDados()) {
                this.getView().dispose();
                (new ControllerIndex(this)).montaTela();
            }
            else {
                this.getView().showMensagem("Dados incorretos!");
            }
        });
    }
    
    private void addListenerSair() {
        this.getView().getBotaoSair().addActionListener((e) -> {
            System.exit(0);
        });
    }

    @Override
    public DaoLogin getInstanceDao() {
        return new DaoLogin();
    }

    static public Usuario getUsuarioLogado() {
        return ControllerLogin.usuarioLogado;
    }
    
    static public boolean existeUsuario() {
        return (new Dao(Usuario.class)).get().size() > 0;
    }

}