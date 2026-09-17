package com.code_Judge.Dao;

import com.code_Judge.model.Candidate;

public class CandidateDAOTest {

    public static void main(String[] args) {

        Candidate candidate = new Candidate(
                0,
                "Adarsh",
                "adarsh123@gmail.com",
                "12345"
        );

        CandidateDAO candidateDAO = new CandidateDAO();

        boolean result = candidateDAO.registerCandidate(candidate);

        if (result) {
            System.out.println("Candidate Registered Successfully");
        } else {
            System.out.println("Candidate Registration Failed");
        }
    }
}
