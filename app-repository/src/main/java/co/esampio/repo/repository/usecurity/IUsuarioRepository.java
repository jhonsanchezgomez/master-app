package co.esampio.repo.repository.usecurity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.esampio.repo.entity.usecurity.UsuarioEntity;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long>, CrudRepository<UsuarioEntity, Long> {
	/**
	 * Metodo con el cual obtengo todos los usuarios parametrizados en el sistema
	 * @return
	 */
	List<UsuarioEntity> getAllUsers();
	/**
	 * Query con el cual se autenticara un usuario
	 * @param usuario
	 * @param contrasena
	 * @return
	 */
	Optional<UsuarioEntity> authenticateUser(@Param("usuario") String usuario,@Param("contrasena") String contrasena);
	/**
	 * Metodo con el cual busco un usuario por medio de su usuario
	 * @param usuario
	 * @return
	 */
	Optional<UsuarioEntity> findByUsuario(String usuario);
}