package co.esampio.util.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class ResponseRestService<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T object;
	private List<T> listObject;
	private T[] vectorObject;
	private Integer code;

	private String method;
	private String uri;
	private String user;
	private String message;
	private String developerMessage;
	
	private Long idTarjeta;
	private BigDecimal saldo;
	
	public ResponseRestService(T object) {
		super();
		this.object = object;
		this.code = 1;
	}

	public ResponseRestService(List<T> listObject) {
		super();
		this.listObject = listObject;
		this.code = 1;
	}

	public ResponseRestService(T[] vectorObject) {
		super();
		this.vectorObject = vectorObject;
	}

	public ResponseRestService(String method, String uri, String user, String message) {
		super();
		this.method = method;
		this.uri = uri;
		this.user = user;
		this.message = message;
		this.code = 2;
	}
	public ResponseRestService(String message, Long idTarjeta, BigDecimal saldo) {
		super();
		this.message = message;
		this.idTarjeta = idTarjeta;
		this.saldo = saldo;
		this.code = 2;
	}
	
	
	
	
	
	
	

}
