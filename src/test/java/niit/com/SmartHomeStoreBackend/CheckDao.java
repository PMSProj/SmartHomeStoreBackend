package niit.com.SmartHomeStoreBackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.DaoImpl.SupplierDaoImpl;
import com.Model.Supplier;

public class CheckDao
{
	@Autowired static AnnotationConfigApplicationContext  context;
	static SupplierDaoImpl suppDao;
	
	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.*");
		context.refresh();
		suppDao =(SupplierDaoImpl) context.getBean("supplierDaoImpl");
	}
	@Test
	public void suppTest()
	{
		Supplier ss=new Supplier();
		ss.setSid(111);
		ss.setsName("Test Supplier");
		suppDao.insertSupplier(ss);
		assertEquals(ss.getSid(),ss.getSid());
	}

}
 