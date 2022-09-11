package com.cartapp.repository;

import com.cartapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    //derived queries can startwith findBy, readBy, getBy
    List<Product> findByCategory(String category);
    List<Product> getByBrand(String brand);
    @Query("from Product p where p.brand like ?1")
    List<Product> getByBrandStartingWith(String brand);
    List<Product> readByPriceLessThan(double price);


    @Query("from Product p where p.category = ?1 or p.brand= ?1")
    List<Product> findByChoice(String choice);



}
