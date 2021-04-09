package Vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "vendas")

public class VendaVo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVenda;

    @OneToMany(fetch = FetchType.EAGER)
    private List<ItemVendaVo> listaItemVo;

    @ManyToOne(fetch = FetchType.EAGER)
    private VendedorVo vendedorVo;

    @ManyToOne(fetch = FetchType.EAGER)
    private ClienteVo clienteVo;

    public VendaVo(int codigo, Date dataVenda, List<ItemVendaVo> listaItemVo) {
        this.codigo = codigo;
        this.dataVenda = dataVenda;
        this.listaItemVo = listaItemVo;
    }

    public VendaVo() {
    }

    public ClienteVo getClienteVo() {
        return clienteVo;
    }

    public void setClienteVo(ClienteVo clienteVo) {
        this.clienteVo = clienteVo;
    }

    public VendedorVo getVendedorVo() {
        return vendedorVo;
    }

    public void setVendedorVo(VendedorVo vendedorVo) {
        this.vendedorVo = vendedorVo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public List<ItemVendaVo> getListaItemVo() {
        return listaItemVo;
    }

    public void setItemVendaVo(List<ItemVendaVo> listaItemVo) {
        this.listaItemVo = listaItemVo;
    }

}
