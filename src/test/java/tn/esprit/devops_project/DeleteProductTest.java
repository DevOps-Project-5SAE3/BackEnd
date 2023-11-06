package tn.esprit.devops_project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.services.ProductServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)

public class DeleteProductTest {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductServiceImpl productService;




        @Test
        public void testDeleteNonExistentProduct() {
            long nonExistentProductId = 999; // Use a product ID that doesn't exist

            // Act: Perform the operation being tested
            productService.deleteProduct(nonExistentProductId);

            // Assert: Verify the expected state or side effects
            assertNull(productRepository.findProductByIdProduct(nonExistentProductId));
        }

        @Test
        public void testDeleteExistingProduct() {
            long existingProductId = 2; // Use a product ID that exists

            // Act: Perform the operation being tested
            productService.deleteProduct(existingProductId);

            // Assert: Verify the expected state or side effects
            assertNull(productRepository.findProductByIdProduct(existingProductId));
        }
    }

