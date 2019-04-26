package co.esampio.repo.entity.usecurity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import co.esampio.repo.entity.audit.Auditable;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_usuarios")
@NamedQueries({
		@NamedQuery(name = "UsuarioEntity.getAllUsers", query = "select distinct u from UsuarioEntity u inner join fetch u.rolesRest rol"),
		@NamedQuery(name = "UsuarioEntity.authenticateUser", query = "select usuarioEntity from UsuarioEntity usuarioEntity where usuarioEntity.usuario = :usuario and usuarioEntity.contrasena = :contrasena  ") })
@Getter
@Setter
public class UsuarioEntity extends Auditable<String> {
	@Id
	@Column(name = "id_us", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
	@SequenceGenerator(name = "usuario_generator", sequenceName = "usuario_seq", allocationSize = 1)
	private Long id;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "usuario", unique = true)
	private String usuario;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "contrasena")
	private String contrasena;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "usuario_as_roles", joinColumns = @JoinColumn(name = "id_us"), inverseJoinColumns = @JoinColumn(name = "id_ro"))
	private Set<RoleRestEntity> rolesRest;

	public UsuarioEntity() {
		super();
	}

}