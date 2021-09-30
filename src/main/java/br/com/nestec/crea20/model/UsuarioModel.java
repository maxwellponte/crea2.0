package br.com.nestec.crea20.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean ativo;
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column(name="data_cadastro")
    private Date dataCadastro;


    private String email;
    private String funcao;

    @Column(nullable = false)
    private String senha;

    public UsuarioModel(Long id, Boolean ativo, String cpf, Date dataCadastro, String email, String funcao, String senha) {
        this.id = id;
        this.ativo = ativo;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.email = email;
        this.funcao = funcao;
        this.senha = senha;
        this.nome = nome;
    }

    public UsuarioModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
