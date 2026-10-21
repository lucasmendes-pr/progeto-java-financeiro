package dao;

import model.Categoria;
import model.Conta;

import javax.persistence.EntityManager;
import java.util.List;

public class ContaDao {
    //gerenciador da entidade
    private static EntityManager em;
    //construtor
    public ContaDao(EntityManager em){
        this.em = em;
    }
    public void cadastrar (Conta conta){
        this.em.persist(conta);//cria regiostro de Conta
    }
    //Busca todos
    public List<Conta> buscarTodos(){
        String jpql ="SElECT c FROM Conta c";
        return em.createQuery(jpql,Conta.class).getResultList();//bustar registro de Conta
    }

    public Conta buscarPorId(int id){
        return em.find(Conta.class,id);//buscar apenas um registro
    }

    public void excluir (Conta conta){
        em.merge(conta);//carregar registro
        em.remove(conta);//excluir registro
    }
    public void alterar(Conta conta){
        em.merge(conta);
    }
}
