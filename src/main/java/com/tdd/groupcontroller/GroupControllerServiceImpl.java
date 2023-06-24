package com.tdd.groupcontroller;

import java.util.Map;

public class GroupControllerServiceImpl implements GroupControllerService {
    private final DatabaseReader databaseReader;
    private final DatabaseWriter databaseWriter;

    public GroupControllerServiceImpl(DatabaseReader databaseReader, DatabaseWriter databaseWriter) {
        this.databaseReader = databaseReader;
        this.databaseWriter = databaseWriter;
    }

    @Override
    public Map<String, Trainee> getAllTrainees() {
        return databaseReader.readGroup();
    }

    @Override
    public void addTrainee(Trainee trainee) {
        if(trainee == null) {
            throw new IllegalArgumentException("Trainee cannot be null");
        }
        databaseWriter.addTrainee(trainee);
    }

    @Override
    public void removeTraineeByUsername(String traineeUsername) {
        if(traineeUsername == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
        databaseWriter.deleteTraineeByUsername(traineeUsername);
    }
}
