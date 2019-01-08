package showProductsServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataBaseManager.DataBaseManager;
import product.Product;

/**
 * Servlet gets query parameters from request and gets list of products from database via
 * DataBaseManager object, sets the list as session attribute and send the refer to showproducts.jsp(it makes view from products list) to client
 * in iframe element.
 */

public class ShowProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Product product = createProduct(request);
		
		try {
			ArrayList<Product> list = new DataBaseManager().getProducts(product);
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("<iframe id='ifr' src='"+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/your-shop/showProducts.jsp' onload='resizeFrame(this)' scrolling='no' frameborder='no'/>");
	}
	
	//create Product object from request parameters
	private Product createProduct(HttpServletRequest request) {
		Product prod = new Product();
		prod.setName(request.getParameter("name"));
		prod.setBrand(request.getParameter("brand"));
		prod.setColor(request.getParameter("color"));
		prod.setDescription(request.getParameter("description"));
		if (request.getParameter("minPrice")!=null&&!request.getParameter("minPrice").isEmpty()) prod.setMinPrice(Double.parseDouble(request.getParameter("minPrice")));
		if (request.getParameter("maxPrice")!=null&&!request.getParameter("maxPrice").isEmpty())prod.setMaxPrice(Double.parseDouble(request.getParameter("maxPrice")));
		return prod;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
