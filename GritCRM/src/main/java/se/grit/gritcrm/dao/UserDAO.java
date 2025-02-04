package se.grit.gritcrm.dao;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import se.grit.gritcrm.model.User;
import se.grit.gritcrm.util.HibernateUtil;

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

}
