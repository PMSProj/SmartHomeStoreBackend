package com.Dao;

import java.util.List;

import com.Model.Product;

public interface ProductDao 
{
	public void insertProduct(Product product);
	public  List<Product> retrieve();
	public Product findByPId(int pId);


}
