package co.esampio.repo.repository.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import co.esampio.repo.entity.entities.TransaccionEntity;

public interface ITransaccionRepository extends CrudRepository<TransaccionEntity, Long>, JpaRepository<TransaccionEntity, Long>{

}
