import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("current_user");
        if (user != null) {
            response.sendRedirect("/im");
        } else {
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            //String id = "1";
            //String password = "nastya";
            if (id != null && !"".equals(id) && password != null && !"".equals(password)) {
                String dbPassword = "dthbr";
                String dbUsername = "postgres";
                String dbUrl = "jdbc:postgresql://localhost:5432/postgres";



                try {
                    Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT login FROM users where id="+id+" and password='"+password+"';");
                    if (resultSet!= null){
                        session.setAttribute("current_user", resultSet);
                        response.sendRedirect("/im"); //переходим в свой профиль

                    } else {
                        response.sendRedirect("/login");
                    }


                } catch (SQLException e) {
                    throw new IllegalStateException(e);
                }



        }
    }
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("current_user");
        if (user != null) {
            response.sendRedirect("/im");
        } else {
            PrintWriter pw = response.getWriter();
            pw.println("<html>" +
                    "<body>" +
                    "<form action=\"login\">" +
                    "<input name=\"id\" type=\"text\">" +
                    "<input name=\"password\" type=\"text\">" +
                    "<input name =\"enter id and password\" type=\"submit\">" +
                    "</form>" +
                    "</body>" +
                    "</html>");
        }


        doPost(request,response);
    }


}



