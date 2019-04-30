package co.esampio.util.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TarjetaDTO {
	@ApiModelProperty(notes = "Id de la tarjeta")
	private String tipo;
	@ApiModelProperty(notes = "Valor de la transacción ")
	private BigDecimal monto;
	@ApiModelProperty(notes = "Id de la tarjeta")
	private Long idT;
}
