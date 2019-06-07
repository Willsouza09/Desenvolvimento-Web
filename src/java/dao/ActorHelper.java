/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dvdrental.HibernateUtil;
import java.util.List;
import model.Actor;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author William
 */
public class ActorHelper {
        Session session = null;

    public ActorHelper() {
        //this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        openSession();

    }

    private void openSession() {
        if (session == null || !session.isOpen()) {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
    }

    public void closeSession() {

        if (session.isOpen()) {

            session.close();
        }
    }
        public List getActor() {
        openSession();
        List<Actor> actorList = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery("from Actor ");
            actorList = (List<Actor>) q.list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            // session.clear();
            closeSession();
        }
        return actorList;
    }
        public void salvar(Actor actor) {

        openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.save(actor);
            tx.commit();
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
        } finally {
            closeSession();
        }

    }

    public void editar(Actor actor) {

        openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.update(actor);
            tx.commit();
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
        } finally {
            closeSession();
            //session.close();
        }

    }

    public void excluir(Actor actor) {

        openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.delete(actor);
            tx.commit();
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
        } finally {
            closeSession();
            //session.close();
        }

    }
    
         public List getActorsByID(int actorId) {
        openSession();
        List<Actor> actorList = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery("from Actor as actor where actor.actorId= " + actorId );
            actorList = (List<Actor>) q.list();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
             // session.clear();
        }

        return actorList;
    }

}
