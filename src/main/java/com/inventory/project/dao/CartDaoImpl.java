package com.inventory.project.dao;

import com.inventory.project.model.Cart;
import com.inventory.project.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class CartDaoImpl implements CartDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Product> getAllItems() {
        Session session = sessionFactory.openSession();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);

        // Specify criteria root
        criteria.from(CartDao.class);

        // Execute query
        List<Product> products = session.createQuery(criteria).getResultList();

        // Close session
        session.close();

        return products;
    }

    @Override
    public void deleteItem(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void addItemToCart(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void addAllItemsToCart(List<Product> allProducts) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(allProducts);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveToCart(Cart cart){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(cart);
        session.getTransaction().commit();
        session.close();
    }
}