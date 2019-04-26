package co.esampio.bussines.service.transacciones.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.esampio.bussines.service.transacciones.ITransaccionGlobalTarjetaService;
import co.esampio.bussines.service.transacciones.ITransaccionesTarjetaService;
import co.esampio.util.dto.TIPO_TRANSACCION;

@Service
public class TransaccionTarjetaService implements ITransaccionGlobalTarjetaService {
	
	@Autowired
	@Qualifier("transDebito")
	ITransaccionesTarjetaService transaccionDebito;
	@Autowired
	@Qualifier("transCredito")
	ITransaccionesTarjetaService transaccionCredito;

	
	@Override
	public Boolean generaTransaccion(TIPO_TRANSACCION tipoTransaccion, Long idTarjeta, BigDecimal valor) throws Exception{
		if(TIPO_TRANSACCION.DEBITO.equals(tipoTransaccion)) {
			transaccionDebito.generaTransaccion(idTarjeta, valor);
		}else {
			transaccionCredito.generaTransaccion(idTarjeta, valor);
		}
		return Boolean.TRUE;
	}

}
