package Vo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("fisica")

public class PessoaFisicaVo extends PessoaVo implements Serializable {

    @Column(length = 20, nullable = false)
    private String RG;
    
    @Column(length = 20, nullable = false)
    private String CPF;

    public PessoaFisicaVo(String RG, String CPF, int codigo, String nome) {
        super(codigo, nome);
        this.RG = RG;
        this.CPF = CPF;
    }    

    public PessoaFisicaVo() {
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

}
