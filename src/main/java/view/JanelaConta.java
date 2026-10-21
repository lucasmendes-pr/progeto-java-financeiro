package view;

import dao.CategoriaDao;
import dao.ContaDao;
import dao.UsuarioDao;
import model.Categoria;
import model.Conta;
import model.Usuario;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JanelaConta implements ActionListener {
    JFrame janela;
    JLabel lbNomeConta,lbUsuario;
    JTextField tfNomeConta,tfUsuario;
    JButton btCadastrar,btCancelar,btAlterar;
    int idConta,idUsuario;
     public void cadastrar(int id){
         idUsuario = id;
         janela = new JFrame ("CADASTRO CONTA");
         janela.setSize(350,200);
         janela.setLocationRelativeTo(null);
         janela.getContentPane().setBackground(new Color(200, 230, 201));
         janela.setLayout(new GridLayout(3,2,5,10));

         lbNomeConta = new JLabel(" Qual conta: ");
         tfNomeConta = new JTextField(20);

         lbUsuario = new JLabel(" Id do Usuário: ");
         //carregar o nome do usuario (FK)
         EntityManager em = JPAUtil.getEntityMananger();
         UsuarioDao usuarioDao = new UsuarioDao(em);
         Usuario usuario = usuarioDao.buscarPorId(idUsuario);
         String nome = usuario.getNomeUsuario();
         tfUsuario = new JTextField(nome,20);
         tfUsuario.setEnabled(false);

         btCadastrar = new JButton("Cadastrar");
         btCancelar = new JButton("Cancelar");

         janela.add(lbNomeConta);
         janela.add(tfNomeConta);

         janela.add(lbUsuario);
         janela.add(tfUsuario);

         janela.add(btCadastrar);
         janela.add(btCancelar);

         btCadastrar.addActionListener(this);
         btCancelar.addActionListener(this);

         janela.setVisible(true);
         janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     }
    public void alterar(int id,int idUsuarioParm){
       idConta = id;
       idUsuario = idUsuarioParm;

        janela = new JFrame ("ALTERAR CONTA");
        janela.setSize(350,200);
        janela.setLocationRelativeTo(null);
        janela.getContentPane().setBackground(new Color(200, 230, 201));
        janela.setLayout(new GridLayout(3,2,5,10));
        EntityManager em = JPAUtil.getEntityMananger();
        ContaDao contaDao = new ContaDao(em);
        Conta conta = contaDao.buscarPorId(id);


        lbNomeConta = new JLabel(" Qual conta: ");
        tfNomeConta = new JTextField(20);
        UsuarioDao usuarioDao = new UsuarioDao(em);
        Usuario usuario = usuarioDao.buscarPorId(idUsuario);
        String nome = usuario.getNomeUsuario();
        lbUsuario = new JLabel("Nome do Usuário: ");
        //carregar o nome do usuario (FK)
        //conexao com o banco de dados
        tfUsuario = new JTextField(nome, 20);
        tfUsuario.setEnabled(false);
        btAlterar = new JButton("Alterar");
        btCancelar = new JButton("Cancelar");


        janela.add(lbNomeConta);
        janela.add(tfNomeConta);
        janela.add(lbUsuario);
        janela.add(tfUsuario);
        janela.add(btAlterar);
        janela.add(btCancelar);

        btAlterar.addActionListener(this);
        btCancelar.addActionListener(this);

        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btCancelar){
            tfNomeConta.setText("");
            tfUsuario.setText("");
        }else if (e.getSource()== btCadastrar) {
            String nomeCategoria = tfNomeConta.getText();
            Conta conta = new Conta(nomeCategoria,idUsuario);
            EntityManager em = JPAUtil.getEntityMananger();
            ContaDao contaDao = new ContaDao(em);
            em.getTransaction().begin();
            contaDao.cadastrar(conta);
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null,"Registro cadastrado com sucesso");
            janela.dispose();
        }else if (e.getSource() == btAlterar) {
            //criar conecao com o banco de dados
            EntityManager em = JPAUtil.getEntityMananger();
            ContaDao contaDao = new ContaDao(em);
            Conta conta = contaDao.buscarPorId(idConta);
            em.getTransaction().begin();
            contaDao.alterar(conta);
            conta.setNomeConta(tfNomeConta.getText());
            int idUsuario = Integer.parseInt(tfUsuario.getText());
            conta.setIdUsuario(idUsuario);
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null,"Registro alterado com sucesso");
            janela.dispose();
        }
    }
    public String consultar() {
        // criar conexao com banco
        EntityManager em = JPAUtil.getEntityMananger();
        ContaDao contaDao = new ContaDao(em);
        UsuarioDao usuarioDao = new UsuarioDao(em);
        List<Conta> todosRegistros = contaDao.buscarTodos();
        int qtdeRegistros = todosRegistros.size();
        String resultado = "ID - BANCO  - SALDO CONTA - NOME USUÁRIO\n";
        for (int i = 0 ; i < qtdeRegistros ; i++) {
            Usuario usuario = usuarioDao.buscarPorId(todosRegistros.get(i).getIdUsuario());
            resultado += todosRegistros.get(i).getIdConta()+" - "+
                    todosRegistros.get(i).getNomeConta() + " - " +
                    todosRegistros.get(i).getSaldoemConta() + " - " +
                    usuario.getNomeUsuario() + "\n";
        }
        return  resultado;
    }
    public void excluir(int id) {
        // criar conexao com banco
        EntityManager em = JPAUtil.getEntityMananger();
        ContaDao contaDao = new ContaDao(em);
        Conta conta = contaDao.buscarPorId(id);
        em.getTransaction().begin();
        contaDao.excluir(conta);
        em.getTransaction().commit();
        em.close();
        JOptionPane.showMessageDialog(null,"Registro excluído com sucesso");

    }
}
