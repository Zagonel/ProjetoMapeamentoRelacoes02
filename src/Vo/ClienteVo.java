package Vo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "clientes")
public class ClienteVo extends PessoaFisicaVo implements Serializable {

    @Column(nullable = false)
    private float limiteCredito;

    @OneToMany(fetch = FetchType.EAGER)
    private List<VendaVo> listaVendasVo;

    public ClienteVo(float limiteCredito, String RG, String CPF, int codigo, String nome) {
        super(RG, CPF, codigo, nome);
        this.limiteCredito = limiteCredito;
    }

    public ClienteVo() {

    }

    public List<VendaVo> getListaVendasVo() {
        return listaVendasVo;
    }

    public void setListaVendasVo(List<VendaVo> listaVendasVo) {
        this.listaVendasVo = listaVendasVo;
    }

    public float getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

}
