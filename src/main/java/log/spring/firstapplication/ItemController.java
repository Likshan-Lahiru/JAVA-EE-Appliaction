package log.spring.firstapplication;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/itemController")
public class ItemController extends HttpServlet {
    private static final Map<Integer, String> items = new HashMap<>();
    private static int itemCounter = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.getWriter().write("Items: " + items.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String itemName = request.getParameter("itemName");
        if (itemName != null) {
            items.put(itemCounter++, itemName);
            response.getWriter().write("Item added: " + itemName);
        } else {
            response.getWriter().write("Error: Item name is required!");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String itemName = request.getParameter("itemName");
        if (items.containsKey(id)) {
            items.put(id, itemName);
            response.getWriter().write("Item updated: " + itemName);
        } else {
            response.getWriter().write("Item not found!");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (items.remove(id) != null) {
            response.getWriter().write("Item deleted: " + id);
        } else {
            response.getWriter().write("Item not found!");
        }
    }
}
