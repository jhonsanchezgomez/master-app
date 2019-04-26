package co.esampio.bussines.service.transacciones.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.esampio.bussines.service.transacciones.ITransaccionesTarjetaService;
import co.esampio.repo.entity.entities.InformacionTarjetaEntity;
import co.esampio.repo.entity.entities.TransaccionEntity;
import co.esampio.repo.repository.entities.IInformacionTarjetaRepository;
import co.esampio.repo.repository.entities.ITransaccionRepository;

@Service("transDebito")
@Transactional
public class TransaccionesDebito implements ITransaccionesTarjetaService  {

	private static final Log LOG = LogFactory.getLog(TransaccionesDebito.class);
	
	@Autowired
	IInformacionTarjetaRepository informacionTarjetaRepository;
	@Autowired
	ITransaccionRepository transaccionRepository;
	
	@Override
	public BigDecimal generaTransaccion(Long idTarjeta,BigDecimal valTrans) {
		InformacionTarjetaEntity tarjeta = informacionTarjetaRepository.getOne(idTarjeta);
		LOG.info("Este es el saldo de la tarjeta " + tarjeta.getSaldo().toString());
		tarjeta.setSaldo(tarjeta.getSaldo().add(valTrans));		
		LOG.info("Registro de transaccion");
		
		TransaccionEntity transaccion = new TransaccionEntity();
		transaccion.setTarjeta(tarjeta);
		transaccion.setTipoTransaccion("Recarga");
		transaccion.setValor(valTrans);
		transaccionRepository.save(transaccion);
		
		LOG.info("Transaccion realizada correctamente");
		
		return tarjeta.getSaldo();
	}

}
