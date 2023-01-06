package org.aes;

import org.hibernate.FlushMode;
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
            session.saveOrUpdate(o);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

    public void savePersist(List<?> objectList, int batchSize) {
        int i = 0;
        try {
            Session session = createSession();
            session.beginTransaction();
//            factory.getCurrentSession().setJdbcBatchSize(10);
            session.setJdbcBatchSize(batchSize);
            for (i = 0; i < objectList.size(); i++) {
//                System.out.println(i + "-) " + objectList.get(i));
//                session.save(objectList.get(i));
                session.persist(objectList.get(i));
                if (i % session.getJdbcBatchSize() == 0) {
//                    System.out.println("index : " + i);

                    session.flush();
                    session.clear();

                }
            }
            /*for (Object tmp : objectList) {
                session.save(tmp);
            }*/
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(i + "-) " + objectList.get(i));
            System.out.println("Error occured : " + e.getMessage());
        } finally {
            factory.close();
        }
    }

    public void saveNormal(List<?> objectList, int batchSize) {
        int i = 0;
        try {
            Session session = createSession();
            session.beginTransaction();
//            factory.getCurrentSession().setJdbcBatchSize(10);
            session.setJdbcBatchSize(batchSize);
            for (i = 0; i < objectList.size(); i++) {
//                System.out.println(i + "-) " + objectList.get(i));
                session.save(objectList.get(i));
//                session.persist(objectList.get(i));
                if (i % session.getJdbcBatchSize() == 0) {
//                    System.out.println("index : " + i);
                    session.flush();
                    session.clear();
                    }
            }
            /*for (Object tmp : objectList) {
                session.save(tmp);
            }*/
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(i + "-) " + objectList.get(i));
            System.out.println("Error occured : " + e.getMessage());
        } finally {
            factory.close();
        }
    }

    public void saveOrUpdate(List<?> objectList, int batchSize) {
        int i = 0;
        try {
            Session session = createSession();
            session.beginTransaction();
//            factory.getCurrentSession().setJdbcBatchSize(10);
            session.setJdbcBatchSize(batchSize);
            for (i = 0; i < objectList.size(); i++) {
//                System.out.println(i + "-) " + objectList.get(i));
                session.saveOrUpdate(objectList.get(i));
//                session.persist(objectList.get(i));
                if (i % session.getJdbcBatchSize() == 0) {
//                    System.out.println("index : " + i);

                    session.flush();
                    session.clear();

                }
            }
            /*for (Object tmp : objectList) {
                session.save(tmp);
            }*/
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(i + "-) " + objectList.get(i));
            System.out.println("Error occured : " + e.getMessage());
        } finally {
            factory.close();
        }
    }
}
