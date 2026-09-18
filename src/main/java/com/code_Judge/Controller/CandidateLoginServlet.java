package com.code_Judge.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.code_Judge.model.Candidate;
import com.code_Judge.Service.CandidateService;

@WebServlet(value ="/candidateLogin")
public class CandidateLoginServlet extends HttpServlet {

    private CandidateService candidateService;

    @Override
    public void init() {

        candidateService = new CandidateService();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Get login data from HTML form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Call Service
        Candidate candidate =
                candidateService.loginCandidate(email, password);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        if (candidate != null) {

            out.println("<h2>Login Successful!</h2>");

            out.println("<h3>Welcome, "
                    + candidate.getName()
                    + "</h3>");

            out.println("<p>Email: "
                    + candidate.getEmail()
                    + "</p>");

            out.println("<br>");

            out.println("<a href='candidate-dashboard.html'>");
            out.println("Go to Dashboard");
            out.println("</a>");

        } else {

            out.println("<h2>Invalid Email or Password</h2>");

            out.println("<a href='candidate-login.html'>");
            out.println("Try Again");
            out.println("</a>");
        }
    }
}
