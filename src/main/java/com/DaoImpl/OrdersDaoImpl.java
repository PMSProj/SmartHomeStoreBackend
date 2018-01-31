package com.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.OrderDao;
import com.Model.Orders;
@Repository
public class OrdersDaoImpl implements OrderDao
{
 @Autowired
 SessionFactory sessionFactory;
 public OrdersDaoImpl(SessionFactory sessionFactory)
 {
	 this.sessionFactory=sessionFactory;
 }
 @Transactional
 public void insertOrder(Orders order)
 {
	 Session session=sessionFactory.openSession();
	 session.getTransaction();
	 session.persist(order);
	 session.getTransaction().commit();
 }

}