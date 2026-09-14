package com.code_Judge.model;

public class Candidate {

    private int candidateId;
    private String name;
    private String email;
    private String password;

    // Default Constructor
    public Candidate() {
    }

    // Parameterized Constructor
    public Candidate(int candidateId, String name, String email, String password) {
        this.candidateId = candidateId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateId=" + candidateId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
