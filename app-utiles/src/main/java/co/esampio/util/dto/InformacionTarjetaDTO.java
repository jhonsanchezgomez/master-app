package co.esampio.util.dto;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InformacionTarjetaDTO {
	
	private Long id;
	private Double saldo;
	private String activo;
	private Date ultimoUso;
	private List<TransaccionDTO> transacciones;
	
}
