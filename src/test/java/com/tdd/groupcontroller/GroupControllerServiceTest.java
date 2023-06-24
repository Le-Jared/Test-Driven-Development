package com.tdd.groupcontroller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GroupControllerServiceTest {

    @Mock
    private DatabaseReader databaseReader;

    @Mock
    private DatabaseWriter databaseWriter;

    private GroupControllerService groupControllerService;

    @BeforeEach
    public void setUp() {
        groupControllerService = new GroupControllerServiceImpl(databaseReader, databaseWriter);
    }

    @Test
    public void testGetAllTrainees() {
        Map<String, Trainee> expectedTrainees = new HashMap<>();
        when(databaseReader.readGroup()).thenReturn(expectedTrainees);

        Map<String, Trainee> actualTrainees = groupControllerService.getAllTrainees();

        assertEquals(expectedTrainees, actualTrainees);
        
        verify(databaseReader, times(1)).readGroup();
    }

    @Test
    public void testAddTrainee() {
        Trainee trainee = new Trainee();
        
        groupControllerService.addTrainee(trainee);

        verify(databaseWriter, times(1)).addTrainee(trainee);
    }

    @Test
    public void testRemoveTraineeByUsername() {
        String traineeUsername = "username";
        
        groupControllerService.removeTraineeByUsername(traineeUsername);

        verify(databaseWriter, times(1)).deleteTraineeByUsername(traineeUsername);
    }
    
    @Test
    public void testAddNullTrainee() {
        Trainee trainee = null;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            groupControllerService.addTrainee(trainee);
        });

        String expectedMessage = "Trainee cannot be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testRemoveTraineeByNullUsername() {
        String traineeUsername = null;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            groupControllerService.removeTraineeByUsername(traineeUsername);
        });

        String expectedMessage = "Username cannot be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
