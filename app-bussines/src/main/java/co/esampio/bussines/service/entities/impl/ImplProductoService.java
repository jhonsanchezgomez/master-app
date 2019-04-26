package co.esampio.bussines.service.entities.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.esampio.bussines.service.entities.ITransaccionService;
import co.esampio.repo.entity.entities.TransaccionEntity;
import co.esampio.repo.repository.entities.ITransaccionRepository;

@Service
public class ImplProductoService implements ITransaccionService{
	
	@Autowired
	private ITransaccionRepository productoRepository;

	@Override
	public TransaccionEntity get(Long id) {
		return productoRepository.findById(id).get();
	}

	@Override
	public List<TransaccionEntity> getAll() {
		return (List<TransaccionEntity>) productoRepository.findAll();
	}

	@Override
	public void post(TransaccionEntity entity) {
		productoRepository.save(entity);
	}

	@Override
	public void put(TransaccionEntity entity, long id) {
		productoRepository.findById(id).ifPresent((x)->{
			entity.setId(id);
			productoRepository.save(entity);
		});
	}

	@Override
	public Boolean delete(Long id) {
		productoRepository.deleteById(id);
		return Boolean.TRUE;
	}

}
