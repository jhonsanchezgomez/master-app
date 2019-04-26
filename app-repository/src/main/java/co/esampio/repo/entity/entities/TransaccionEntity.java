package co.esampio.repo.entity.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import co.esampio.repo.entity.audit.Auditable;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name = "tbl_transacciones")
@Audited
public class TransaccionEntity extends Auditable<String>{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="tipo_transaccion")
	private String tipoTransaccion;
	@Column(name = "valor")
	private BigDecimal valor;
	@Column(name = "fecha_transaccion")
	private Date fechaTransaccion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="informacion_tarjetas_id", nullable=false)
	private InformacionTarjetaEntity tarjeta;

	@Override
	public String toString() {
		return "TransaccionEntity [id=" + id + ", tipoTransaccion=" + tipoTransaccion + ", valor=" + valor
				+ ", fechaTransaccion=" + fechaTransaccion + ", tarjeta=" + tarjeta + "]";
	}

	
}
