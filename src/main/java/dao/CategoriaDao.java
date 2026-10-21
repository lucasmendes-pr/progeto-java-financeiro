package dao;

import model.Categoria;
import model.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {
    //gerenciador da entidade
    private static EntityManager em;
    //construtor
    public CategoriaDao(EntityManager em){
        this.em = em;
    }
    public void cadastrar (Categoria categoria){
        this.em.persist(categoria);//cria regiostro de categoria
    }
    //Busca todos
    public List<Categoria> buscarTodos(){
        String jpql ="SElECT c FROM Categoria c";
        return em.createQuery(jpql,Categoria.class).getResultList();//bustar registro de categoria
    }

    public Categoria buscarPorId(int id){
        return em.find(Categoria.class,id);//buscar apenas um registro
    }

    public void excluir (Categoria categoria){
        em.merge(categoria);//carregar registro
        em.remove(categoria);//excluir registro
    }
    public void alterar(Categoria categoria){
        em.merge(categoria);
    }
}
