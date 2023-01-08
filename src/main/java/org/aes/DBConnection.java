package org.aes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.swing.text.TabableView;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    SessionFactory factory;
    Class<?> clazz;

    public DBConnection(Class<?> clazz) {
        this.clazz = clazz;
    }


    private Session createSession() {
        try {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(clazz)
                    .buildSessionFactory();
        } catch (Exception e) {
            System.err.println("error occured : " + e.getMessage());
        }
        return factory.getCurrentSession();

    }

    public void save(Object o) {
        Session session = createSession();
        try {

            Transaction transaction=session.beginTransaction();
            session.persist(o);
            transaction.commit();

        } finally {
            session.close();
            factory.close();
        }
    }

    public void saveAll(List<?> objectList) {
        int i = 0;
        Session session = createSession();
        try {

            session.beginTransaction();
            session.setJdbcBatchSize(50);
            for (i = 0; i < objectList.size(); i++) {
                session.persist(objectList.get(i));
                if (i % session.getJdbcBatchSize() == 0) {
                    session.flush();
                    session.clear();
                }
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(i + "-) " + objectList.get(i));
            System.out.println("Error occured : " + e.getMessage());
        } finally {
            session.close();
            factory.close();
        }
    }

    public Object getById(int id) {
        Object object = null;
        try {
            Session session = createSession();
            Transaction transaction = session.beginTransaction();
            String hql = "FROM "+clazz.getSimpleName()+" W WHERE W.id = :id";
            Query query = session.createQuery(hql, clazz);
            query.setParameter("id", id);
//        query.setParameter("propertyValue", "some value");
            object = query.uniqueResult();
            transaction.commit();

        } catch (Exception e) {
            System.out.println("error occurred : " + e.getMessage());
        } finally {
            factory.close();
        }
        return object;
    }

    public List<? extends Object> getAll() {

        List<?> list = new ArrayList<>();
        Session session = createSession();

        Transaction transaction = session.beginTransaction();
        try {
            list = session.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("error occurred : " + e.getMessage());
        } finally {
            session.close();
            factory.close();
        }
        return list;
    }
}
