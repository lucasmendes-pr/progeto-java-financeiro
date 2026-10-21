package dao;
import model.Movimentacao;
import javax.persistence.EntityManager;
import java.util.List;

public class MovimentacaoDao {
    //gerenciador da entidade
    private static EntityManager em;
    //construtor
    public MovimentacaoDao (EntityManager em){
        this.em = em;
    }
    public void cadastrar (Movimentacao movimentacao){
        this.em.persist(movimentacao);//cria regiostro de categoria
    }
    //Busca todos
    public List<Movimentacao> buscarTodos(){
        String jpql ="SElECT M FROM Movimentacao M";
        return em.createQuery(jpql,Movimentacao.class).getResultList();//bustar registro de movimentacao
    }

    public Movimentacao buscarPorId(int id){
        return em.find(Movimentacao.class,id);//buscar apenas um registro
    }

    public void excluir (Movimentacao movimentacao){
        em.merge(movimentacao);//carregar registro
        em.remove(movimentacao);//excluir registro
    }
    public void alterar(Movimentacao movimentacao){
        em.merge(movimentacao);
    }
}
