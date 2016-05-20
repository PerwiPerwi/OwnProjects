package controllers;

import java.util.List;

import models.Product;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Products extends Controller {

	private static final Form<Product> productForm = Form.form(Product.class);

	public static Result list() {
		List<Product> all = Product.findAll();
		return ok(list.render(all));
	}

	public static Result newProduct() {
		return null;
	}

	public static Result details(String ean) {
		Product product = Product.findByEan(ean);
		if (product == null) {
			return notFound(String.format("Product %s does not exist.", ean));
		}
		Form<Product> filledProduct = productForm.fill(product);
		return ok(details.render(filledProduct));

	}

	public static Result save() {
		return TODO;
	}

}
