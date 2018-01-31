package com.Dao;
import java.util.List;

import com.Model.*;
public interface SupplierDao
{
 public void insertSupplier(Supplier supplier);
 public List<Supplier> retrieve();
 public Supplier findBySId(int sid);
 public void updateSupp(Supplier s);
 public void deleteSup(int sid);
}
