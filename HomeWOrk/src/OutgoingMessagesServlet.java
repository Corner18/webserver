import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OutgoingMessagesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        String id = request.getParameter("id");
        if (id != null && !"".equals(id)) {
            for(Message message: Message.getInstance().getArrayMessage()){
                if(id.equals(message.getSender())){
                    for(User user: User.getInstance().getArrayUsers()){
                        if(message.getRecipient().equals(user.getId())){
                            pw.println("Recipient: " + user.getName() +
                                    " " + user.getSurname() + " " +
                                    "Message: " + message.getMessage());
                        }
                    }

                }
            }
        } else {
            pw.println("Hello anonymous");
        }

    }
}
