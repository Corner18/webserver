import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FriendsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        String id = request.getParameter("id");
        if (id != null && !"".equals(id)) {
            for (Subscription subscription : Subscription.getInstance().getArraySubscriptions()) {
                if (id.equals(subscription.getFolowing())) {
                    for (Subscription subscription1: Subscription.getInstance().getArraySubscriptions()){
                        if(subscription.getFolowed().equals(subscription1.getFolowing())){
                            if(subscription1.getFolowed().equals(subscription.getFolowing())){
                                for (User user: User.getInstance().getArrayUsers()){
                                    if(subscription.getFolowed().equals(user.getId())){
                                        pw.println("Name: " + user.getName()  +
                                                "Surname: " + user.getSurname()  +
                                                "City: " + user.getCity());
                                    }
                                }
                            }

                        }
                    }
                }
            }
        } else {
            pw.println("Hello anonymous");
        }

    }
}

