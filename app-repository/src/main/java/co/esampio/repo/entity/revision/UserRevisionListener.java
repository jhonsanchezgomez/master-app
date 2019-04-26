package co.esampio.repo.entity.revision;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserRevisionListener implements RevisionListener{

	@Override
	public void newRevision(Object revisionEntity) {
		UserRevEntity revEntity = (UserRevEntity) revisionEntity;
		String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
		revEntity.setUserName(usuario);
	}

}
