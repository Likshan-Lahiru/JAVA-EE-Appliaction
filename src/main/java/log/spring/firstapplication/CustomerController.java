package log.spring.firstapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/customerController")
public class CustomerController extends HttpServlet {
    private static final Map<Integer, String> customers = new HashMap<>();
    private static int idCounter = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.getWriter().write("Customers: " + customers.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        if (name != null) {
            customers.put(idCounter++, name);
            response.getWriter().write("Customer added: " + name);
        } else {
            response.getWriter().write("Error: Name is required!");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        if (customers.containsKey(id)) {
            customers.put(id, name);
            response.getWriter().write("Customer updated: " + name);
        } else {
            response.getWriter().write("Customer not found!");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (customers.remove(id) != null) {
            response.getWriter().write("Customer deleted: " + id);
        } else {
            response.getWriter().write("Customer not found!");
        }
    }
}
