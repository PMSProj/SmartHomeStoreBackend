package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrdersDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.Model.Cart;

@Configuration
@ComponentScan("com.*")
@EnableTransactionManagement
public class hiberConfig
{
  @Autowired
  @Bean(name="datasource")
  public DataSource getH2Data()
  {
	  DriverManagerDataSource dsource=new DriverManagerDataSource();
	  dsource.setDriverClassName("org.h2.Driver");
	  dsource.setUrl("jdbc:h2:tcp://localhost/~/smarthomestore");
	  dsource.setUsername("shs");
	  dsource.setPassword("shs");
	  System.out.println("H2 Connected");
	  return dsource;
  }
  private Properties getHiber()
  {
	  Properties p=new Properties();
	  p.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	  p.put("hibernate.hbm2ddl.auto", "update ");
	  p.put("hibernate.show_sql","true" );
	  System.out.println("Data table created in H2");
	  return p;
  }
  @Autowired
  @Bean(name="sessionFactory")
  public SessionFactory getSessionFactory(DataSource datasource)
  {
	 LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(datasource);
     lsfb.addProperties(getHiber());
	 lsfb.addAnnotatedClass(com.Model.UserData.class);
	 lsfb.addAnnotatedClass(com.Model.Supplier.class);
	 lsfb.addAnnotatedClass(com.Model.Category.class);
	 lsfb.addAnnotatedClass(com.Model.Product.class);
	 lsfb.addAnnotatedClass(com.Model.Orders.class);
	 lsfb.addAnnotatedClass(Cart.class);
	 return lsfb.buildSessionFactory();
  }
  @Autowired
  @Bean(name="userDaoImpl")
  public UserDaoImpl saveUserData(SessionFactory sessionfactory)
  {
	 return new UserDaoImpl(sessionfactory);
  }
  @Autowired
  @Bean(name="supplierDaoImpl")
  public SupplierDaoImpl saveSuppData(SessionFactory  sessionFactory)
  {
	  return new SupplierDaoImpl(sessionFactory);
  }
  @Autowired
  @Bean(name="categoryDaoImpl")
  public CategoryDaoImpl saveCatData(SessionFactory  sessionFactory)
  {
	  return new CategoryDaoImpl(sessionFactory);
  }
  @Autowired
  @Bean(name="productDaoImpl")
  public ProductDaoImpl saveProductData(SessionFactory sessionFactory)
  {
	  return new ProductDaoImpl(sessionFactory);
  }
  @Autowired
  @Bean(name="cartDaoImpl")
  public CartDaoImpl saveCartData(SessionFactory sessionFactory)
  {
	  return new CartDaoImpl(sessionFactory);
  }
  @Autowired
  @Bean(name="ordersDaoImpl")
  public OrdersDaoImpl saveOrdersData(SessionFactory sessionFactory)
  {
	  return new OrdersDaoImpl(sessionFactory);
  }
  @Autowired
  @Bean(name="transactionManager")
  public HibernateTransactionManager gettrans(SessionFactory sessionfactory)
  {
	  HibernateTransactionManager ht=new HibernateTransactionManager(sessionfactory);
	  return ht;
  }
}
