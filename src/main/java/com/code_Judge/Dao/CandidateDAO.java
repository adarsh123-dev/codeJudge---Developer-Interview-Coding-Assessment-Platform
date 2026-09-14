package com.code_Judge.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.code_Judge.connection.MyJdbcConnection;
import com.code_Judge.model.Candidate;



public class CandidateDAO {

    private static final String INSERT_CANDIDATE ="INSERT INTO candidate(name, email, password) VALUES (?, ?, ?)";

    public boolean registerCandidate(Candidate candidate) {

        boolean status = false;

        try {
            Connection connection =
                    MyJdbcConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(INSERT_CANDIDATE);

            preparedStatement.setString(1, candidate.getName());
            preparedStatement.setString(2, candidate.getEmail());
            preparedStatement.setString(3, candidate.getPassword());

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                status = true;
            }

            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
