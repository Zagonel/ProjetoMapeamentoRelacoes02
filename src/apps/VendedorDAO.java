package apps;

import Vo.ClienteVo;
import Vo.VendedorVo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VendedorDAO {

    public static void incluir() {
        
        //quarto

        EntityManagerFactory emf = null;
        EntityManager em = null;

        VendedorVo novoVendedor1 = new VendedorVo();
        VendedorVo novoVendedor2 = new VendedorVo();
        VendedorVo novoVendedor3 = new VendedorVo();

        try {

            novoVendedor1.setNome("Osvaldo");
            novoVendedor1.setCPF("021550164541");
            novoVendedor1.setRG("02215652");
            novoVendedor1.setPerComissao(0.3f);
            
            novoVendedor2.setNome("Pedro");
            novoVendedor2.setCPF("52331850325");
            novoVendedor2.setRG("50168105");
            novoVendedor2.setPerComissao(0.2f);
            
            novoVendedor3.setNome("Carlinhos");
            novoVendedor3.setCPF("45581632565");
            novoVendedor3.setRG("46567258");
            novoVendedor3.setPerComissao(0.4f);
            

            emf = Persistence.createEntityManagerFactory("vendas2");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(novoVendedor1);
            em.persist(novoVendedor2);
            em.persist(novoVendedor3);

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

}
