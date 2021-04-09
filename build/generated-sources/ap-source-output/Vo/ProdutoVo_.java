package Vo;

import Vo.FornecedorVo;
import Vo.GrupoProdutoVo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T20:02:27")
@StaticMetamodel(ProdutoVo.class)
public class ProdutoVo_ { 

    public static volatile SingularAttribute<ProdutoVo, Integer> codigo;
    public static volatile SingularAttribute<ProdutoVo, Float> precoVenda;
    public static volatile SingularAttribute<ProdutoVo, String> nome;
    public static volatile SingularAttribute<ProdutoVo, GrupoProdutoVo> grupoProdutoVo;
    public static volatile ListAttribute<ProdutoVo, FornecedorVo> listaFornecedorVo;

}