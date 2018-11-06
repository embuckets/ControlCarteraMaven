/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embuckets.controlcarteramaven.persistecia;

import com.embuckets.controlcarteramaven.dominio.Asegurado;
import com.embuckets.controlcarteramaven.hibernate.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author emilio
 */
public class AseguradoMapper {

    private SessionFactory sessionFactory;

    public AseguradoMapper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Serializable save(Asegurado asegurado) {
        Serializable id;
        try (Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            id = session.save(asegurado);
            session.getTransaction().commit();
        }
        return id;

    }

}
