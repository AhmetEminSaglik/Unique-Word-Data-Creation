package org.aes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        try {
            Session session = createSession();
            session.beginTransaction();
            session.persist(o);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }


    public void saveAll(List<?> objectList) {
        int i = 0;
        try {
            Session session = createSession();
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
            factory.close();
        }
    }

    public void testCriteria() {
        Session session=createSession();
//        session.create
//        session
//        session.
//        List<?> dataList =session.createStoredProcedureQuery()
    }
}
