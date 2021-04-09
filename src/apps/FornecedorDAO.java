package apps;

import Vo.FornecedorVo;
import Vo.GrupoProdutoVo;
import Vo.ProdutoVo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FornecedorDAO {

    public static void incluir() {

        //Segundo
        
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            FornecedorVo novoFornecedor1 = new FornecedorVo();
            FornecedorVo novoFornecedor2 = new FornecedorVo();
            FornecedorVo novoFornecedor3 = new FornecedorVo();

            List<ProdutoVo> listaProdutoVo = new ArrayList();
            List<FornecedorVo> listaFornecedor = new ArrayList();

            ProdutoVo produto = new ProdutoVo();

            produto.setNome("Coca-Cola");
            produto.setPrecoVenda(8);
            produto.setGrupoProdutoVo(GrupoProdutoDAO.buscar("Bebidas"));

            listaProdutoVo.add(produto);

            produto.setNome("Fanta Laranja");
            produto.setPrecoVenda(5);
            produto.setGrupoProdutoVo(GrupoProdutoDAO.buscar("Bebidas"));

            listaProdutoVo.add(produto);

            produto.setNome("Fanta Uva");
            produto.setPrecoVenda(6);
            produto.setGrupoProdutoVo(GrupoProdutoDAO.buscar("Bebidas"));

            listaProdutoVo.add(produto);

            novoFornecedor1.setNome("walmer da silva");
            novoFornecedor1.setNomeFantasia("Coca-Cola ltda");
            novoFornecedor1.setListaProdutoVo(listaProdutoVo);

            produto.setNome("Queijo Minas");
            produto.setPrecoVenda(10);
            produto.setGrupoProdutoVo(GrupoProdutoDAO.buscar("Bebidas"));

            listaProdutoVo.add(produto);

            produto.setNome("Reiqueijão");
            produto.setPrecoVenda(5);
            produto.setGrupoProdutoVo(GrupoProdutoDAO.buscar("Bebidas"));

            listaProdutoVo.add(produto);

            produto.setNome("Pão de queijo");
            produto.setPrecoVenda(7);
            produto.setGrupoProdutoVo(GrupoProdutoDAO.buscar("Bebidas"));

            listaProdutoVo.add(produto);

            novoFornecedor2.setNome("Lucas Ferreira");
            novoFornecedor2.setNomeFantasia("Camponesa ltda");
            novoFornecedor2.setListaProdutoVo(listaProdutoVo);

            produto.setNome("Detergente");
            produto.setPrecoVenda(2);
            produto.setGrupoProdutoVo(GrupoProdutoDAO.buscar("Bebidas"));

            listaProdutoVo.add(produto);

            produto.setNome("Desinfetante Ype");
            produto.setPrecoVenda(4);
            produto.setGrupoProdutoVo(GrupoProdutoDAO.buscar("Bebidas"));

            listaProdutoVo.add(produto);

            produto.setNome("Agua sanitaria");
            produto.setPrecoVenda(6);
            produto.setGrupoProdutoVo(GrupoProdutoDAO.buscar("Bebidas"));

            listaProdutoVo.add(produto);

            novoFornecedor3.setNome("Marmota da silva");
            novoFornecedor3.setNomeFantasia("Ype ltda");
            novoFornecedor3.setListaProdutoVo(listaProdutoVo);

            listaFornecedor.add(novoFornecedor1);
            listaFornecedor.add(novoFornecedor2);
            listaFornecedor.add(novoFornecedor3);

            emf = Persistence.createEntityManagerFactory("vendas2");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(novoFornecedor1);
            em.persist(novoFornecedor2);
            em.persist(novoFornecedor3);

            em.getTransaction().commit();

            relacaoFornecedorXProduto(listaFornecedor);

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

    public static void relacaoFornecedorXProduto(List<FornecedorVo> listaFornecedor) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        emf = Persistence.createEntityManagerFactory("vendas2");
        em = emf.createEntityManager();
        em.getTransaction().begin();

        List<ProdutoVo> listaDeProdutos = ProdutoDAO.buscarListaProdutos();
        List<FornecedorVo> listaAux = new ArrayList();
        ProdutoVo aux = new ProdutoVo();

        for (int i = 0; i < listaDeProdutos.size(); i++) {

            for (int k = 0; k < listaFornecedor.size(); k++) {

                for (int p = 0; p < listaFornecedor.get(k).getListaProdutoVo().size(); p++) {

                    if (listaDeProdutos.get(i).getNome().equals(listaFornecedor.get(k).getListaProdutoVo().get(p).getNome())) {

                        listaAux.add(listaFornecedor.get(k));
                    }
                }
            }
            aux = listaDeProdutos.get(i);
            aux.setListaFornecedorVo(listaAux);            
            em.persist(aux);
        }
    }
}
