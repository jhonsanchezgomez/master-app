package co.esampio.bussines.service.transacciones;

import java.math.BigDecimal;

import co.esampio.util.dto.TIPO_TRANSACCION;

public interface ITransaccionGlobalTarjetaService {
	/**
	 * Fachada por la cual entran todas las transacciones que tenga habilitada las
	 * tarjetas
	 * 
	 * @param tipoTransaccion
	 * @param idTarjeta
	 * @param valor
	 * @return
	 */
	Boolean generaTransaccion(TIPO_TRANSACCION tipoTransaccion, Long idTarjeta, BigDecimal valor)throws Exception  ;

}
