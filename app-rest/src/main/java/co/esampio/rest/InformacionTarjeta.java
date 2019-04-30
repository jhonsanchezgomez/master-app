package co.esampio.rest;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.esampio.bussines.service.entities.IInformacionTarjetaService;
import co.esampio.bussines.service.transacciones.ITransaccionGlobalTarjetaService;
import co.esampio.repo.entity.entities.InformacionTarjetaEntity;
import co.esampio.util.dto.InformacionTarjetaDTO;
import co.esampio.util.dto.TIPO_TRANSACCION;
import co.esampio.util.dto.TarjetaDTO;
import co.esampio.util.response.ResponseRestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1.0/tarjetas")
@Api(value = "Rest Controller para Tarjeta")
public class InformacionTarjeta {
		
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	ITransaccionGlobalTarjetaService transaccionGlobalTarjetaService; 
	
	@Autowired
	IInformacionTarjetaService informacionTarjeta;
	
	@ApiOperation(value =  "Este servicio se encarga de realizar las transacciones de descuento o recarga de una tarjeta")
	@PostMapping(value="/transacciones", consumes="application/json", produces="application/json")
	public ResponseEntity<ResponseRestService<Boolean>> dataActu(@RequestBody TarjetaDTO tarjeta) throws Exception{		
		return new ResponseEntity<>(new ResponseRestService<>(transaccionGlobalTarjetaService.generaTransaccion((tarjeta.getTipo().equalsIgnoreCase("DESCUENTO") ? TIPO_TRANSACCION.CREDITO : TIPO_TRANSACCION.DEBITO), tarjeta.getIdT(), tarjeta.getMonto())),HttpStatus.OK);
	}

	@ApiOperation(value = "Este servicio consulta la información todas las tarjetas")
	@GetMapping(value="/", produces="application/json")
	public ResponseEntity<ResponseRestService<InformacionTarjetaDTO>> getTarjetas(){
		InformacionTarjetaDTO[] informacionTarjetaDTO = mapper.map(informacionTarjeta.getAll(), InformacionTarjetaDTO[].class);
		if (informacionTarjetaDTO.length == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new ResponseRestService<>(informacionTarjetaDTO), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Este servicio consulta la información de una tarjeta en especifico")
	@GetMapping(value="/{id}", produces="application/json")
	public ResponseEntity<ResponseRestService<InformacionTarjetaDTO>> getTarjeta(@ApiParam(value = "Id de la tarjeta para realizar la consulta") @PathVariable Long id){
		Optional<InformacionTarjetaEntity> tarjeta = informacionTarjeta.get(id);
		if (!tarjeta.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new ResponseRestService<>(mapper.map(tarjeta.get(), InformacionTarjetaDTO.class)), HttpStatus.OK);
	}

}
