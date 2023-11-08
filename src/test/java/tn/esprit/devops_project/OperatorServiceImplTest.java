package tn.esprit.devops_project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.OperatorServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {OperatorServiceImpl.class})
@ExtendWith(MockitoExtension.class)
public class OperatorServiceImplTest {

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @Mock
    private OperatorRepository operatorRepository; // Assurez-vous d'utiliser le bon repository ici

    @Test
    void testAddOperator() {
        // Mocking
        Operator operator = new Operator();
        when(operatorRepository.save(operator)).thenReturn(operator);

        // Test
        Operator result = operatorService.addOperator(operator);

        // Assertions
        assertEquals(operator, result);

        // Vérification que la méthode save a été appelée avec le bon argument
        verify(operatorRepository).save(operator);
    }

    @Test
    void testRetrieveAllOperators() {
        // Mocking
        List<Operator> operatorList = new ArrayList<>();
        when(operatorRepository.findAll()).thenReturn(operatorList);

        // Test
        List<Operator> result = operatorService.retrieveAllOperators();

        assertSame(operatorList, result);
        assertTrue(result.isEmpty());

        verify(operatorRepository).findAll();
    }

    @Test
    void testRetrieveOperator() {
        // Mocking
        Long operatorId = 1L; // Remplacez 1L par l'ID de l'opérateur que vous souhaitez tester
        Operator mockOperator = new Operator();
        when(operatorRepository.findById(operatorId)).thenReturn(Optional.of(mockOperator));

        // Test
        Operator result = operatorService.retrieveOperator(operatorId);

        // Assertions
        assertEquals(mockOperator, result);

        // Vérification que la méthode findById a été appelée avec le bon argument
        verify(operatorRepository).findById(operatorId);
    }
    @Test
    void testDeleteOperator() {
        // Mocking
        Long operatorId = 1L; // Remplacez 1L par l'ID de l'opérateur que vous souhaitez tester

        // Test
        operatorService.deleteOperator(operatorId);

        // Vérification que la méthode deleteById a été appelée avec le bon argument
        verify(operatorRepository).deleteById(operatorId);
    }

    @Test
    void testUpdateOperator() {
        // Mocking
        Operator operatorToUpdate = new Operator();
        when(operatorRepository.save(operatorToUpdate)).thenReturn(operatorToUpdate);

        // Test
        Operator updatedOperator = operatorService.updateOperator(operatorToUpdate);

        // Assertions
        assertEquals(operatorToUpdate, updatedOperator);

        // Vérification que la méthode save a été appelée avec le bon argument
        verify(operatorRepository).save(operatorToUpdate);
    }

}
