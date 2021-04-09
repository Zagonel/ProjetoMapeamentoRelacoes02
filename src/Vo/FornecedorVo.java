package Vo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

public class FornecedorVo extends PessoaJuridicaVo implements Serializable {

    @ManyToMany(fetch = FetchType.EAGER)
    private List<ProdutoVo> listaProdutoVo;

    public List<ProdutoVo> getListaProdutoVo() {
        return listaProdutoVo;
    }

    public void setListaProdutoVo(List<ProdutoVo> listaProdutoVo) {
        this.listaProdutoVo = listaProdutoVo;
    }

    public FornecedorVo(List<ProdutoVo> listaProdutoVo, String razaoSocial, int codigo, String nome) {
        super(razaoSocial, codigo, nome);
        this.listaProdutoVo = listaProdutoVo;
    }

    public FornecedorVo() {
    }

}
