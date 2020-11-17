package Server;

import Model.Check;
import Model.Checker;
import Model.Table;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] x = req.getParameterValues("x");
        String y = req.getParameter("y");
        String r = req.getParameter("r");
        String f = req.getParameter("f");
        if(validateF(f)) {
            boolean isInForm = f.toLowerCase().equals("true");
            if (validateX(x,isInForm) && validateY(y,isInForm) && validateR(r)) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/Table.jsp");
                double _y = Double.parseDouble(y);
                double _r = Double.parseDouble(r);
                for (String value : x) {
                    double _x = Double.parseDouble(value);
                    Check check = new Checker();
                    boolean result = check.checkDot(_x, _y, _r);
                    String res = result ? "Точка входит в область" : "Точка не входит в область";
                    Object bean = req.getSession().getAttribute("table");
                    if (bean != null)
                        ((Table) bean).setTable(value, y, r, res);
                    else {
                        Table table = new Table();
                        table.setTable(value, y, r, res);
                        req.getSession().setAttribute("table", table);
                    }
                }
                dispatcher.forward(req, resp);
            }
        }
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
    private boolean validateX(String[] x, Boolean isInForm){
        HashSet<Float> values = new HashSet<>(Arrays.asList(-2f,-1.5f,-1f,-0.5f,0f,0.5f,1f,1.5f,2f));
        if(x==null)
            return false;
        for(String value : x){
            try {
                float a = Float.parseFloat(value);
                if(isInForm)
                    return values.contains(a);
                else
                    return true;
            }
            catch (NumberFormatException e){
                return false;
            }
        }
        return false;
    }

    private boolean validateY(String y, Boolean isInForm){
        try{
            Double a = Double.parseDouble(y);
            if(isInForm)
                return a.compareTo(5.0)<0&&a.compareTo(-3.0)>0;
            else
                return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validateR(String r){
        HashSet<Float> values = new HashSet<>(Arrays.asList(1f,1.5f,2f,2.5f,3f));
        try{
            Float a = Float.parseFloat(r);
            return values.contains(a);
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    private boolean validateF(String f){
        return f.toLowerCase().equals("true")||f.toLowerCase().equals("false");
    }
}
