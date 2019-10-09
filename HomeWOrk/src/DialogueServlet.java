import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DialogueServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        String id1 = request.getParameter("id1");
        String id2 = request.getParameter("id2");
        if (id1 != null && !"".equals(id1) && id2 != null && !"".equals(id2)) {
            for (Message message : Message.getInstance().getArrayMessage()) {
                if ((id1.equals(message.getSender())) && (id2.equals(message.getRecipient()))) {
                    for (User user : User.getInstance().getArrayUsers()) {
                        if (message.getSender().equals(user.getId())) {
                            pw.println("Sender: " + user.getName() +
                                    " " + user.getSurname() + " " +
                                    "Message: " + message.getMessage());
                        }
                    }
                } else if ((id2.equals(message.getSender())) && (id1.equals(message.getRecipient()))) {
                    for (User user : User.getInstance().getArrayUsers()) {
                        if (message.getSender().equals(user.getId())) {
                            pw.println("Sender: " + user.getName() +
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
