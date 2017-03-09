package coursework.dao;


import coursework.interfaces.EntityItem;
import coursework.utils.HibernateSessionFactory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by chanta on 08.03.17.
 */
public abstract class AbstractDAO {
    private final static Logger logger = Logger.getLogger(AbstractDAO.class);

    protected Integer create(EntityItem entity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            return entity.getId();
        } catch (HibernateException e) {
            logger.error(e);
            return null;
        }
    }

    protected static EntityItem read(Integer id, Class<? extends EntityItem> resultType) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            return session.get(resultType, id);
        } catch (HibernateException e) {
            logger.error(e);
            return null;
        }
    }

    protected static <T extends EntityItem> List<T> readAll(Integer limit, Integer offset, Class<T> resultType) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            CriteriaQuery<T> cq = session.getCriteriaBuilder().createQuery(resultType);
            cq.select(cq.from(resultType));

            TypedQuery<T> typedQuery = session.createQuery(cq);
            typedQuery.setFirstResult(limit);
            typedQuery.setMaxResults(offset);

            return typedQuery.getResultList();
        } catch (HibernateException e) {
            logger.error(e);
            return null;
        }
    }

    protected void update(EntityItem entity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            logger.error(e);
        }
    }

    protected void delete(Integer id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            logger.error(e);
        }
    }
}
