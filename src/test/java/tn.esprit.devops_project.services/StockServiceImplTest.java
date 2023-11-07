package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class StockServiceImplTest {
    private StockServiceImpl stockService;
    private StockRepository stockRepository;
    private Stock stock;

    @Test
    public void testAddStock() {
        stockRepository = Mockito.mock(StockRepository.class);
        stockService = new StockServiceImpl(stockRepository);
        stock = Stock.builder().idStock(1).title("Title").build();
        given(stockRepository.save(stock)).willReturn(stock);
        Stock savedStock = stockService.addStock(stock);
        assertThat(savedStock).isNotNull();
    }
}
