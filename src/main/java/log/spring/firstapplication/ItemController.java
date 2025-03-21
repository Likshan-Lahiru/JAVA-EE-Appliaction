package log.spring.firstapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;

@WebServlet(name = "Item", value = "/itemController")
public class ItemController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Calling the doGet method");


        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("id", 101);
        jsonResponse.put("itemName", "Laptop");
        jsonResponse.put("price", 1200.99);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Calling the doPost method");

        String itemName = request.getParameter("itemName");
        String price = request.getParameter("price");


        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("message", "Item added successfully");
        jsonResponse.put("itemName", itemName);
        jsonResponse.put("price", price);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();
    }
}
