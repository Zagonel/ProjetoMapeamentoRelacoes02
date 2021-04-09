package apps;

import Vo.ClienteVo;
import Vo.ItemVendaVo;
import Vo.PessoaVo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClienteDAO {
    
    

    public static void incluir() {

        //terceiro
        
        EntityManagerFactory emf = null;
        EntityManager em = null;

        ClienteVo novoCliente1 = new ClienteVo();
        ClienteVo novoCliente2 = new ClienteVo();
        ClienteVo novoCliente3 = new ClienteVo();

        try {

            novoCliente1.setNome("Igor zagonel");
            novoCliente1.setRG("256815");
            novoCliente1.setCPF("02152352684");
            novoCliente1.setLimiteCredito(3000);

            novoCliente2.setNome("Vivian Marinho");
            novoCliente2.setRG("658234");
            novoCliente2.setCPF("56142365842");
            novoCliente2.setLimiteCredito(5000);

            novoCliente3.setNome("Mailon Campos");
            novoCliente3.setRG("625477");
            novoCliente3.setCPF("03565874852");
            novoCliente3.setLimiteCredito(4000);

            emf = Persistence.createEntityManagerFactory("vendas2");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(novoCliente1);
            em.persist(novoCliente2);
            em.persist(novoCliente3);

            em.getTransaction().commit();
            System.out.println("Inclusão realizada com sucesso");

        } catch (Exception ex) {
            System.out.println("Inclusão não realizada " + ex.getMessage());
        } finally {

            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }

    public static List<ClienteVo> buscarListaClientes() {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        List<ClienteVo> listaClientes = new ArrayList();
        try {

            emf = Persistence.createEntityManagerFactory("vendas2");
            em = emf.createEntityManager();
            em.getTransaction().begin();                       

            Query query = em.createQuery("SELECT resultado FROM ClienteVo resultado");
            listaClientes = query.getResultList();

        } catch (Exception ex) {
            System.out.println("Inclusão não realizada " + ex.getMessage());
        } finally {

            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return listaClientes;
    }

}
