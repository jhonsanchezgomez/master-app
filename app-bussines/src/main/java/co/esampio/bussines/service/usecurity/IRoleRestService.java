package co.esampio.bussines.service.usecurity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import co.esampio.repo.entity.usecurity.RoleRestEntity;
public interface IRoleRestService {
	
	/**
	 * Metodo con el cual guardo un role rest 
	 * @param entity
	 * @return
	 */
	RoleRestEntity save(RoleRestEntity entity);
	/**
	 * Metodo con el cual por medio del usuario se buscan los roles 
	 * @return
	 */
	Optional<Set<RoleRestEntity>> findRolesByUser(String usuario);
	
	/**
	 * Metodo con el cual modifico los roles rest de un usuario de un usuario 
	 * @param idUser
	 * @return
	 */
	Optional<Boolean> modifyRoleRestByUser(Long idUser, List<RoleRestEntity> idRoleRest);
	
}
