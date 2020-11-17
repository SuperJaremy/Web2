package Server;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        boolean toCheck = request.getParameter("x")!=null&request.getParameter("y")!=null&&
                request.getParameter("r")!=null;
        RequestDispatcher dispatcher;
        if(toCheck) {
            dispatcher = request.getRequestDispatcher("check");
        }
        else{
            dispatcher = request.getRequestDispatcher("/index.jsp");
        }
        dispatcher.forward(request, response);
    }
}
