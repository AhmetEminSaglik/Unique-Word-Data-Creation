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
            System.out.println(">>>>>>>>>>> >>>>>>>>>>>error occured : " + e.getMessage());
        }
        return factory.getCurrentSession();

    }

    public void save(Object o) {
        try {
            Session session = createSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

    public void save(List<?> objectList) {
        try {
            Session session = createSession();
            session.beginTransaction();
            for (Object tmp : objectList) {
                session.save(tmp);
            }
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
