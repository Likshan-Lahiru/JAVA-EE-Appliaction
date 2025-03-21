package log.spring.firstapplication;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;

@WebServlet(name = "Customer", value = "/customerController")
public class CustomerController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Calling the doGet method");


        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("id", 1);
        jsonResponse.put("name", "John Doe");
        jsonResponse.put("email", "john.doe@example.com");

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Calling the doPost method");

        String name = request.getParameter("name");
        String email = request.getParameter("email");


        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("message", "Customer added successfully");
        jsonResponse.put("name", name);
        jsonResponse.put("email", email);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();
    }
}
