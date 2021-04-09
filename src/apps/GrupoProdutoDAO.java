package apps;

import Vo.GrupoProdutoVo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GrupoProdutoDAO {

    public static void incluir() {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        GrupoProdutoVo novoGrupoProduto1 = new GrupoProdutoVo();
        GrupoProdutoVo novoGrupoProduto2 = new GrupoProdutoVo();
        GrupoProdutoVo novoGrupoProduto3 = new GrupoProdutoVo();

        try {

            novoGrupoProduto1.setNome("Frios");
            novoGrupoProduto2.setNome("Bebidas");
            novoGrupoProduto3.setNome("Material De limpeza");

            emf = Persistence.createEntityManagerFactory("vendas2");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(novoGrupoProduto1);
            em.persist(novoGrupoProduto2);
            em.persist(novoGrupoProduto3);

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

    public static GrupoProdutoVo buscar(String nome) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        GrupoProdutoVo resultado = new GrupoProdutoVo();
        try {

            emf = Persistence.createEntityManagerFactory("vendas2");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT resultado FROM GrupoProdutoVo resultado WHERE resultado.nome =:nome");
            query.setParameter("nome", nome);

            resultado = (GrupoProdutoVo) query.getSingleResult();

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
        return resultado;
    }

}
