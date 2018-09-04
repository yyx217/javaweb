package cn.edu.swufe.javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.swufe.javaweb.dao.Qy_dao_for_login;
import cn.edu.swufe.javaweb.entity.Qy_for_login;

/**
 * Servlet implementation class LoginQyServlet
 */
@WebServlet("/loginQy")
public class LoginQyServlet extends HttpServlet {
	private Qy_dao_for_login qydao = new Qy_dao_for_login();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginQyServlet() {
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
		
		Qy_for_login qy = qydao.findQyByCompany_number(username);
		if(null !=qy && "1".equals(qy.getCompany_status())) {
			//通过审核
			if(qy.getCompany_password().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("company", qy);
				response.sendRedirect("DBtest.jsp");
			}else {
				request.setAttribute("msg", "您的账号密码错误");
				request.getRequestDispatcher("login.html").forward(request, response);
			}
		}else {
			//未通过审核
			request.setAttribute("msg", "您的账号不存在或未通过审核");
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

}
