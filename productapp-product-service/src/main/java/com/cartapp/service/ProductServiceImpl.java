package com.cartapp.service;

import com.cartapp.exception.ProductNotFoundException;
import com.cartapp.model.Product;
import com.cartapp.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {

	 private IProductRepository productRepository;

	    @Autowired
	    public void setProductRepository(IProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }


	    @Override
	    public void addProduct(Product product) {
	        productRepository.save(product);
	    }

	    @Override
	    public void updateProduct(Product product) {
	        productRepository.save(product);
	    }

	    @Override
	    public void deleteProduct(int productId) {
	        productRepository.deleteById(productId);
	    }

	    @Override
	    public List<Product> getAll() {
	        return productRepository.findAll();
	    }

	    @Override
	    public Product getById(int productId){
	        return productRepository.findById(productId).get();//orElseThrow(() -> new ProductNotFoundException("Invalid Id"));
	    }

	    @Override
	    public List<Product> getByBrand(String brand) throws ProductNotFoundException {
	        return productRepository.getByBrand(brand);
	    }

	    @Override
	    public List<Product> getByLesserPrice(double price) throws ProductNotFoundException {
	        return productRepository.readByPriceLessThan(price);
	    }

	    @Override
	    public List<Product> getByBrandStarting(String brand) throws ProductNotFoundException {
			System.out.println(brand);
			return productRepository.getByBrandStartingWith("%"+brand+"%");
	    }


		@Override
		public List<Product> getByCategory(String category) throws ProductNotFoundException {
			// TODO Auto-generated method stub
			return productRepository.findByCategory(category);
		}


		@Override
		public List<Product> getByChoice(String choice){
			// TODO Auto-generated method stub
			return productRepository.findByChoice(choice);
		}
		

	   
	   
//
//	   
//
//	    @Override
//	    public List<Product> getByBrandName(String brand, String name) {
//	        return productRepository.findByBrandName(brand, name);
//	    }
//
//	    @Override
//	    public List<Product> findByBetweenPrice(double minPrice, double maxPrice) {
//	        return productRepository.findByBetweenPrice(minPrice, maxPrice);
//	    }
//
//	    @Override
//	    @Transactional
//	    public void updateProductCost(int productId, double price) {
//	        productRepository.updateProductCost(productId, price);
//	    }
//
//	    @Override
//	    public List<Product> getByNewBrands(String brand) {
//	        return productRepository.getByNewBrands(brand);
//	    }
//
//	    @Override
//	    public List<Product> getByNewBrandshow(String brand, double cost) {
//	        return productRepository.getByNewBrandshow(brand,cost);
//	    }
//
//
//		@Override
//		public List<Product> getByCategory(String category) throws ProductNotFoundException {
//			// TODO Auto-generated method stub
//			return productRepository.findByCategory(category);
//		}
//
//
//		@Override
//		public List<Product> getByCatBrand(String category, String brand) {
//			// TODO Auto-generated method stub
//			return productRepository.findByCatBrand(category, brand);
//		}

}
