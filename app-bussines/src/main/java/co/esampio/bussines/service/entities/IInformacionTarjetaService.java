package co.esampio.bussines.service.entities;

import java.util.List;
import java.util.Optional;

import co.esampio.repo.entity.entities.InformacionTarjetaEntity;

public interface IInformacionTarjetaService {
	
	 Optional<InformacionTarjetaEntity> get(Long id);
	 public List<InformacionTarjetaEntity> getAll();
	 public void post(InformacionTarjetaEntity entity);
	 public void put(InformacionTarjetaEntity entity, long id);
	 public Boolean delete(Long id);

}
