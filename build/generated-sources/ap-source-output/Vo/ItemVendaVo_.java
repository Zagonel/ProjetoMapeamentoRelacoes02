package Vo;

import Vo.ProdutoVo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T20:02:27")
@StaticMetamodel(ItemVendaVo.class)
public class ItemVendaVo_ { 

    public static volatile SingularAttribute<ItemVendaVo, Integer> codigo;
    public static volatile SingularAttribute<ItemVendaVo, Integer> precoVenda;
    public static volatile SingularAttribute<ItemVendaVo, Integer> perDesconto;
    public static volatile SingularAttribute<ItemVendaVo, ProdutoVo> produtoVo;
    public static volatile SingularAttribute<ItemVendaVo, Integer> quantidade;

}