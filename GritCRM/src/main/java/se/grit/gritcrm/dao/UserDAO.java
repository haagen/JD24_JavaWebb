package se.grit.gritcrm.dao;

import jakarta.transaction.Transactional;
import org.hibernate.*;
import org.hibernate.query.Query;
import se.grit.gritcrm.model.User;
import se.grit.gritcrm.util.HibernateUtil;

import java.util.List;

public class UserDAO {

    public void save(User entity){
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
        }catch(Throwable e) {
            if(tx != null){
                tx.rollback();
            }
            throw e;
        }
    }

    public User getUser(String username) throws HibernateException {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE username = :username", User.class);
            query.setParameter("username", username);
            List<User> users = query.list();
            if(users.isEmpty()){
                return null;
            }
            return users.getFirst();
        }
    }

}
