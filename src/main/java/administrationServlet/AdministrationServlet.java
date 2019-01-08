package administrationServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataBaseManager.DataBaseManager;
import product.Product;

/**
 *This servlet performs authorization of user. If the user does not exist - the servlet forward to login.jsp and reset session parameters name and password, else
 *forward to administration.jsp
 */
public class AdministrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String userPassword = (String) session.getAttribute("userPassword");
		
		if (userName.equals("admin")&&userPassword.equals("admin")) {
			request.getRequestDispatcher("administration.jsp").forward(request, response);
		} else {
			session.invalidate();
			response.getWriter().println("<script>alert('Неверный логин или пароль')</script");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
