package tn.esprit.devops_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.SupplierServiceImpl;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SupplierTest {

    @Mock
    SupplierRepository supplierRepository;

    private SupplierServiceImpl supplierService;

    @BeforeEach
    void setUp() {
        supplierService = new SupplierServiceImpl(supplierRepository);
    }

    @Test
    void testRetrieveAllSuppliers() {
        // Créez des données de test
        Supplier supplier1 = new Supplier(1L, "code1", "label1", SupplierCategory.ORDINAIRE, null, null);
        Supplier supplier2 = new Supplier(2L, "code2", "label2", SupplierCategory.ORDINAIRE, null, null);
        List<Supplier> suppliers = Arrays.asList(supplier1, supplier2);

        // Configurez le comportement du mock
        when(supplierRepository.findAll()).thenReturn(suppliers);

        // Appelez la méthode du service à tester
        List<Supplier> retrievedSuppliers = supplierService.retrieveAllSuppliers();

        // Vérifiez le résultat
        assertEquals(2, retrievedSuppliers.size());
        assertEquals(supplier1.getCode(), retrievedSuppliers.get(0).getCode());
        assertEquals(supplier2.getLabel(), retrievedSuppliers.get(1).getLabel());
    }


}

