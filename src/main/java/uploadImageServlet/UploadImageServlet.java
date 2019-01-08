package uploadImageServlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;
import dataBaseManager.DataBaseManager;
import product.Product;

/**
  Servlet for getting product data (descriptions, images) saving in data base , saving image in file system
 */

@MultipartConfig
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int ind=0;
		try {
			Product product = createProduct(request);
			ind = new DataBaseManager().insertProduct(product);//save product in database and get id in database
			saveImage(ind, request);//save image with name ind - unique id product in database
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Ошибка на стороне сервера. Товар не внесен в базу данных. Попробуйте еще раз.");
		}
		response.getWriter().println("Товар загружен в базу данных.");		
	}
	
	//create new Product object via retrieve parameters from request
	private Product createProduct(HttpServletRequest request) throws Exception {
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		String color = request.getParameter("color");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		return new Product(name, brand, color,description, price);
	}
	
	//save image with using index product in database, that returns DataBaseManger
	private void saveImage(int ind, HttpServletRequest request) throws Exception {
		String appPath = request.getServletContext().getRealPath("");
		String saveDir = appPath+File.separator+"images";
		File savePath = new File(saveDir);
		
		if (!savePath.exists()) {
			savePath.mkdirs();
		}
		
		for (Part part : request.getParts()) {
			String file = getFilePart(part);
			if (file!=null&&!file.isEmpty()) {
				part.write(saveDir+File.separator+ind+file.substring(file.lastIndexOf(".")));
			}
		}
		
	}
	
	//It is help method for saveImage()
	String getFilePart (Part part) {
		String header = part.getHeader("content-disposition");
		String[] items = header.split(";");
		for (String item : items ) {
			if (item.trim().startsWith("filename")) {
				return item.substring(item.indexOf("=")+2,item.length()-1);
			}
		}
		return null;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
