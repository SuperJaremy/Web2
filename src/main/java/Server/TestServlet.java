package Server;

import Model.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Test test = new Test();
        test.setName("John");
        test.setEmployed(true);
        req.getSession().setAttribute("test",test);
        RequestDispatcher rd = req.getRequestDispatcher("/test.jsp");
        rd.forward(req,resp);
    }
}
