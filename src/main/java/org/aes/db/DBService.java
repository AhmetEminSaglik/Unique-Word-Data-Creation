package org.aes.db;

import java.util.List;

public class DBService<E> {
    DBConnection dbConnection;

    public DBService(Class<?> clazz) {
        dbConnection = new DBConnection(clazz);
    }

    public List<E> getAll() {
        return (List<E>) dbConnection.getAll();
    }
}
