package com.jbd.database;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.sql.Savepoint;

@SessionScoped
public class ManageDB implements Serializable {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void  saveUser(sessionUser sessionUser){
        entityManager.persist(sessionUser);
    }
}
