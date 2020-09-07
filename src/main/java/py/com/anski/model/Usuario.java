package py.com.anski.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(columnNames = "nombre"),
    @UniqueConstraint(columnNames = "email")})
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idUsuario;

  @Column(name = "nombre", nullable = false, unique = true)
  private String username;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "clave", nullable = false)
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "rol_usuario", joinColumns = @JoinColumn(name = "id_usuario"),
      inverseJoinColumns = @JoinColumn(name = "id_rol"))
  
  private Set<Rol> roles = new HashSet<>();

  public Usuario() {}

  public Usuario(String username, String email, String password) {
    super();
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public Long getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Long id) {
    this.idUsuario = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Rol> getRoles() {
    return roles;
  }

  public void setRoles(Set<Rol> roles) {
    this.roles = roles;
  }

}
