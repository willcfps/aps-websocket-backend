package br.com.wcf.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.wcf.model.user.PerfilUsuarioModel;
import br.com.wcf.model.user.PerfilUsuarioModel_;
import br.com.wcf.model.user.UsuarioModel;
import br.com.wcf.model.user.UsuarioModel_;
import br.com.wcf.model.user.inspector.InspetorModel;

@Component
public class UsuarioRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepository.class);

	@PersistenceContext
	private EntityManager manager;

	public List<UsuarioModel> getAllUsuarios() {
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<UsuarioModel> query = builder.createQuery(UsuarioModel.class);
			Root<UsuarioModel> root = query.from(UsuarioModel.class);

			TypedQuery<UsuarioModel> typedQuery = manager
					.createQuery(query.orderBy(builder.asc(root.get(UsuarioModel_.id))));

			return typedQuery.getResultList();
		} catch (Exception e) {
			LOGGER.error(" -Exception: ", e);
			throw e;
		}
	}

	@Transactional
	public UsuarioModel guardarUsuario(UsuarioModel u) {
		try {
			return this.manager.merge(u);
		} catch (Exception e) {
			LOGGER.error(" -Exception: ", e);
			throw e;
		}
	}
	
	public List<PerfilUsuarioModel> getAllPerfil() {
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<PerfilUsuarioModel> query = builder.createQuery(PerfilUsuarioModel.class);
			Root<PerfilUsuarioModel> root = query.from(PerfilUsuarioModel.class);

			TypedQuery<PerfilUsuarioModel> typedQuery = manager
					.createQuery(query.orderBy(builder.asc(root.get(PerfilUsuarioModel_.id))));

			return typedQuery.getResultList();
		} catch (Exception e) {
			LOGGER.error(" -Exception: ", e);
			throw e;
		}
	}

	@Transactional
	public PerfilUsuarioModel guardarPerfilUsuario(PerfilUsuarioModel p) {
		try {
			return this.manager.merge(p);
		} catch (Exception e) {
			LOGGER.error(" -Exception: ", e);
			throw e;
		}
	}
	
	@Transactional
	public InspetorModel guardarInspetor(InspetorModel i) {
		try {
			return this.manager.merge(i);
		} catch (Exception e) {
			LOGGER.error(" -Exception: ", e);
			throw e;
		}
	}
}
