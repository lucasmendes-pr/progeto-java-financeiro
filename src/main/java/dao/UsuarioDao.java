package dao;
import model.Usuario;
import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDao {
    //gerenciador da entidade
    private static EntityManager em;
    //construtor
    public UsuarioDao(EntityManager em){
        this.em = em;
    }
    public void cadastrar (Usuario usuario){
        this.em.persist(usuario);//cria regiostro de usuario
    }
    //Busca todos
    public List<Usuario> buscarTodos(){
        String jpql ="SElECT u FROM Usuario u";
        return em.createQuery(jpql,Usuario.class).getResultList();//bustar registro de usuario
    }
    public Usuario buscarPorId(int id){
        return em.find(Usuario.class,id);//buscar apenas um registro
    }

    public void excluir (Usuario usuario){
        em.merge(usuario);//carregar registro
        em.remove(usuario);//excluir registro
    }
    public void alterar(Usuario usuario){
        em.merge(usuario);

    }
}
