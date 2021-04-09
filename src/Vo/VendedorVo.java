package Vo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendedores")
public class VendedorVo extends PessoaFisicaVo implements Serializable {

    @Column(nullable = false)
    private Float perComissao;

    @OneToMany(fetch = FetchType.EAGER)
    private List<VendaVo> listaVendaVo;

    public VendedorVo(Float perComissao, String RG, String CPF, int codigo, String nome) {
        super(RG, CPF, codigo, nome);
        this.perComissao = perComissao;
    }

    public VendedorVo() {
    }

    public List<VendaVo> getListaVendaVo() {
        return listaVendaVo;
    }

    public void setListaVendaVo(List<VendaVo> listaVendaVo) {
        this.listaVendaVo = listaVendaVo;
    }

    public Float getPerComissao() {
        return perComissao;
    }

    public void setPerComissao(Float perComissao) {
        this.perComissao = perComissao;
    }

}
