package view;
import dao.CategoriaDao;
import dao.ContaDao;
import dao.MovimentacaoDao;
import dao.UsuarioDao;
import model.Categoria;
import model.Conta;
import model.Movimentacao;
import model.Usuario;
import util.JPAUtil;
import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JanelaMovimentacao implements ActionListener {
    JFrame janela;
    JLabel lbDescricao,lbDescricaoPagamento,lbValor,lbStatus,lbTipo, lbDataMovimentacao,lbCategoria,lbConta,lbUsuario;
    JTextField tfDescricao,tfValor,tfDataMovimentacao,tfCategoria,tfConta,tfUsuario;
    JButton btCadastrar,btCancelar,btAlterar;
    int idMovimentacao,idUsuario,idCategoria, idConta;
    String status [] = {"Selecione uma Opção","Pendente","Pago","Recebido"};
    String tipo []= {"Selecione uma Opção","Receita","Despesas"};
    String descricaoPagamento [] = {"Selecione uma Opção","Cartão de Crédito","Cartão de Débito","Pix","Dinheiro"};

    JComboBox  jcbxStatus,jcbxTipo,jcbxDescricaoPagamento;


    public void cadastrar(int idUsuarioParam,int idCategoriaParam, int idContaParam) {
        idConta = idContaParam;
        idUsuario = idUsuarioParam;
        idCategoria = idCategoriaParam;

        janela = new JFrame("CADASTRO MOVIMENTAÇÃO");
        janela.setSize(400, 500);
        janela.setLocationRelativeTo(null);
        janela.getContentPane().setBackground(new Color(200, 230, 201));
        janela.setLayout(new GridLayout(9, 2, 5, 10));

        lbCategoria = new JLabel("Nome Categoria:");
        EntityManager em = JPAUtil.getEntityMananger();
        CategoriaDao categoriaDao = new CategoriaDao(em);
        Categoria categoria = categoriaDao.buscarPorId(idCategoria);
        String nomeCategoria = categoria.getNomeCategoria();
        tfCategoria = new JTextField(nomeCategoria, 20);
        tfCategoria.setEnabled(false);

        lbDescricao = new JLabel("Descrição:");
        tfDescricao = new JTextField(20);

        lbConta = new JLabel("Qual Banco foi:");
        ContaDao contaDao = new ContaDao(em);
        Conta conta = contaDao.buscarPorId(idConta);
        String nomeConta = conta.getNomeConta();
        tfConta = new JTextField(nomeConta, 20);
        tfConta.setEnabled(false);

        lbDescricaoPagamento = new JLabel("Como foi o pagamento:");
        jcbxDescricaoPagamento = new JComboBox(descricaoPagamento);
        lbValor = new JLabel("Valor:");
        tfValor = new JTextField(20);
        lbDataMovimentacao = new JLabel("Data da Movimentação:");
        tfDataMovimentacao = new JTextField(20);
        lbStatus = new JLabel("Status:");
        jcbxStatus = new JComboBox(status);
        lbTipo = new JLabel("Tipo:");
        jcbxTipo = new JComboBox(tipo);

        lbUsuario = new JLabel("ID do usuario");
        UsuarioDao usuarioDao = new UsuarioDao(em);
        Usuario usuario = usuarioDao.buscarPorId(idUsuario);
        String nome = usuario.getNomeUsuario();
        tfUsuario = new JTextField(nome, 20);
        tfUsuario.setEnabled(false);

        btCadastrar = new JButton("Cadastrar");
        btCancelar = new JButton("Cancelar");

        janela.add(lbCategoria);
        janela.add(tfCategoria);
        janela.add(lbDescricao);
        janela.add(tfDescricao);
        janela.add(lbConta);
        janela.add(tfConta);
        janela.add(lbDescricaoPagamento);
        janela.add(jcbxDescricaoPagamento);
        janela.add(lbValor);
        janela.add(tfValor);
        janela.add(lbDataMovimentacao);
        janela.add(tfDataMovimentacao);
        janela.add(lbStatus);
        janela.add(jcbxStatus);
        janela.add(lbTipo);
        janela.add(jcbxTipo);

        janela.add(btCadastrar);
        janela.add(btCancelar);

        btCadastrar.addActionListener(this);
        btCancelar.addActionListener(this);

        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void alterar(int idMovimentacaoParem,int idUsuarioParam,int idCategoriaParam, int idContaParam){
        idConta = idContaParam;
        idUsuario = idUsuarioParam;
        idCategoria = idCategoriaParam;
        idMovimentacao = idMovimentacaoParem;

        janela = new JFrame ("ALTERAR MOVIMENTAÇÃO");
        janela.setSize(400,600);
        janela.setLocationRelativeTo(null);
        janela.getContentPane().setBackground(new Color(200, 230, 201));
        janela.setLayout(new GridLayout(9,2,5,10));
        EntityManager em = JPAUtil.getEntityMananger();
        MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);
        Movimentacao movimentacao = movimentacaoDao.buscarPorId(idMovimentacao);
        lbCategoria = new JLabel("Nome Categoria:");
        CategoriaDao categoriaDao = new CategoriaDao(em);
        Categoria categoria = categoriaDao.buscarPorId(idCategoria);
        String  nomeCategoria = categoria.getNomeCategoria();
        tfCategoria = new JTextField(nomeCategoria, 20);
        tfCategoria.setEnabled(false);

        // mostrar os campos dentro do JTextField
        SimpleDateFormat sfdData = new SimpleDateFormat("dd/MM/yyyy");
        String descricao = movimentacao.getDescricao();
        Date dataMovimentacao = movimentacao.getDataMovimentacao();
        String data = sfdData.format(dataMovimentacao);
        lbDescricao = new JLabel("Descrição:");
        tfDescricao =new JTextField(descricao,20);
        lbConta = new JLabel("Qual Banco foi:");
        ContaDao contaDao = new ContaDao(em);
        Conta conta = contaDao.buscarPorId(idConta);
        String  nomeConta = conta.getNomeConta();
        tfConta = new JTextField(nomeConta, 20);
        tfConta.setEnabled(false);
        lbDescricaoPagamento = new JLabel("Como foi o pagamento:");
        jcbxDescricaoPagamento = new JComboBox(descricaoPagamento);
        lbValor = new JLabel("Valor:");
        double valor = movimentacao.getValor();
        String valorFormatado = String.format("%.2f", valor);
        tfValor = new JTextField(valorFormatado,20);
        lbDataMovimentacao = new JLabel("Data da Movimentação:");
        tfDataMovimentacao = new JTextField(data,20);
        lbStatus = new JLabel("Status:");
        jcbxStatus = new JComboBox(status);
        lbTipo = new JLabel("Tipo:");
        jcbxTipo = new JComboBox(tipo);

        lbUsuario = new JLabel("ID do usuario");
        UsuarioDao usuarioDao = new UsuarioDao(em);
        Usuario usuario = usuarioDao.buscarPorId(idUsuario);
        String nome = usuario.getNomeUsuario();
        tfUsuario = new JTextField(nome, 20);
        tfUsuario.setEnabled(false);

        btAlterar = new JButton("Alterar");
        btCancelar = new JButton("Cancelar");

        janela.add(lbCategoria);
        janela.add(tfCategoria);
        janela.add(lbDescricao);
        janela.add(tfDescricao);
        janela.add(lbConta);
        janela.add(tfConta);
        janela.add(lbDescricaoPagamento);
        janela.add(jcbxDescricaoPagamento);
        janela.add(lbValor);
        janela.add(tfValor);
        janela.add(lbDataMovimentacao);
        janela.add(tfDataMovimentacao);
        janela.add(lbStatus);
        janela.add(jcbxStatus);
        janela.add(lbTipo);
        janela.add(jcbxTipo);

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
            tfCategoria.setText("");
            tfDescricao.setText("");
            tfConta.setText("");
            jcbxDescricaoPagamento.setSelectedIndex(0);
            tfValor.setText("");
            tfDataMovimentacao.setText("");
            jcbxStatus.setSelectedIndex(0);
            jcbxStatus.setSelectedIndex(0);
            tfUsuario.setText("");
            janela.dispose();
        }else if (e.getSource()== btCadastrar) {
            String dataDigitada = tfDataMovimentacao.getText();
            Date dataMovimentacao;
            try{
                dataMovimentacao = new SimpleDateFormat("dd/MM/yyyy").parse(dataDigitada);
            }catch (ParseException ex){
                throw  new RuntimeException(ex);
            }
            String descricao = tfDescricao.getText();
            double valor = Double.parseDouble(tfValor.getText());
            String descricaoPagamento = jcbxDescricaoPagamento.getSelectedItem().toString();
            String status = jcbxStatus.getSelectedItem().toString();
            String tipo = jcbxTipo.getSelectedItem().toString();
            if (jcbxTipo.getSelectedIndex() == 2){
               valor = valor * -1;
            }
            Movimentacao movimentacao = new Movimentacao(descricao,descricaoPagamento,status,tipo,dataMovimentacao,idUsuario,idCategoria,idConta,valor);
            EntityManager em = JPAUtil.getEntityMananger();
            MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);
            em.getTransaction().begin();
            movimentacaoDao.cadastrar(movimentacao);
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null,"Registro cadastrado com sucesso");
            janela.dispose();
        }else if (e.getSource() == btAlterar) {
            //criar conecao com o banco de dados
            EntityManager em = JPAUtil.getEntityMananger();
            MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);
            Movimentacao movimentacao = movimentacaoDao.buscarPorId(idMovimentacao);
            em.getTransaction().begin();
            movimentacaoDao.alterar(movimentacao);
            String dataDigitada = tfDataMovimentacao.getText();
            Date dataMovimentacao;
            try{
                dataMovimentacao = new SimpleDateFormat("dd/MM/yyyy").parse(dataDigitada);
            }catch (ParseException ex){
                throw  new RuntimeException(ex);
            }
            movimentacao.setDataMovimentacao(dataMovimentacao);
            movimentacao.setDescricaoPagamento(jcbxDescricaoPagamento.getSelectedItem().toString());
            movimentacao.setDescricao(tfDescricao.getText());
            movimentacao.setStatus(jcbxStatus.getSelectedItem().toString());
            movimentacao.setTipo(jcbxTipo.getSelectedItem().toString());
            movimentacao.setValor(Double.parseDouble(tfValor.getText()));
            movimentacao.setIdUsuario(idUsuario);
            movimentacao.setIdCategoria(idCategoria);
            movimentacao.setIdConta(idConta);
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null,"Registro alterar com sucesso");
            janela.dispose();
        }
    }
    public String consultar(){
        //criar conecao com o banco de dados
        EntityManager em = JPAUtil.getEntityMananger();
        MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);
        ContaDao contaDao = new ContaDao(em);
        UsuarioDao usuarioDao = new UsuarioDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        java.util.List<Movimentacao> todosRegistros = movimentacaoDao.buscarTodos();
        int qtdeRegistros = todosRegistros.size();
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        String resultado = "ID MOVIMENTAÇÂO - CATEGORIA - PAGAMENTO - BANCO - VALOR - DATA - STATUS - TIPO - NOME USUARIO\n";
        for (int i = 0; i < qtdeRegistros; i++) {
            Usuario usuario = usuarioDao.buscarPorId(todosRegistros.get(i).getIdUsuario());
            Categoria categoria = categoriaDao.buscarPorId(todosRegistros.get(i).getIdCategoria());
            Conta conta = contaDao.buscarPorId(todosRegistros.get(i).getIdConta());
            resultado += todosRegistros.get(i).getIdMovimentacao() + " - " +
                    categoria.getNomeCategoria() + " - " +
                    todosRegistros.get(i).getDescricaoPagamento() +" - " +
                    conta.getNomeConta() +" - ( R$" + String.format("%2f",todosRegistros.get(i).getValor()) + ") - " +
                    sdfData.format(todosRegistros.get(i).getDataMovimentacao()) + " - " +
                    todosRegistros.get(i).getStatus().toString() + " - " + todosRegistros.get(i).getTipo() +
                    " - " + usuario.getNomeUsuario()+ "\n";
        }
        return resultado;
    }
    public String resulmo(){
        //criar conecao com o banco de dados
        EntityManager em = JPAUtil.getEntityMananger();
        MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);
        UsuarioDao usuarioDao = new UsuarioDao(em);
        ContaDao contaDao = new ContaDao(em);
        List<Movimentacao> buscarTodos = movimentacaoDao.buscarTodos();
        int qtdeRegistros = buscarTodos.size();
        String resultado = "ID MOVIMENTAÇÂO  - NOME USUARIO - VALOR- BANCO - TIPO  \n";
        for (int i = 0; i < qtdeRegistros; i++){
            Usuario usuario = usuarioDao.buscarPorId(buscarTodos.get(i).getIdUsuario());
            Conta conta = contaDao.buscarPorId(buscarTodos.get(i).getIdConta());
            resultado += buscarTodos.get(i).getIdMovimentacao() + " - " +
                    usuario.getNomeUsuario() +" - ( R$" +
                    buscarTodos.get(i).getValor() + " - )" +
                    conta.getNomeConta() +" - " + buscarTodos.get(i).getTipo()
                    +"\n";
        }
        return resultado;
    }
    public void excluir (int idMovimentacao){
        //criar conecao com o banco de dados
        EntityManager em = JPAUtil.getEntityMananger();
        MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);
        Movimentacao movimentacao = movimentacaoDao.buscarPorId(idMovimentacao);
        em.getTransaction().begin();
        movimentacaoDao.excluir(movimentacao);
        em.getTransaction().commit();
        em.close();
        JOptionPane.showMessageDialog(null,"Registro excluído com sucesso");
    }
}
