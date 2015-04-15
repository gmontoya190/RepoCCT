package web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import operations.Notification;
import data.model.User;
import persistence.ConexionDB;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConexionDB conexionDB = new ConexionDB();   
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("ENTRO al SERVLET DE USUARIOS");
		HttpSession session = request.getSession(false);
		
		String action=request.getParameter("action");
		
		String actionModifyUser=request.getParameter("action");
		System.out.println(actionModifyUser);
		response.setContentType("text/html; charset=utf-8");	
		
		 String usu[] = new String[7];
		usu=request.getParameterValues("evec[]");
	
		
		String nombreUsuario=usu[0];
		System.out.println("ELNOMBRE= "+nombreUsuario);
		String emailUsuario=usu[1];
		String sexoUsuario= usu[2];
		String IdProceso=usu[3];
		String esLider=usu[4];		
		String contraseña=usu[5];
		
		User newUser= new User();
		newUser.setName(nombreUsuario);
		newUser.setEmail(emailUsuario);
		newUser.setSex(sexoUsuario);;
		newUser.setIdProcess(IdProceso);
		newUser.setPassword(contraseña);
		newUser.setProcessLead(esLider);
		
		if (action!=null && "creoUsuario".equals(action)) {
		if(conexionDB.connect()!=null) {
			conexionDB.createUsers(newUser);
			System.out.println("SE CREO UN NUEVO USUARIO");
			Notification noti= new Notification();
			noti.sendEmail(newUser.getEmail(),"Se ha creado lider para el proceso "+newUser.getIdProcess()+" ingrese con "
					+ "su cuenta email como usuario y con la siguiente contraseña "+newUser.getPassword()+" ,por seguridad se le aconseja cambiar la contraseña");
			
			//request.getServletContext().getRequestDispatcher("/WelPageLead.jsp").forward(request, response);
			request.getRequestDispatcher("WelPageLead.jsp").forward(request, response);
		}
		
		}
		if (actionModifyUser!=null && "modificoUsuario".equals(actionModifyUser)) {
			if(conexionDB.connect()!=null) {
				System.out.println("SE MODIFICO UN USUARIO");
				conexionDB.ModifyUser(newUser);
			
				
				request.getServletContext().getRequestDispatcher("/WelPageLead.jsp").forward(request, response);
				//request.getRequestDispatcher("WelPageLead.jsp").forward(request, response);
			}
			
			}
	}

}
