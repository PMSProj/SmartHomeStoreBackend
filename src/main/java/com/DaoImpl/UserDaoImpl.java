package com.DaoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.UserDao;

import com.Model.UserData;
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public void insertUser(UserData user)
	{
		System.out.println("Executed");
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		System.out.println("transaction begin");
		session.saveOrUpdate(user);
		System.out.println("open");
		session.getTransaction().commit();
	}
	public UserData findUserByEmail(String email)
	{
		Session session=sessionFactory.openSession();
		UserData u=null;
		try
		{
	     session.beginTransaction();
	     u=(UserData) session.get(UserData.class, email);
	     session.getTransaction().commit();
	    
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
	}
		return u;
	
	}

}
