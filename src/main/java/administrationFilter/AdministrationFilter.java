package administrationFilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The filter checks user name and user password from session object and if it is existed -
 forward request to AdministrationServlet(), and if they aren't - assign to them values from 
 request(from form) and forward request to AdministrationServlet(). If there are not such parameters in request - forward it to login.jsp
 */

public class AdministrationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdministrationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		httpResponse.setContentType("text/html;charset=UTF-8");
		HttpSession session = httpRequest.getSession();
		String userName = httpRequest.getParameter("userName");
		String userPassword = httpRequest.getParameter("userPassword");
		
		if (session.getAttribute("userName")!=null&&session.getAttribute("userPassword")!=null) {
			httpRequest.getRequestDispatcher("AdministrationServlet").forward(request, response);
		} else if (userName!=null&&userPassword!=null) {
			session.setAttribute("userName", userName);
			session.setAttribute("userPassword", userPassword);
			httpRequest.getRequestDispatcher("AdministrationServlet").forward(request, response);
		} else {
			response.getWriter().println("<script>alert('Требуется авторизация')</script");
			httpRequest.getRequestDispatcher("login.jsp").include(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
