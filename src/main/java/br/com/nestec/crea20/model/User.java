package br.com.nestec.crea20.model;

import br.com.nestec.crea20.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

@Entity @Data
@Table(name = "usuarios") @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ativo")
    private Boolean active;
    @Column(name = "nome")
    private String name = "";
    @Column(unique = true, length = 11, nullable = false)
    private String cpf = "";
    @Column(name="data_cadastro")
    private Date registrationDate = new Date(System.currentTimeMillis());
    private String email = "";
    @Column(name = "sexo") @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(nullable = false, name = "senha") @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password = "";
    @Column( name = "login_sitac")
    private String loginSitac = "";
    @Column(name = "matricula")
    private String registration = "";
    private String tel = "";
    @Column(name = "imagem_perfil")
    private byte[] profilePicture;
    @Column(name = "chave_dispositivo")
    private String deviceKey = "";
    @Column(name = "mudou_senha")
    private boolean changePassword;
    private String latitude = "";
    private String longitude = "";

    @ManyToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "id_role")
    private Collection<Role> roles = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Company.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "usuarios_empresas", joinColumns = {
            @JoinColumn(name = "id_usuario", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_usuario")) }, inverseJoinColumns = {
            @JoinColumn(name = "id_empresa", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empresa")) })
    private Set<Company> companies;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Link.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "usuarios_acessos", joinColumns = {
            @JoinColumn(name = "id_usuario", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_usuario")) }, inverseJoinColumns = {
            @JoinColumn(name = "id_link", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_link")) })
    private Set<Link> links;


    public User(long id, boolean ativo, String nome, String cpf, Date date, String email, Gender sexo, String senha, String login, String matricula, String tel, byte[] bytes, String chave, boolean mudouSenha, String latitude, String longitude, ArrayList<Role> roles) {
        this.id = id;
        this.active = ativo;
        this.name = nome;
        this.cpf = cpf;
        this.registrationDate = date;
        this.email = email;
        this.gender = sexo;
        this.password = senha;
        this.loginSitac = login;
        this.registration = matricula;
        this.tel = tel;
        this.profilePicture = bytes;
        this.deviceKey = chave;
        this.changePassword = mudouSenha;
        this.latitude = latitude;
        this.longitude = longitude;
        this.roles = roles;
    }
}

