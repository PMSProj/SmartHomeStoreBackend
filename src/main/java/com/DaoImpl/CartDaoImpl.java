package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.CartDao;
import com.Model.*;

@Repository("cartDaoImpl")
@Service
public  class CartDaoImpl implements CartDao
{
		@Autowired
		SessionFactory sessionFactory;
 
		 public CartDaoImpl(SessionFactory sessionFactory)
		 {
			 this.sessionFactory=sessionFactory;
		 }
		public void insertCart(Cart cart) 
		 {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.persist(cart);
			session.getTransaction().commit();
		 }
			@SuppressWarnings("unchecked")
	   public List<Cart> findByCartId(String userEmail)
	  {
		  Session session=sessionFactory.openSession();
		  List<Cart> cart=null;
		  try
		  {
			  session.beginTransaction();
			  cart=(List<Cart>) session.createQuery("from cart where userMailId=:email and cartProductId=:id").setString("email", userEmail).list();
		      session.getTransaction().commit();
		  }
		  catch(HibernateException e)
		  {
			  e.printStackTrace();
		      session.getTransaction().rollback();
		  }
		  return cart;
	  }

	public Cart getCartById(int cartProductId,String userEmail)
	  {
		Session session=sessionFactory.openSession();
		Cart cart=null;
		session.beginTransaction();
		cart=(Cart) session.createQuery("from Cart where userMailId=:email and cartProductId=:pid").setString("email" , userEmail).setInteger("id", cartProductId).uniqueResult();
	    session.getTransaction().commit();
	    return cart;
	  }
	  public void deleteCart(int cartId)
	  {
		  Session session=sessionFactory.openSession();
		  session.beginTransaction();
		  Cart cart=(Cart) session.get(Cart.class,cartId);
		  session.delete(cart);
		  session.getTransaction().commit();
	  }
	  public void updateCart(Cart cart)
	  {
		  Session session=sessionFactory.openSession();
		  session.beginTransaction();
		  session.update(cart);
		  session.getTransaction().commit();
	  }
}

