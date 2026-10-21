package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private  static  final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("gerenciadofinaceiropessoal");
    public  static EntityManager getEntityMananger(){
        //ele cria gerenciamento da entidade
        return  FACTORY.createEntityManager();
    }
}
