package co.esampio.util.dto;

import java.util.Date;

import lombok.Getter;

import lombok.Setter;

@Setter @Getter
public class TransaccionDTO {
	
	private Long id;
	private String tipoTransaccion;
	private Double valor;
	private Date fechaTransaccion;
//	private InformacionTarjetaDTO tarjeta;
	
}
