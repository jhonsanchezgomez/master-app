package co.esampio.bussines.service.entities;

import java.util.List;
import co.esampio.repo.entity.entities.TransaccionEntity;

public interface ITransaccionService {
	
	 public TransaccionEntity get(Long id);
	 public List<TransaccionEntity> getAll();
	 public void post(TransaccionEntity entity);
	 public void put(TransaccionEntity entity, long id);
	 public Boolean delete(Long id);

}
