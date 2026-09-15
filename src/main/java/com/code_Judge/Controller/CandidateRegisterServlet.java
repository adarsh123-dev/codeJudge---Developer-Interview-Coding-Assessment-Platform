package com.code_Judge.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.code_Judge.model.Candidate;
import com.code_Judge.Service.CandidateService;

@WebServlet("/candidateRegister")
public class CandidateRegisterServlet extends HttpServlet {

    private CandidateService candidateService;

    @Override
    public void init() {
        candidateService = new CandidateService();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Get data from HTML form
    	
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create Candidate object
        Candidate candidate =
                new Candidate(0, name, email, password);

        // Send candidate to service layer
        boolean result =
                candidateService.registerCandidate(candidate);

        // Response
        response.setContentType("text/html");


        PrintWriter out = response.getWriter();

        if (result) {

            out.println("<h2>Candidate Registered Successfully!</h2>");
            out.println("<a href='candidate-login.html'>Login Now</a>");

        } else {

            out.println("<h2>Registration Failed!</h2>");
            out.println("<a href='candidate-register.html'>Try Again</a>");
        }
    }
}
