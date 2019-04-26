package co.esampio.util.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TarjetaDTO {
	
	private String tipo;
	private BigDecimal monto;
	private Long idT;
}
