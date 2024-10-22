package com.scp.test.cart;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.scp.model.Product;
import com.scp.model.ShoppingCart;
import org.junit.jupiter.api.Assertions;

public class ShoppingCartTest {

	ShoppingCart cart = new ShoppingCart();

	@Test
	public void addProductTest() {
		Product product = new Product(101, "Pen", 10);
		cart.addProduct(product);
	}

	@Test
	public void removeProductTest1() {
		Product product = new Product(101, "Pen", 10);
		cart.addProduct(product);
		boolean result = cart.removeProduct(product);
		Assertions.assertTrue(result);
	}

	@Test
	public void removeProductTest2() {
		Product product = new Product();
		cart.addProduct(null);
		boolean result = cart.removeProduct(product);
		Assertions.assertFalse(result);
	}

	@Test
	public void removeProductTest3() {
		cart.addProduct(null);
		boolean result = cart.removeProduct(null);
		Assertions.assertTrue(result);
	}

	@Test
	public void removeProduct4() {
		Product product = new Product(101, "Pen", 10);
		NullPointerException ex = assertThrows(NullPointerException.class, () -> cart.removeProduct(product));
		String actualmsg = ex.getMessage();
		String expectedmsg = "cart is empty";
		Assertions.assertTrue(actualmsg.contains(expectedmsg));
	}

	@Test
	public void showAllProductTest() {
		Product product1 = new Product(101, "Pen", 10);
		cart.addProduct(product1);
		Product product2 = new Product(102, "Pencil", 20);
		cart.addProduct(product2);
		List<Product> productList = cart.getAllProduct();
		Assertions.assertEquals(2, productList.size());

	}
	
	@Test
	public void calculateTotalPriceEmptyCart() throws NullPointerException{
		NullPointerException ex = assertThrows(NullPointerException.class, () -> cart.calculateTotalPrice());
		String actualmsg = ex.getMessage();
		String expectedmsg = "cart is empty";
		Assertions.assertTrue(actualmsg.contains(expectedmsg));
		
	}
	
	@Test
	public void calculateTotalNonPriceEmptyCart() {
		Product product1 = new Product(101, "Pen", 10);
		cart.addProduct(product1);
		Product product2 = new Product(102, "Pencil", 20);
		cart.addProduct(product2);
		int totPrice = cart.calculateTotalPrice();
		Assertions.assertEquals(30, totPrice);
	}
	
}
