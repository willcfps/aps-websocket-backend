package br.com.wcf.jpa.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.wcf.model.messages.login.LoginProjectsRestMessage;
import br.com.wcf.model.project.ProjetoModel;
import br.com.wcf.model.project.ProjetoModel_;
import br.com.wcf.model.user.UsuarioModel;
import br.com.wcf.model.user.UsuarioModel_;
import br.com.wcf.model.user.inspector.InspetorModel;
import br.com.wcf.model.user.inspector.InspetorModel_;

@Component
public class ProjetoRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjetoRepository.class);

	@PersistenceContext
	private EntityManager manager;

	public ProjetoModel findById(Integer id) {
		return this.manager.find(ProjetoModel.class, id);
	}

	@Transactional
	public ProjetoModel guardarProjeto(ProjetoModel p) {
		try {
			return this.manager.merge(p);
		} catch (Exception e) {
			LOGGER.error(" -Exception: ", e);
			return null;
		}
	}
	
	public List<ProjetoModel> getAllByIdUserInspectorOwner(Integer id) {
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<ProjetoModel> query = builder.createQuery(ProjetoModel.class);
			Root<ProjetoModel> from = query.from(ProjetoModel.class);

			Predicate where = builder.equal(from.get(ProjetoModel_.owner).get(InspetorModel_.user).get(UsuarioModel_.id), id);

			return manager.createQuery(query.where(where)).getResultList();
		} catch (Exception e) {
			LOGGER.error(" -Exception: ", e);
			return new ArrayList<>();
		}
	}

	public List<ProjetoModel> getAllByIdInspectorOwner(Integer id) {
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<ProjetoModel> query = builder.createQuery(ProjetoModel.class);
			Root<ProjetoModel> from = query.from(ProjetoModel.class);

			Predicate where = builder.equal(from.get(ProjetoModel_.owner).get(InspetorModel_.id), id);

			return manager.createQuery(query.where(where)).getResultList();
		} catch (Exception e) {
			LOGGER.error(" -Exception: ", e);
			return new ArrayList<>();
		}
	}

	public List<LoginProjectsRestMessage> getAllInspectorOwner(InspetorModel i) {
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<LoginProjectsRestMessage> query = builder.createQuery(LoginProjectsRestMessage.class);
			Root<ProjetoModel> from = query.from(ProjetoModel.class);

			Predicate where = builder.equal(from.get(ProjetoModel_.owner), i);

			query.select(builder.construct(LoginProjectsRestMessage.class, from.get(ProjetoModel_.id),
					from.get(ProjetoModel_.title)));

			return manager.createQuery(query.where(where)).getResultList();
		} catch (Exception e) {
			LOGGER.error(" -Exception: ", e);
			return new ArrayList<>();
		}
	}

	public List<LoginProjectsRestMessage> getAllInspectorOwner(UsuarioModel u) {
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<LoginProjectsRestMessage> query = builder.createQuery(LoginProjectsRestMessage.class);
			Root<ProjetoModel> from = query.from(ProjetoModel.class);

			Predicate where = builder.equal(from.get(ProjetoModel_.owner).get(InspetorModel_.user), u);

			query.select(builder.construct(LoginProjectsRestMessage.class, from.get(ProjetoModel_.id),
					from.get(ProjetoModel_.title)));

			return manager.createQuery(query.where(where)).getResultList();
		} catch (Exception e) {
			LOGGER.error(" -Exception: ", e);
			return new ArrayList<>();
		}
	}

	public List<LoginProjectsRestMessage> getAllInpectorParticipant(InspetorModel u) {
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<LoginProjectsRestMessage> query = builder.createQuery(LoginProjectsRestMessage.class);
			Root<ProjetoModel> from = query.from(ProjetoModel.class);
			Join<ProjetoModel, InspetorModel> pJoin = from.join(ProjetoModel_.participants);

			Predicate where = builder.equal(pJoin.get(InspetorModel_.id), u.getId());

			query.select(builder.construct(LoginProjectsRestMessage.class, from.get(ProjetoModel_.id),
					from.get(ProjetoModel_.title)));

			return manager.createQuery(query.where(where)).getResultList();
		} catch (Exception e) {
			LOGGER.error(" -Exception: ", e);
			return new ArrayList<>();
		}
	}

	public List<LoginProjectsRestMessage> getAllInpectorParticipant(UsuarioModel u) {
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<LoginProjectsRestMessage> query = builder.createQuery(LoginProjectsRestMessage.class);
			Root<ProjetoModel> from = query.from(ProjetoModel.class);
			Join<ProjetoModel, InspetorModel> pJoin = from.join(ProjetoModel_.participants);

			Subquery<Integer> sub = query.subquery(Integer.class);
			Root<InspetorModel> sRoot = sub.from(InspetorModel.class);
			sub.select(sRoot.get(InspetorModel_.id)).where(builder.equal(sRoot.get(InspetorModel_.user), u))
					.distinct(true);

			Predicate where = builder.equal(pJoin.get(InspetorModel_.id), sub);

			query.select(builder.construct(LoginProjectsRestMessage.class, from.get(ProjetoModel_.id),
					from.get(ProjetoModel_.title)));

			return manager.createQuery(query.where(where)).getResultList();
		} catch (Exception e) {
			LOGGER.error(" -Exception: ", e);
			return new ArrayList<>();
		}
	}
}
