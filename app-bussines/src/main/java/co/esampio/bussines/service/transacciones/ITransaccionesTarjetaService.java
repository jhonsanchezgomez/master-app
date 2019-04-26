package co.esampio.bussines.service.transacciones;

import java.math.BigDecimal;

public interface ITransaccionesTarjetaService {
	/**
	 * Metodo con el cual se realizan las transacciones en concreto ya sean DEBITO o
	 * CREDITO dependiendo su implementacion
	 * 
	 * @param idTarjeta
	 * @param valTrans
	 * @return
	 */
	BigDecimal generaTransaccion(Long idTarjeta, BigDecimal valTrans) throws Exception ;

}
