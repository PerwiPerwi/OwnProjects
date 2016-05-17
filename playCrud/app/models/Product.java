package models;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private static List<Product> products;

	static {
		products = new ArrayList<Product>();
		products.add(new Product("1111111111111", "Paperclips 1", "Paperclips description 1"));
		products.add(new Product("2222222222222", "Paperclips 2", "Paperclips description "));
		products.add(new Product("3333333333333", "Paperclips 3", "Paperclips description 3"));
		products.add(new Product("4444444444444", "Paperclips 4", "Paperclips description 4"));
		products.add(new Product("5555555555555", "Paperclips 5", "Paperclips description 5"));
	}

	public String ean;
	public String name;
	public String description;

	public Product() {
	}

	public Product(String ean, String name, String description) {
		this.ean = ean;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("%s - %s", ean, name);
	}


	public static List<Product> findAll() {
		return products;
	}

	public static Product findByEan(String ean) {
		   for (Product product : products) {
			if(product.ean.equals(ean)){
				return product;
			}
		   }
		return null;
		}

	public static boolean remove(Product product) {
		return  products.remove(product);
	}

	public void save() {
		products.remove(findByEan(this.ean));
		products.add(this);
		// products. <-- usuniecie z kolekcji
		// products. <-- dodanie do kolekcji
		// UWAGA: metoda jest instancyjna
		// HINT: skorzystac z this
	}
}
