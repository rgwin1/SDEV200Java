package exercise37;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import exercise37.Loan; 


@WebServlet(name = "calculateLoan", urlPatterns = {"/calculateLoan"})
public class Exercise37 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        //get values from form
        String loanAmountStr = req.getParameter("loanamount");
        String interestRateStr = req.getParameter("interestrate");
        String numYearsStr = req.getParameter("numyears");
        
        //convert String type to double
        double loanAmount = Double.parseDouble(loanAmountStr);
        double interestRate = Double.parseDouble(interestRateStr);
        int numYears = Integer.parseInt(numYearsStr);
        
        //do loan calculations
        Loan loan = new Loan(interestRate, numYears, loanAmount);
        Double loanTotalPayment = loan.getTotalPayment();
        Double monthlyPayment = loan.getMonthlyPayment();
        
        //out HTML?
        out.println("<p> Loan Amount: " + loanAmountStr);
        out.println("<br>Annual Interest Rate:" + interestRateStr);
        out.println("<br>Number of Years: " + numYearsStr);
        out.println("<br>Monthly Payment: " + monthlyPayment);
        out.println("<br>Total Payment: " + loanTotalPayment);
        
        out.close();
          
    } 
}