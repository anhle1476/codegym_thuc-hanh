package com.example.calculator;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        float firstOperand = Integer.parseInt(request.getParameter("first-operand"));
        float secondOperand = Integer.parseInt(request.getParameter("second-operand"));
        char operator = request.getParameter("operator").charAt(0);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result:</h1>");
        try{
            float result = Calculator.calculate(firstOperand, secondOperand, operator);
            writer.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
        }catch (Exception ex){
            writer.println("Error: " + ex.getMessage());
        }
        writer.println("</html>");
    }
}