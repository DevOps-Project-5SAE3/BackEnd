package tn.esprit.devops_project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void retrieveAllProducts() {
        List<Product> products = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(products);
        List<Product> result = productService.retreiveAllProduct();
        assertEquals(products, result);
    }

    @Test
    void addProduct() {
        Product product = new Product();
        Stock stock = new Stock();
        product.setStock(stock);

        when(stockRepository.findById(anyLong())).thenReturn(Optional.of(stock));
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.addProduct(product, 1L);
        assertEquals(product, result);
    }

    @Test
    void deleteProduct() {
        Long id = 1L;
        doNothing().when(productRepository).deleteById(id);
        productService.deleteProduct(id);
        verify(productRepository, times(1)).deleteById(id);
    }



    @Test
    void retrieveProduct() {
        Long id = 1L;
        Product product = new Product();
        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        Product result = productService.retrieveProduct(id);
        assertEquals(product, result);
    }



    @Test
    void retrieveProductStock() {
        Long stockId = 1L;
        List<Product> products = new ArrayList<>();
        when(productRepository.findByStockIdStock(stockId)).thenReturn(products);
        List<Product> result = productService.retreiveProductStock(stockId);
        assertEquals(products, result);
    }
}
