/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("juridica")

public class PessoaJuridicaVo extends PessoaVo implements Serializable {
    
    @Column(length = 50, nullable = false)
    private String razaoSocial;
    
    public PessoaJuridicaVo(String razaoSocial, int codigo, String nome) {
        super(codigo, nome);
        this.razaoSocial = razaoSocial;
    }
    
    public PessoaJuridicaVo() {
    }
    
    public String getNomeFantasia() {
        return super.getNome();
    }
    
    public void setNomeFantasia(String nomeFantasia) {        
        super.setNome(nomeFantasia);        
    }    

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    
}
