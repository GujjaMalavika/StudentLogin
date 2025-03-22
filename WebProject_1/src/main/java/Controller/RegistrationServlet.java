package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import DAO.RegisterDao;
import bean.StudentBean;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//requesting the get method by using getparameter to intialize the variables from the encapsulation class.
		String Name=request.getParameter("Name");
		String Mobile_no=request.getParameter("Mobile_no");
		String Password=request.getParameter("Password");
		String Gmail=request.getParameter("Gmail");
		String Address=request.getParameter("Address");
		String Tech=request.getParameter("Tech");
		String College=request.getParameter("College");
		
		//as we have to use accross the project we are creating the object.
		
		StudentBean s=new StudentBean();
		//we are going to set values to all the attributes.
		
		s.setName(Name);
		s.setMobile_no(Mobile_no);
		s.setPassword(Password);
		s.setAddress(Address);
		s.setGmail(Gmail);
		s.setTech(Tech);
		s.setCollege(College);
		
		
		//it is class used to manage connection between the code and connection.
		RegisterDao rd=new RegisterDao();
		//to know(or)check data is inserted or not
		int result=rd.InsertData(s);//we will have value for result
		
		//result=0
		//http session
//		HttpSession session=request.getSession();//keeping the session open to get the request from the user.
//		session.setAttribute("StudentObject",s);
		
		//It is only used to send the respond to the user.TO inform and verify the data they entered.
		RequestDispatcher success=request.getRequestDispatcher("Success.html");//this is only used when we want to show details user entered ,that they registered and there data want they entered will  be shown on the screen
		RequestDispatcher Fail=request.getRequestDispatcher("Fail.html");
		
		
		if(result>0) {//if user entered data rows effected in table then result will be greater than 
			success.forward(request, response);
		}
		
		else {//no data is entered in the fronted by the user then result=0.
			Fail.forward(request, response);
		}

		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Name=request.getParameter("Name");
		
		StudentBean s=new StudentBean();
		s.setName(Name);
		
		RegisterDao rd=new RegisterDao();
		//to know(or)check data is inserted or not
		int result=rd.DeleteData(s);
		
		doGet(request, response);
		
		RequestDispatcher success=request.getRequestDispatcher("SuccessDelete.html");//this is only used when we want to show details user entered ,that they registered and there data want they entered will  be shown on the screen
		RequestDispatcher Fail=request.getRequestDispatcher("Fail.html");
		
		
		if(result>0) {//if user entered data rows effected in table then result will be greater than 
			success.forward(request, response);
		}
		
		else {//no data is entered in the fronted by the user then result=0.
			Fail.forward(request, response);
		}

	}

}
