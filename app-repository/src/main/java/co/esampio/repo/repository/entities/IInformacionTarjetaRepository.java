package co.esampio.repo.repository.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.esampio.repo.entity.entities.InformacionTarjetaEntity;

@Repository
public interface IInformacionTarjetaRepository extends CrudRepository<InformacionTarjetaEntity, Long>, JpaRepository<InformacionTarjetaEntity, Long>{

}
