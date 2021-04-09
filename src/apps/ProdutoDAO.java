package apps;

import Vo.ProdutoVo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProdutoDAO {

    public void incluir() {

        // Esse vai no Main pra ser chamado 
        //primeiro
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            GrupoProdutoDAO.incluir();

            ProdutoVo novoProduto1 = new ProdutoVo();
            ProdutoVo novoProduto2 = new ProdutoVo();
            ProdutoVo novoProduto3 = new ProdutoVo();

            novoProduto1.setNome("Coca-Cola");
            novoProduto1.setPrecoVenda(7);
            novoProduto1.setGrupoProdutoVo(GrupoProdutoDAO.buscar("Bebidas"));

            novoProduto2.setNome("Queijo Minas");
            novoProduto2.setPrecoVenda(2);
            novoProduto2.setGrupoProdutoVo(GrupoProdutoDAO.buscar("Frios"));

            novoProduto3.setNome("Desinfetante Ype");
            novoProduto3.setPrecoVenda(5);
            novoProduto1.setGrupoProdutoVo(GrupoProdutoDAO.buscar("Material De limpeza"));

            emf = Persistence.createEntityManagerFactory("vendas2");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(novoProduto1);
            em.persist(novoProduto2);
            em.persist(novoProduto3);

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

    public static List<ProdutoVo> buscarListaProdutos() {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        List<ProdutoVo> listaProdutos = new ArrayList();
        try {

            emf = Persistence.createEntityManagerFactory("vendas2");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT resultado FROM ProdutoVo resultado");
            listaProdutos = query.getResultList();

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
        return listaProdutos;
    }

    public static ProdutoVo buscaProduto(String nome) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        ProdutoVo Produto = new ProdutoVo();
        try {

            emf = Persistence.createEntityManagerFactory("vendas2");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT resultado FROM ProdutoVo resultado WHERE resultado.nome =:nome");
            query.setParameter("nome", nome);

            Produto = (ProdutoVo) query.getSingleResult();

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
        return Produto;
    }
}
