package co.esampio.repo.repository.usecurity.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.esampio.repo.entity.usecurity.RoleRestEntity;
import co.esampio.repo.repository.usecurity.IRoleRestRepositoryCustom;

@Repository
@Transactional
public class IRoleRestRepositoryImpl implements IRoleRestRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Boolean deleteRoleRestByUser(Long id) {
		Query query = entityManager.createNativeQuery("DELETE FROM usuario_as_roles WHERE id_us = ? ");
		query.setParameter(1, id);
		query.executeUpdate();
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveRolesRestByUser(Long idUser, List<RoleRestEntity> idRolesRest) {
		for(RoleRestEntity item : idRolesRest) {
			Query query = entityManager.createNativeQuery("insert into usuario_as_roles ( id_us, id_ro ) values (?,?)");
			query.setParameter(1, idUser);
			query.setParameter(2, item.getId());
			query.executeUpdate();
			
		}
		return Boolean.TRUE;
	}

}
