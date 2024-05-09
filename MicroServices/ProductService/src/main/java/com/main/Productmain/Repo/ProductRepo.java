package com.main.Productmain.Repo;

import com.main.Productmain.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {

    public List<Product> findAll();
    public Product findById(long id);

}
