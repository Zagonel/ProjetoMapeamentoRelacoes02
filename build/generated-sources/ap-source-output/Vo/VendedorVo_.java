package Vo;

import Vo.VendaVo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T20:02:27")
@StaticMetamodel(VendedorVo.class)
public class VendedorVo_ extends PessoaFisicaVo_ {

    public static volatile SingularAttribute<VendedorVo, Float> perComissao;
    public static volatile ListAttribute<VendedorVo, VendaVo> listaVendaVo;

}