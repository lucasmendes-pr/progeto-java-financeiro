package view;
import dao.UsuarioDao;
import model.Usuario;
import util.JPAUtil;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JanelaUsuario implements ActionListener {
    JFrame janela;
    JLabel lbNomeUsuario,lbCpf,lbEndereco,lbCidade,lbEstado,lbDataNascimento,lbRg,
            lbSexo,lbCep,lbEmail,lbCategoria,lbSenha,lbDataCriacao;
    JTextField tfNomeUsuario,tfCpf,tfEndereco,tfCidade,tfDataNascimento,tfRg,
            tfCep,tfEmail,tfDataCriacao;
    JPasswordField pfSenha;

    String [] genero = {"Selecione uma Opção","Masculino","Feminino","Outros "};
    JComboBox cbxGenero;

    String [] estados = {"Selecione uma Opção","Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal",
            "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba",
            "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro",
            "Rio Grande do Norte","Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina","São Paulo", "Sergipe" ,"Tocantins"};
    JComboBox cbxEstados;

    String [] categoria = {"Selecione uma Opção","Administrador","Usuário"};
    JComboBox cbxCategoria;

    JButton btCadastrar,btCancelar, btAlterar;
    int idUsusario;

    public void cadastrar(){
        janela = new JFrame ("CADASTRO USUÁRIO");
        janela.setSize(350,600);
        janela.setLocationRelativeTo(null);
        janela.getContentPane().setBackground(new Color(200, 230, 201));
       // janela.setLayout(new GridLayout(13,1,5,10));
        janela.setLayout(new GridLayout(14,2,5,10));

        //instanciar todos os campos
        lbNomeUsuario = new JLabel(" Nome Completo:");
        tfNomeUsuario = new JTextField(20);
        lbCpf = new JLabel(" CPF:");
        tfCpf = new JTextField(20);
        lbRg = new JLabel(" RG:");
        tfRg = new JTextField(20);
        lbCidade = new JLabel(" Cidade:");
        tfCidade = new JTextField(20);
        lbEstado =new JLabel(" Estados:");
        cbxEstados = new JComboBox(estados);
        lbEndereco = new JLabel(" Endereço:");
        tfEndereco = new JTextField(20);
        lbCep = new JLabel(" CEP:");
        tfCep = new JTextField(20);
        lbSexo = new JLabel(" Sexo:");
        cbxGenero = new JComboBox(genero);
        lbDataNascimento = new JLabel(" Data de Nasciomento:");
        tfDataNascimento = new JTextField(20);
        lbCategoria = new JLabel(" Categoria:");
        cbxCategoria = new JComboBox(categoria);
        lbDataCriacao = new JLabel(" Data Criacao:");
        tfDataCriacao = new JTextField(20);
        lbEmail = new JLabel(" Email:");
        tfEmail =new JTextField(20);
        lbSenha = new JLabel(" Senha:");
        pfSenha = new JPasswordField(20);
        btCadastrar = new JButton("Cadastrar");
        btCancelar = new JButton("Cancelar");

        //adiconar os componentes a janela
        janela.add(lbNomeUsuario);
        janela.add(tfNomeUsuario);
        janela.add(lbCpf);
        janela.add(tfCpf);
        janela.add(lbRg);
        janela.add(tfRg);
        janela.add(lbCidade);
        janela.add(tfCidade);
        janela.add(lbCidade);
        janela.add(tfCidade);
        janela.add(lbEstado);
        janela.add(cbxEstados);
        janela.add(lbEndereco);
        janela.add(tfEndereco);
        janela.add(lbCep);
        janela.add(tfCep);
        janela.add(lbSexo);
        janela.add(cbxGenero);
        janela.add(lbDataNascimento);
        janela.add(tfDataNascimento);
        janela.add(lbCategoria);
        janela.add(cbxCategoria);
        janela.add(lbDataCriacao);
        janela.add(tfDataCriacao);
        janela.add(lbEmail);
        janela.add(tfEmail);
        janela.add(lbSenha);
        janela.add(pfSenha);
        janela.add(btCadastrar);
        janela.add(btCancelar);

        //ação aos botoes
        btCadastrar.addActionListener(this);
        btCancelar.addActionListener(this);

        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void alterar(int id){
        janela = new JFrame ("ALTERAR USUÁRIO");
        janela.setSize(350,600);
        janela.setLocationRelativeTo(null);
        janela.getContentPane().setBackground(new Color(200, 230, 201));
        // janela.setLayout(new GridLayout(13,1,5,10));
        janela.setLayout(new GridLayout(14,2,5,10));

        //conexao com o banco de dados
        EntityManager em = JPAUtil.getEntityMananger();
        UsuarioDao usuarioDao = new UsuarioDao(em);
        Usuario usuario = usuarioDao.buscarPorId(id);
        //carregar os conteudos dos campos das vareaves
        idUsusario = usuario.getIdUsuario();
        String nome = usuario.getNomeUsuario();
        String cpf = usuario.getCpf();
        String rg = usuario.getRg();
        String cidade = usuario.getCidade();
        String endereco = usuario.getEndereco();
        String cep = usuario.getCep();
        SimpleDateFormat sfdData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimento = usuario.getDataNascimento();
        Date  dataCriacao = usuario.getDatacriacao();
        String dataDigitada = sfdData.format(dataNascimento);
        String dataCriacaoDigitada = sfdData.format(dataCriacao);
        String emailAntigo = usuario.getEmail();

        //instanciar todos os campos
        lbNomeUsuario = new JLabel(" Nome Completo:");
        tfNomeUsuario = new JTextField(nome,20);
        lbCpf = new JLabel(" CPF:");
        tfCpf = new JTextField(cpf,20);
        lbRg = new JLabel(" RG:");
        tfRg = new JTextField(rg,20);
        lbCidade = new JLabel(" Cidade:");
        tfCidade = new JTextField(cidade,20);
        lbEstado =new JLabel(" Estados:");
        cbxEstados = new JComboBox(estados);
        lbEndereco = new JLabel(" Endereço:");
        tfEndereco = new JTextField(endereco,20);
        lbCep = new JLabel(" CEP:");
        tfCep = new JTextField(cep,20);
        lbSexo = new JLabel(" Sexo:");
        cbxGenero = new JComboBox(genero);
        lbDataNascimento = new JLabel(" Data de Nasciomento:");
        tfDataNascimento = new JTextField(dataDigitada,20);
        lbCategoria = new JLabel(" Categoria:");
        cbxCategoria = new JComboBox(categoria);
        lbDataCriacao = new JLabel(" Data Criacao:");
        tfDataCriacao = new JTextField(dataCriacaoDigitada,20);
        lbEmail = new JLabel(" Email:");
        tfEmail =new JTextField(emailAntigo,20);
        lbSenha = new JLabel(" Senha:");
        pfSenha = new JPasswordField(20);
        btAlterar = new JButton("Alterar");
        btCancelar = new JButton("Cancelar");

        //adiconar os componentes a janela
        janela.add(lbNomeUsuario);
        janela.add(tfNomeUsuario);
        janela.add(lbCpf);
        janela.add(tfCpf);
        janela.add(lbRg);
        janela.add(tfRg);
        janela.add(lbCidade);
        janela.add(tfCidade);
        janela.add(lbCidade);
        janela.add(tfCidade);
        janela.add(lbEstado);
        janela.add(cbxEstados);
        janela.add(lbEndereco);
        janela.add(tfEndereco);
        janela.add(lbCep);
        janela.add(tfCep);
        janela.add(lbSexo);
        janela.add(cbxGenero);
        janela.add(lbDataNascimento);
        janela.add(tfDataNascimento);
        janela.add(lbCategoria);
        janela.add(cbxCategoria);
        janela.add(lbDataCriacao);
        janela.add(tfDataCriacao);
        janela.add(lbEmail);
        janela.add(tfEmail);
        janela.add(lbSenha);
        janela.add(pfSenha);
        janela.add(btAlterar);
        janela.add(btCancelar);

        //ação aos botoes
        btAlterar.addActionListener(this);
        btCancelar.addActionListener(this);

        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btCancelar){
            tfEmail.setText("");
            tfCpf.setText("");
            tfEndereco.setText("");
            tfCep.setText("");
            tfRg.setText("");
            tfDataCriacao.setText("");
            tfNomeUsuario.setText("");
            tfCidade.setText("");
            cbxCategoria.setSelectedIndex(0);
            cbxEstados.setSelectedIndex(0);
            cbxGenero.setSelectedIndex(0);
            tfDataNascimento.setText("");
            pfSenha.setText("");
            janela.dispose();
        }else if (e.getSource()== btCadastrar){
            String dataDigitada = tfDataNascimento.getText();
            Date dataNascimento;
            try{
                dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataDigitada);
            }catch (ParseException ex){
                throw  new RuntimeException(ex);
            }
            dataDigitada = tfDataCriacao.getText();
            Date datacriacao;
            try{
                datacriacao = new SimpleDateFormat("dd/MM/yyyy").parse(dataDigitada);
            }catch (ParseException ex){
                throw  new RuntimeException(ex);
            }
            String nomeUsuario = tfNomeUsuario.getText();
            String cpf = tfCpf.getText();
            String endereco = tfEndereco.getText();
            String cidade = tfCidade.getText();
            String estado = cbxEstados.getSelectedItem().toString();
            String rg = tfRg.getText();
            String cep = tfCep.getText();
            String sexo = cbxGenero.getSelectedItem().toString();
            String categoria = cbxCategoria.getSelectedItem().toString();
            String email = tfEmail.getText();
            String senha = pfSenha.getText();
            //instanciar a classe
            Usuario usuario  = new Usuario(nomeUsuario,cpf,endereco,cidade,estado,rg,sexo,cep,email,categoria,senha,dataNascimento,datacriacao);

            //criar conecao com o banco de dados
            EntityManager em = JPAUtil.getEntityMananger();
            UsuarioDao usuarioDao = new UsuarioDao(em);
            em.getTransaction().begin();
            usuarioDao.cadastrar(usuario);
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null,"Registro cadastrado com sucesso");
            janela.dispose();

        }else if (e.getSource() == btAlterar){
            //criar conecao com o banco de dados
            EntityManager em = JPAUtil.getEntityMananger();
            UsuarioDao usuarioDao = new UsuarioDao(em);
            Usuario usuario =  usuarioDao.buscarPorId(idUsusario);
            em.getTransaction().begin();
            usuarioDao.alterar(usuario);

            String dataDigitada = tfDataNascimento.getText();
            Date dataNascimento;
            try{
                dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataDigitada);
            }catch (ParseException ex){
                throw  new RuntimeException(ex);
            }
            dataDigitada = tfDataCriacao.getText();
            Date datacriacao;
            try{
                datacriacao = new SimpleDateFormat("dd/MM/yyyy").parse(dataDigitada);
            }catch (ParseException ex){
                throw  new RuntimeException(ex);
            }
            usuario.setDatacriacao(datacriacao);
            usuario.setDataNascimento(dataNascimento);
            usuario.setNomeUsuario(tfNomeUsuario.getText());
            usuario.setCpf(tfCpf.getText());
            usuario.setRg(tfRg.getText());
            usuario.setCidade(tfCidade.getText());
            usuario.setEstado(cbxEstados.getSelectedItem().toString());
            usuario.setCep(tfCep.getText());
            usuario.setSexo(cbxGenero.getSelectedItem().toString());
            usuario.setCategoria(cbxCategoria.getSelectedItem().toString());
            usuario.setEmail(tfEmail.getText());
            usuario.setSenha(pfSenha.getText());
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null,"Registro alterado com sucesso");
            janela.dispose();

        }
    }
    public String consultar(){
        //criar conecao com o banco de dados
        EntityManager em = JPAUtil.getEntityMananger();
        UsuarioDao usuarioDao = new UsuarioDao(em);
        List<Usuario> buscarTodos = usuarioDao.buscarTodos();
        int qtdeRegistros = buscarTodos.size();
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        String resultado = "ID - NOME - CPF - RG - CIDADE - ESTADO - ENDEREÇO - CEP - SEXO - DATA NASCIMENTO - CATEGORIA - DATA CRIAÇÃO - E-MAIL \n";
        for (int i = 0; i < qtdeRegistros; i++){
            resultado += buscarTodos.get(i).getIdUsuario() + " - " +
                    buscarTodos.get(i).getNomeUsuario() + " - " +
                    buscarTodos.get(i).getCpf() + " - " +
                    buscarTodos.get(i).getRg() + " - " +
                    buscarTodos.get(i).getCidade() + " - " +
                    buscarTodos.get(i).getEstado() + " - " +
                    buscarTodos.get(i).getEndereco() + " - " +
                    buscarTodos.get(i).getCep() + " - " +
                    buscarTodos.get(i).getSexo() + " - " +
                    sdfData.format(buscarTodos.get(i).getDataNascimento()) + " - " +
                    buscarTodos.get(i).getCategoria() + " - " +
                    sdfData.format(buscarTodos.get(i).getDatacriacao()) + " - " +
                    buscarTodos.get(i).getEmail() + "\n";
        }
        return resultado;
    }
    public String resulmo(){
        //criar conecao com o banco de dados
        EntityManager em = JPAUtil.getEntityMananger();
        UsuarioDao usuarioDao = new UsuarioDao(em);
        List<Usuario> buscarTodos = usuarioDao.buscarTodos();
        int qtdeRegistros = buscarTodos.size();
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        String resultado = "ID - NOME  \n";
        for (int i = 0; i < qtdeRegistros; i++){
            resultado += buscarTodos.get(i).getIdUsuario() + " - " +
                    buscarTodos.get(i).getNomeUsuario() + "\n";
        }
        return resultado;
    }
    public void excluir (int id){
        //criar conecao com o banco de dados
        EntityManager em = JPAUtil.getEntityMananger();
        UsuarioDao usuarioDao = new UsuarioDao(em);
        Usuario usuario = usuarioDao.buscarPorId(id);
        em.getTransaction().begin();
        usuarioDao.excluir(usuario);
        em.getTransaction().commit();
        em.close();
        JOptionPane.showMessageDialog(null,"Registro excluído com sucesso");
    }
}
