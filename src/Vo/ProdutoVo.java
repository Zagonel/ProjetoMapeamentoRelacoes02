package Vo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")

public class ProdutoVo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(nullable = false)
    private float precoVenda;

    @ManyToOne(fetch = FetchType.EAGER)
    private GrupoProdutoVo grupoProdutoVo;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<FornecedorVo> listaFornecedorVo;

    public List<FornecedorVo> getListaFornecedorVo() {
        return listaFornecedorVo;
    }

    public void setListaFornecedorVo(List<FornecedorVo> listaFornecedorVo) {
        this.listaFornecedorVo = listaFornecedorVo;
    }

    public ProdutoVo(int codigo, String nome, float precoVenda, GrupoProdutoVo grupoProdutoVo) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoVenda = precoVenda;
        this.grupoProdutoVo = grupoProdutoVo;
    }

    public ProdutoVo() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public GrupoProdutoVo getGrupoProdutoVo() {
        return grupoProdutoVo;
    }

    public void setGrupoProdutoVo(GrupoProdutoVo grupoProdutoVo) {
        this.grupoProdutoVo = grupoProdutoVo;
    }
}
