package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    JFrame janela;
    JMenuItem jmiFinalizar,
            jmiUsuarioCad,jmiUsuarioCons,jmiUsuarioAlt,jmiUsuarioExc,
            jmiCategoriaCad,jmiCategoriaCons,jmiCategoriaAlt,jmiCategoriaExc,
            jmiContaCad,jmiContaCons,jmiContaAlt,jmiContaExc,
            jmiMovimentacaoCad,jmiMovimentacaoCons,jmiMovimentacaoAlt,jmiMovimentacaoExc;
    public Main (){
        janela = new JFrame ("Gerenciado Finaceiro Pessoal");
        janela.setSize(350,250);
        janela.setLocationRelativeTo(null);
        janela.getContentPane().setBackground(new Color(200, 230, 201));

        // intanciar /criar uma barra para o menu
        JMenuBar jmBar = new JMenuBar();
        jmBar.setBackground(new Color(255, 255, 255));
        janela.setJMenuBar(jmBar);
        JMenu jmCadastro = new JMenu("Cadastro");
        JMenu jmConsulta = new JMenu("Consultar");
        JMenu jmAlteracao = new JMenu("Alteraração");
        JMenu jmExclucao = new JMenu("Exclução");
        JMenu jmSair = new JMenu("Sair");

        //adiconar o menu
        jmBar.add(jmCadastro);
        jmBar.add(jmConsulta);
        jmBar.add(jmAlteracao);
        jmBar.add(jmExclucao);
        jmBar.add(jmSair);

        //instanciar os itens do menu
        jmiFinalizar = new JMenuItem("Finalizar");
        jmiUsuarioCad= new JMenuItem("Usuário");
        jmiUsuarioCons = new JMenuItem("Usuário");
        jmiUsuarioAlt = new JMenuItem("Usuário");
        jmiUsuarioExc = new JMenuItem("Usuário");

        // intanciar a c categotia no menu
        jmiCategoriaCad = new JMenuItem("Categoria");
        jmiCategoriaCons = new JMenuItem("Categoria");
        jmiCategoriaAlt = new JMenuItem("Categoria");
        jmiCategoriaExc = new JMenuItem("Categoria");

        jmiContaCad = new JMenuItem("Conta");
        jmiContaCons = new JMenuItem("Conta");
        jmiContaAlt = new JMenuItem("Conta");
        jmiContaExc = new JMenuItem("Conta");

        jmiMovimentacaoCad = new JMenuItem("Movimentação");
        jmiMovimentacaoCons = new JMenuItem("Movimentação");
        jmiMovimentacaoAlt = new JMenuItem("Movimentação");
        jmiMovimentacaoExc = new JMenuItem("Movimentação");



        //adicionar o item ao menu
        jmSair.add(jmiFinalizar);

        //CRUD - Usuário
        jmCadastro.add(jmiUsuarioCad);
        jmConsulta.add(jmiUsuarioCons);
        jmAlteracao.add(jmiUsuarioAlt);
        jmExclucao.add(jmiUsuarioExc);

        jmCadastro.add(jmiCategoriaCad);
        jmConsulta.add(jmiCategoriaCons);
        jmAlteracao.add(jmiCategoriaAlt);
        jmExclucao.add(jmiCategoriaExc);

        jmCadastro.add(jmiContaCad);
        jmConsulta.add(jmiContaCons);
        jmAlteracao.add(jmiContaAlt);
        jmExclucao.add(jmiContaExc);

        jmCadastro.add(jmiMovimentacaoCad);
        jmConsulta.add(jmiMovimentacaoCons);
        jmAlteracao.add(jmiMovimentacaoAlt);
        jmExclucao.add(jmiMovimentacaoExc);

        //adicionar ação ao menu
        jmiFinalizar.addActionListener(this);
        jmiUsuarioCad.addActionListener(this);
        jmiUsuarioCons.addActionListener(this);
        jmiUsuarioAlt.addActionListener(this);
        jmiUsuarioExc.addActionListener(this);

        //adicionar o this na categoria
        jmiCategoriaCad.addActionListener(this);
        jmiCategoriaCons.addActionListener(this);
        jmiCategoriaAlt.addActionListener(this);
        jmiCategoriaExc.addActionListener(this);

        jmiContaCad.addActionListener(this);
        jmiContaCons.addActionListener(this);
        jmiContaAlt.addActionListener(this);
        jmiContaExc.addActionListener(this);

        jmiMovimentacaoCad.addActionListener(this);
        jmiMovimentacaoCons.addActionListener(this);
        jmiMovimentacaoAlt.addActionListener(this);
        jmiMovimentacaoExc.addActionListener(this);

        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JanelaUsuario janelaUsuario = new JanelaUsuario();
        JanelaCategoria janelaCategoria = new JanelaCategoria();
        JanelaConta janelaConta = new JanelaConta();
        JanelaMovimentacao janelaMovimentacao= new JanelaMovimentacao();
        String resultado;
        if(e.getSource() == jmiFinalizar){
            System.exit(0);
        }else if (e.getSource() == jmiUsuarioCad){
            janelaUsuario.cadastrar();
        } else if (e.getSource()==jmiUsuarioCons) {
            resultado = janelaUsuario.consultar();
            JTextArea textoArea = new JTextArea(resultado,20,110);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            JOptionPane.showMessageDialog(null, jScrollPane,"CONSULTA USUÁRIO", 1);
        } else if (e.getSource()==jmiUsuarioExc) {
            resultado = janelaUsuario.resulmo();
            JTextArea textoArea = new JTextArea(resultado,20,30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            int id = Integer.parseInt(JOptionPane.showInputDialog(null,jScrollPane,
                    "Digite o id do usuário que deseja excluir",-1));
            janelaUsuario.excluir(id);
        } else if (e.getSource()==jmiUsuarioAlt) {
            resultado = janelaUsuario.resulmo();
            JTextArea textoArea = new JTextArea(resultado,20, 30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,"Digite o id do usuário que deseja alterar",1));
            janelaUsuario.alterar(id);
        } else if (e.getSource() ==jmiCategoriaCad) {
            resultado = janelaUsuario.resulmo();
            JTextArea textoArea = new JTextArea(resultado,20,30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            int idUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                    "Digite o id do usuário que deseja cadastrar a categoria?",1));
            janelaCategoria.cadastrar(idUsuario);
        }else if (e.getSource()==jmiCategoriaCons){
            resultado = janelaCategoria.consultar();
            JTextArea textoArea = new JTextArea(resultado,20, 30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            JOptionPane.showMessageDialog(null, jScrollPane);
        } else if (e.getSource() == jmiCategoriaAlt){
            resultado = janelaCategoria.consultar();
            JTextArea textoArea = new JTextArea(resultado,20, 30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane, "Digite o id da categoria que deseja alterar",1));
            resultado = janelaUsuario.resulmo();
            textoArea = new JTextArea(resultado,20,30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            int idUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                    "Digite o id do usuario que deseja alterar?",1));
            janelaCategoria.alterar(id,idUsuario);
        } else if (e.getSource() == jmiCategoriaExc) {
            resultado = janelaCategoria.consultar();
            JTextArea textoArea = new JTextArea(resultado,20, 30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                    "Digite o id da categoria que deseja excluir",-1));
            janelaCategoria.excluir(id);
        } else if (e.getSource()== jmiContaCad) {
            resultado = janelaUsuario.resulmo();
            JTextArea textoArea = new JTextArea(resultado,20,30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            int idUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                    "Digite o id que deseja cadastrar a categoria?",1));
            janelaConta.cadastrar(idUsuario);
        }else if (e.getSource() == jmiContaAlt){
            resultado = janelaConta.consultar();
            JTextArea textoArea = new JTextArea(resultado,20, 30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane, "Digite o id da Conta que deseja alterar",1));
            resultado = janelaUsuario.resulmo();
            textoArea = new JTextArea(resultado,20,30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            int idUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                    "Digite o id do usuario que deseja alterar?",1));
            janelaConta.alterar(id,idUsuario);
        } else if (e.getSource() == jmiContaExc) {
             resultado = janelaConta.consultar();
            JTextArea textoArea = new JTextArea(resultado,20, 30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
             int id = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                     "\nDigite o id da conta que deseja excluir",-1));
             janelaConta.excluir(id);
        } else if (e.getSource()==jmiContaCons){
            resultado = janelaConta.consultar();
            JTextArea textoArea = new JTextArea(resultado,15, 25);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            JOptionPane.showMessageDialog(null, jScrollPane,resultado,1);
        }else if (e.getSource()== jmiMovimentacaoCad) {
            resultado = janelaUsuario.resulmo();
            JTextArea textoArea = new JTextArea(resultado,10,20);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            int idUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                    "Digite o id do usuário que deseja cadastrar na movimentação ?",1));
            resultado = janelaCategoria.consultar();
            textoArea = new JTextArea(resultado,20,30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            int idCategoria = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                    "Digite o id da categoria que deseja cadastrar na movimentação?",1));
            resultado = janelaConta.consultar();
            textoArea = new JTextArea(resultado,20,30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            int idConta = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                    "Digite o id da conta que deseja cadastrar na movimentacao?",1));
            janelaMovimentacao.cadastrar(idUsuario,idCategoria,idConta);
        }else if (e.getSource()== jmiMovimentacaoAlt) {
            resultado = janelaMovimentacao.resulmo();
            JTextArea textoArea = new JTextArea(resultado,30,40);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            int idMovimentacao = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                    "Digite o id da Movimentacao que deseja alterar?",1));
            resultado = janelaUsuario.resulmo();
             textoArea = new JTextArea(resultado,10, 20);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            jScrollPane = new JScrollPane(textoArea);
            int idUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                    "Digite o id do usuário que deseja alterar na movimentação ?",1));
            resultado = janelaCategoria.consultar();
            textoArea = new JTextArea(resultado,20,30);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            int idCategoria = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                    "Digite o id da categoria que deseja alterar na movimentação?",1));
            resultado = janelaConta.consultar();
            textoArea = new JTextArea(resultado,20,25);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            int idConta = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                    "Digite o id da conta que deseja alterar na movimentacao?",1));
            janelaMovimentacao.alterar(idMovimentacao,idUsuario,idCategoria,idConta);
        }else if (e.getSource()==jmiMovimentacaoCons) {
            resultado = janelaMovimentacao.consultar();
            JTextArea textoArea = new JTextArea(resultado,30, 65);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            JOptionPane.showMessageDialog(null, jScrollPane, resultado,1);
        }else if (e.getSource() == jmiMovimentacaoExc) {
            resultado = janelaMovimentacao.resulmo();
            JTextArea textoArea = new JTextArea(resultado,30, 35);
            textoArea.setEditable(false);
            textoArea.setCaretPosition(0);
            JScrollPane jScrollPane = new JScrollPane(textoArea);
            jScrollPane.createVerticalScrollBar();
            jScrollPane.createHorizontalScrollBar();
            int idMovimentacao = Integer.parseInt(JOptionPane.showInputDialog(null, jScrollPane,
                    "Digite o id da movimentação que deseja excluir",-1));
            janelaMovimentacao.excluir(idMovimentacao);
        }
    }
}
