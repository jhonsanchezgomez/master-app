package co.esampio.util.exception.custom;

import java.math.BigDecimal;

public class BussinesTransactionCardException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idTarjeta;
	private BigDecimal saldo;

	public BussinesTransactionCardException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

	public BussinesTransactionCardException(String errorMessage, Long idTarjeta, BigDecimal saldo) {
		super(errorMessage);
		this.idTarjeta = idTarjeta;
		this.saldo = saldo;
	}

	public Long getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(Long idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}
