package com.example.product_discount_calculator;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "displayDiscountServlet", value = "/display-discount")
public class DisplayDiscountServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String description = request.getParameter("desc");
        float price = Float.parseFloat(request.getParameter("price"));
        float discount = Float.parseFloat(request.getParameter("discount"));

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Result:</h1>");
        out.println("<p> description: " + description + "</p>" );
        out.println("<p> price: " + price + "</p>" );
        out.println("<p> discount: " + discount + "</p>" );
        out.println("<hr/>");
        out.println("<p> total: " + (price * ((100 - discount) / 100)) + "</p>" );
        out.println("</body></html>");
    }

}