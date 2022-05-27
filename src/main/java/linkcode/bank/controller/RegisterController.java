package linkcode.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import linkcode.bank.dao.AccountDao;
import linkcode.bank.model.Account;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Account accobj=new Account();
		accobj.setAccno(Integer.parseInt(request.getParameter("accno")));
		accobj.setCname(request.getParameter("cname"));
		accobj.setUname(request.getParameter("uname"));
		accobj.setPass(request.getParameter("pass"));
		accobj.setAccBall(Integer.parseInt(request.getParameter("accBal")));
		
		AccountDao adao= new AccountDao();
		int i=adao.savedata(accobj);
		if(i>0)
		{
			PrintWriter pw=response.getWriter();
			pw.print("Record Inserted");
			response.sendRedirect("LoginView.jsp");
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
