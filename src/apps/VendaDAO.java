package apps;

import Vo.ClienteVo;
import Vo.GrupoProdutoVo;
import Vo.ItemVendaVo;
import Vo.VendaVo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VendaDAO {
    
    public static void incluir() {

        //quinto
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        VendaVo venda1 = new VendaVo();
        VendaVo venda2 = new VendaVo();
        VendaVo venda3 = new VendaVo();
        
        List<ItemVendaVo> listaItens = new ArrayList();
        
        List<VendaVo> listaVendas = new ArrayList();
        
        ItemVendaVo aux = new ItemVendaVo();
        
        try {
            
            aux.setProdutoVo(ProdutoDAO.buscaProduto("Coca-Cola"));
            aux.setPrecoVenda(8);
            aux.setQuantidade(30);
            
            aux.setProdutoVo(ProdutoDAO.buscaProduto("Queijo Minas"));
            aux.setPrecoVenda(6);
            aux.setQuantidade(21);
            
            listaItens.add(aux);
            
            Date data = new Date();
            
            venda1.setItemVendaVo(listaItens);
            venda1.setDataVenda(data);
            venda1.getClienteVo().setCPF("02152352684");
            venda1.getVendedorVo().setCPF("021550164541");
            
            aux.setProdutoVo(ProdutoDAO.buscaProduto("Desinfetante Ype"));
            aux.setPrecoVenda(7);
            aux.setQuantidade(20);
            
            aux.setProdutoVo(ProdutoDAO.buscaProduto("Queijo Minas"));
            aux.setPrecoVenda(6);
            aux.setQuantidade(100);
            
            listaItens.add(aux);
            
            venda2.setItemVendaVo(listaItens);
            venda2.setDataVenda(data);
            venda2.getClienteVo().setCPF("56142365842");
            venda2.getVendedorVo().setCPF("52331850325");
            
            aux.setProdutoVo(ProdutoDAO.buscaProduto("Desinfetante Ype"));
            aux.setPrecoVenda(7);
            aux.setQuantidade(100);
            
            aux.setProdutoVo(ProdutoDAO.buscaProduto("Coca-Cola"));
            aux.setPrecoVenda(6);
            aux.setQuantidade(3);
            
            listaItens.add(aux);
            
            venda3.setItemVendaVo(listaItens);
            venda3.setDataVenda(data);
            venda3.getClienteVo().setCPF("03565874852");
            venda3.getVendedorVo().setCPF("4558163256");
            
            listaVendas.add(venda1);
            listaVendas.add(venda2);
            listaVendas.add(venda3);
            
            emf = Persistence.createEntityManagerFactory("vendas2");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            
            em.persist(venda1);
            em.persist(venda2);
            em.persist(venda3);
            
            em.getTransaction().commit();
            
            relacaoClienteXvenda(listaVendas);
            relacaoVendaXvendedores(listaVendas);
            
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
    
    public static void relacaoClienteXvenda(List<VendaVo> listaVendas) {
        
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        emf = Persistence.createEntityManagerFactory("vendas2");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<ClienteVo> listaDeCliente = ClienteDAO.buscarListaClientes();
        
        List<VendaVo> listaAux = new ArrayList();
        
        ClienteVo aux = new ClienteVo();
        VendaVo aux2 = new VendaVo();
        
        for (int k = 0; k < listaDeCliente.size(); k++) {
            
            for (int i = 0; i < listaVendas.size(); i++) {
                
                if (listaDeCliente.get(k).getCPF().equals(listaVendas.get(i).getClienteVo().getCPF())) {
                    
                    listaAux.add(listaVendas.get(i));
                    
                    aux2.setClienteVo(listaDeCliente.get(k));
                    em.persist(aux2);
                }
            }
            aux.setListaVendasVo(listaAux);
            em.persist(aux);
        }
    }
    
    public static void relacaoVendaXvendedores(List<VendaVo> listaVendas) {
        
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        emf = Persistence.createEntityManagerFactory("vendas2");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<ClienteVo> listaDeCliente = ClienteDAO.buscarListaClientes();
        List<VendaVo> listaAux = new ArrayList();
        ClienteVo aux = new ClienteVo();
        
        for (int i = 0; i < listaVendas.size(); i++) {
            
            for (int k = 0; k < listaDeCliente.size(); k++) {
                
                if (listaDeCliente.get(k).getCPF().equals(listaVendas.get(i).getClienteVo().getCPF())) {
                    
                    listaAux.add(listaVendas.get(i));
                }
            }
            aux.setListaVendasVo(listaVendas);
            em.persist(aux);
        }
        
    }
    
}
