package co.esampio.repo.entity.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import co.esampio.repo.entity.audit.Auditable;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name = "tbl_informacion_tarjetas")
@Audited
public class InformacionTarjetaEntity extends Auditable<String>{
	
	@Id
	@Column(name = "id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "saldo")
	private BigDecimal saldo;
	@Column(name = "activo")
	private String activo;
	@Column(name = "ultimo_uso")
	private Date ultimoUso;
	
	@OneToMany(mappedBy = "tarjeta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TransaccionEntity> transacciones;
	
	@Override
	public String toString() {
		return "InformacionTarjetaEntity [id=" + id + ", saldo=" + saldo + ", activo=" + activo + ", ultimoUso="
				+ ultimoUso + "]";
	}
	
	
}
