/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author Alcidia Cristina
 */
@Entity
@SQLDelete(sql = "UPDATE medicamentos SET ativo_fk = ? WHERE id= ?")
@Where(clause = "ativo=1 ")
//@Where(clause = "ativo=1 and Farmacia f f.ativo =1")
public class Medicamentos implements Serializable{
    private Long id;
    
    private String nome;
    private String principioAtivo;
    private String concentracao;
    private String formaFarmaceutica;
    private int registroAnvisa;
    private String detentorRegistro;
    private Farmacia farmacia;
    private List<Categoria> categoria;
    private double preco;
    private Long quantidade;
    private List<Imagem> imagens;
    private String sexo;
    
    private int ativo = 1;

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
 
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
    
     public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(String concentracao) {
        this.concentracao = concentracao;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public int getRegistroAnvisa() {
        return registroAnvisa;
    }

    public void setRegistroAnvisa(int registroAnvisa) {
        this.registroAnvisa = registroAnvisa;
    }

    public String getDetentorRegistro() {
        return detentorRegistro;
    }

    public void setDetentorRegistro(String detentorRegistro) {
        this.detentorRegistro = detentorRegistro;
    }
    
     
    
    
    
    
    
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "produto_id")
    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }

    
    
    
    @JsonIgnore
    @ManyToMany
    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

      
    
    
    
    @OneToOne(cascade={ CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE })
   // @Where(clause="ativo <> 0")
    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }
    
    @Column(name = "ativo")
    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }  

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.principioAtivo);
        hash = 79 * hash + Objects.hashCode(this.concentracao);
        hash = 79 * hash + Objects.hashCode(this.formaFarmaceutica);
        hash = 79 * hash + this.registroAnvisa;
        hash = 79 * hash + Objects.hashCode(this.detentorRegistro);
        hash = 79 * hash + Objects.hashCode(this.farmacia);
        hash = 79 * hash + Objects.hashCode(this.categoria);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.quantidade);
        hash = 79 * hash + Objects.hashCode(this.imagens);
        hash = 79 * hash + Objects.hashCode(this.sexo);
        hash = 79 * hash + this.ativo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medicamentos other = (Medicamentos) obj;
        if (this.registroAnvisa != other.registroAnvisa) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.principioAtivo, other.principioAtivo)) {
            return false;
        }
        if (!Objects.equals(this.concentracao, other.concentracao)) {
            return false;
        }
        if (!Objects.equals(this.formaFarmaceutica, other.formaFarmaceutica)) {
            return false;
        }
        if (!Objects.equals(this.detentorRegistro, other.detentorRegistro)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.farmacia, other.farmacia)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.imagens, other.imagens)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
