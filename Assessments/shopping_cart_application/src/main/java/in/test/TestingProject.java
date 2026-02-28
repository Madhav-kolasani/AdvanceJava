package in.test;

import java.util.List;

import in.cg.entities.*;
import in.cg.services.*;

public class TestingProject {

	@Test
	public void testGetAllProducts() {
		ProductService productService = new ProductService();
		List<Product> products = productService.getAllProducts();
		assertEquals(3, products.size());
	}

	@Test
	public void testGetProductById() {
		ProductService productService = new ProductService();
		Product product = productService.getProductById(99);
		assertNull(product);
	}

}