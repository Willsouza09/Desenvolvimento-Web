/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dvdrental.HibernateUtil;
import java.util.List;
import model.Category;
import org.hibernate.Query;
import org.hibernate.Session;



/**
 *
 * @author William
 */
public class CategoryHelper {

    Session session = null;

    public CategoryHelper() {
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

    public List getCategoryName() {
        openSession();
        List<Category> categoryList = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery("from Category ");
            categoryList = (List<Category>) q.list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            // session.clear();
            closeSession();
        }
        return categoryList;
    }

    public void salvar(Category category) {

        openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.save(category);
            tx.commit();
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
        } finally {
            closeSession();
        }

    }

    public void editar(Category category) {

        openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.update(category);
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

    public void excluir(Category category) {

        openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.delete(category);
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
     public Category getCategoryByID(int categoryId) {
        openSession();
        List<Category> categoryList = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery("from Category as category where category.categoryId= " + categoryId );
            categoryList = (List<Category>) q.list();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            closeSession();
             // session.close();
        }

        return categoryList.get(0);
    }
}
