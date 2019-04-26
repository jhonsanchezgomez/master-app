package co.esampio.repo.repository.usecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.esampio.repo.entity.usecurity.RoleRestEntity;

@Repository
public interface IRoleRestRepository extends JpaRepository<RoleRestEntity, Long>, CrudRepository<RoleRestEntity, Long>, IRoleRestRepositoryCustom{

}