package cn.edu.swufe.javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.swufe.javaweb.dao.Admin_dao_for_login;
import cn.edu.swufe.javaweb.entity.Admin_for_login;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet("/loginAdmin")
public class LoginAdminServlet extends HttpServlet {
	private Admin_dao_for_login admindao = new Admin_dao_for_login();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer username = Integer.parseInt(request.getParameter("username"));
		String password = request.getParameter("password");
		
		Admin_for_login admin = admindao.findAdminByAd_id(username);
		if(null != admin && admin.getAd_password().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			response.sendRedirect("DBtest.jsp");
		}else {
			request.setAttribute("msg", "您的账号密码输入错误");
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

}
