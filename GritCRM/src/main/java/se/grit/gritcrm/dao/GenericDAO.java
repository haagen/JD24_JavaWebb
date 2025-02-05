package se.grit.gritcrm.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import se.grit.gritcrm.util.HibernateUtil;
import se.grit.gritcrm.model.User;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDAO<T, ID extends Serializable> {

    private final Class<T> persistentClass;

    public GenericDAO(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public T findById(ID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (T) session.get(persistentClass, id);
    }

    public T findById(ID id, User owner) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<T> query = session.createQuery("FROM "+persistentClass.getSimpleName()+" pc WHERE pc.id = :id AND pc.user.id = :ownerId", persistentClass);
        query.setParameter("ownerId", owner.getId());
        query.setParameter("id", id);
        List<T> results = query.list();
        T o = null;
        if(results.size() == 1) {
            o = results.getFirst();
        }
        session.close();
        return o;
    }

    public List<T> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<T> query = session.createQuery("FROM "+persistentClass.getSimpleName(), persistentClass);
        return query.list();
    }

    public List<T> findAll(User owner) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<T> query = session.createQuery("FROM "+persistentClass.getSimpleName()+" pc WHERE pc.user.id = :ownerId", persistentClass);
        query.setParameter("ownerId", owner.getId());
        return query.list();
    }

    public void save(T entity) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
        } catch (Throwable e) {
            if(tx != null) tx.rollback();
            throw e;
        }
    }

    public void update(T entity) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.merge(entity);
            tx.commit();
        } catch (Throwable e) {
            if(tx != null) tx.rollback();
            throw e;
        }
    }

    public void delete(T entity) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        } catch (Throwable e) {
            if(tx != null) tx.rollback();
            throw e;
        }
    }

    public void deleteById(ID id, User owner) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            T entity = findById(id, owner);
            System.out.println("deleting entity: " + entity);
            if(entity != null) {
                session.remove(entity);
            }
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null) tx.rollback();
            throw e;
        }
    }


}
