package Vo;

import Vo.ClienteVo;
import Vo.ItemVendaVo;
import Vo.VendedorVo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T20:02:27")
@StaticMetamodel(VendaVo.class)
public class VendaVo_ { 

    public static volatile SingularAttribute<VendaVo, Integer> codigo;
    public static volatile SingularAttribute<VendaVo, ClienteVo> clienteVo;
    public static volatile SingularAttribute<VendaVo, Date> dataVenda;
    public static volatile SingularAttribute<VendaVo, VendedorVo> vendedorVo;
    public static volatile ListAttribute<VendaVo, ItemVendaVo> listaItemVo;

}