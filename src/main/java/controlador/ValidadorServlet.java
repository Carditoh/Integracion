package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.LoginDao;

/**
 * Servlet implementation class ValidadorServlet
 */
public class ValidadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username, password, msg="";
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		try {
			if(LoginDao.validar(username,password)>0) {
				msg = LoginDao.describir(username, password);
			} else {
				msg = "usuario y/o contraseña incorrectos o vacios";
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		msg = msg.toUpperCase();
		
		RequestDispatcher despachador = request.getRequestDispatcher("/mensaje.jsp");
		
		request.setAttribute("mensaje", msg);
		
		despachador.forward(request, response);
	}

}
