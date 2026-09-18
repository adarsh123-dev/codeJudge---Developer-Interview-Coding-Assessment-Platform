package com.code_Judge.Service;

import com.code_Judge.Dao.CandidateDAO;
import com.code_Judge.model.Candidate;



public class CandidateService {

    private CandidateDAO candidateDAO;

    public CandidateService() {
        candidateDAO = new CandidateDAO();
    }

    public boolean registerCandidate(Candidate candidate) {

        if (candidate == null) {
            return false;
        }

        if (candidate.getName() == null ||
            candidate.getName().trim().isEmpty()) {
            return false;
        }

        if (candidate.getEmail() == null ||
            candidate.getEmail().trim().isEmpty()) {
            return false;
        }

        if (candidate.getPassword() == null ||
            candidate.getPassword().trim().isEmpty()) {
            return false;
        }

        return candidateDAO.registerCandidate(candidate);
    }
    
    
    public Candidate loginCandidate(String email, String password) {

        if (email == null || email.trim().isEmpty()) {
            return null;
        }

        if (password == null || password.trim().isEmpty()) {
            return null;
        }

        return candidateDAO.loginCandidate(email, password);
    }
}
