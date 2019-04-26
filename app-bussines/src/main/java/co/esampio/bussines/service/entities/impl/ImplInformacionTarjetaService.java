package co.esampio.bussines.service.entities.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import co.esampio.bussines.service.entities.IInformacionTarjetaService;
import co.esampio.repo.entity.entities.InformacionTarjetaEntity;
import co.esampio.repo.repository.entities.IInformacionTarjetaRepository;

@Service
public class ImplInformacionTarjetaService implements IInformacionTarjetaService{

	@Autowired
	IInformacionTarjetaRepository infTarjetaRepository;

	@Override
	public Optional<InformacionTarjetaEntity> get(Long id) {
		return infTarjetaRepository.findById(id);
	}
	@Secured("ROLE_ADMIN")
	@Override
	public List<InformacionTarjetaEntity> getAll() {
		return (List<InformacionTarjetaEntity>) infTarjetaRepository.findAll();
	}

	@Override
	public void post(InformacionTarjetaEntity entity) {
		infTarjetaRepository.save(entity);
	}

	@Override
	public void put(InformacionTarjetaEntity entity, long id) {
		infTarjetaRepository.findById(id).ifPresent((x)->{
			entity.setId(id);
			infTarjetaRepository.save(entity);
		});
	}

	@Override
	public Boolean delete(Long id) {
		infTarjetaRepository.deleteById(id);
		return Boolean.TRUE;
	}
	
	
}
