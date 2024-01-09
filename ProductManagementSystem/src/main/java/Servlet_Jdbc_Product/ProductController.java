package Servlet_Jdbc_Product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String brand = req.getParameter("brand");
		double price = Double.parseDouble(req.getParameter("price"));
		String manufacturer = req.getParameter("manufacturer");
		String state = req.getParameter("state");

		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setBrand(brand);
		product.setManufacturer(manufacturer);
		product.setState(state);
		if (state.equals("KAR")) {
			ServletContext context = getServletContext();
			double CGST = Double.parseDouble(context.getInitParameter("CGST"));
			ServletConfig config = getServletConfig();
			double SGST = Double.parseDouble(config.getInitParameter("KAR"));

			double totalprice = price + (CGST + SGST) * price;
			product.setPrice(totalprice);
		} else {
			ServletContext context = getServletContext();
			double CGST = Double.parseDouble(context.getInitParameter("CGST"));
			ServletConfig config = getServletConfig();
			double SGST = Double.parseDouble(config.getInitParameter("MAH"));

			double totalprice = price + (CGST + SGST) * price;
			product.setPrice(totalprice);
		}
		ProductCRUD crud = new ProductCRUD();

		PrintWriter printWriter = resp.getWriter();

		try {
			int result = crud.saveProduct(product);
			if (result != 0) {
				printWriter.print("Product Added SuccessFully");
			} else {
				printWriter.print("Failed To Add Product");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
