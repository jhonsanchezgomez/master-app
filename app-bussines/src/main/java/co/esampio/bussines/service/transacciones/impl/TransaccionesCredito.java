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
import co.esampio.util.exception.custom.BussinesTransactionCardException;

@Service("transCredito")
@Transactional
public class TransaccionesCredito implements ITransaccionesTarjetaService {

	private static final Log LOG = LogFactory.getLog(TransaccionesCredito.class);

	@Autowired
	IInformacionTarjetaRepository informacionTarjetaRepository;
	@Autowired
	ITransaccionRepository transaccionRepository;

	@Override
	public BigDecimal generaTransaccion(Long idTarjeta, BigDecimal valTrans) throws Exception {
		InformacionTarjetaEntity tarjeta = informacionTarjetaRepository.getOne(idTarjeta);
		LOG.info("Este es el saldo de la tarjeta " + tarjeta.getSaldo().toString());

		if (tarjeta.getSaldo().compareTo(valTrans) < 0) {
			LOG.info("El valor de la transaccion excede el saldo");
			throw new BussinesTransactionCardException("El valor de la transaccion excede el saldo",tarjeta.getId(), tarjeta.getSaldo());
		} else {
			tarjeta.setSaldo(tarjeta.getSaldo().subtract(valTrans));
			TransaccionEntity transaccion = new TransaccionEntity();
			transaccion.setTarjeta(tarjeta);
			transaccion.setTipoTransaccion("Descuento");
			transaccion.setValor(valTrans);
			transaccionRepository.save(transaccion);
			LOG.info("Generamos la resta");
		}

		LOG.info("Transaccion Credito");
		return null;
	}

}
