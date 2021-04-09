package Vo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemVendas")
    
public class ItemVendaVo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private int precoVenda;

    @Column(nullable = false)
    private int perDesconto;

    @ManyToOne(fetch = FetchType.EAGER)
    private ProdutoVo produtoVo;

    public ItemVendaVo(int codigo, int quantidade, int precoVenda, int perDesconto, ProdutoVo produtoVo) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
        this.perDesconto = perDesconto;
        this.produtoVo = produtoVo;
    }

    public ItemVendaVo() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(int precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getPerDesconto() {
        return perDesconto;
    }

    public void setPerDesconto(int perDesconto) {
        this.perDesconto = perDesconto;
    }

    public ProdutoVo getProdutoVo() {
        return produtoVo;
    }

    public void setProdutoVo(ProdutoVo produtoVo) {
        this.produtoVo = produtoVo;
    }

}
