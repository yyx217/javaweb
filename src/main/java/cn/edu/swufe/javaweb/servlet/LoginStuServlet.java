package cn.edu.swufe.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.swufe.javaweb.dao.Stu_dao_for_login;
import cn.edu.swufe.javaweb.entity.Stu_for_login;

/**
 * Servlet implementation class LoginStuServlet
 */
@WebServlet("/loginStu")
public class LoginStuServlet extends HttpServlet {
	private Stu_dao_for_login  studao = new Stu_dao_for_login();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginStuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	req.getRequestDispatcher("login.html").forward(req, resp);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer username = Integer.parseInt(request.getParameter("username"));
		String password = request.getParameter("password");
		
		Stu_for_login stu = studao.findStuByStudent_number(username);
		System.out.println(stu.getStudent_password());
		System.out.println(stu.getStudent_password().equals(password));
		if(null !=stu && stu.getStudent_password().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("student", stu);
			System.out.println("账号密码正确");
			//跳转到主页！！！！未改动
			response.sendRedirect("DBtest.jsp");
			
		}else {
			request.setAttribute("msg", "您的账号密码错误");
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

	

}
