package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ContextConfiguration(classes = {StockServiceImpl.class})
@ExtendWith(MockitoExtension.class)
public class StockServiceImplTest {

    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @Test
    void testAddStock() {
        // Mocking
        Stock stock = new Stock();
        when(stockRepository.save(stock)).thenReturn(stock);

        // Test
        Stock result = stockService.addStock(stock);

        // Assertions
        assertEquals(stock, result);

        // Verification that the method save has been called with the correct argument
        verify(stockRepository).save(stock);
    }

    @Test
    void testRetrieveAllStock() {
        // Mocking
        List<Stock> stockList = new ArrayList<>();
        when(stockRepository.findAll()).thenReturn(stockList);

        // Test
        List<Stock> result = stockService.retrieveAllStock();

        assertSame(stockList, result);
        assertTrue(result.isEmpty());

        verify(stockRepository).findAll();
    }
    @Test
    void testRetrieveStock() {
        // Mocking
        Integer idstock =0 ;
        Stock mockStock = new Stock();
        when(stockRepository.findById(Long.valueOf(idstock))).thenReturn(Optional.of(mockStock));

        // Test
        Stock result = stockService.retrieveStock(Long.valueOf(idstock));

        // Assertions
        assertEquals(mockStock, result);

        // Vérification que la méthode findById a été appelée avec le bon argument
        verify(stockRepository).findById(Long.valueOf(idstock));
    }

}
