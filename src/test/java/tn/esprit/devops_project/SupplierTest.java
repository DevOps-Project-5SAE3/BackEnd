package tn.esprit.devops_project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Supplier;

import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.SupplierServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SupplierTest {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierServiceImpl supplierService;

    @Test
    void retrieveAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        when(supplierRepository.findAll()).thenReturn(suppliers);
        List<Supplier> result = supplierService.retrieveAllSuppliers();
        assertEquals(suppliers, result);
    }

    @Test
    void addSupplier() {
        Supplier supplier = new Supplier();
        when(supplierRepository.save(supplier)).thenReturn(supplier);
        Supplier result = supplierService.addSupplier(supplier);
        assertEquals(supplier, result);
    }

    @Test
    void updateSupplier() {
        Supplier supplier = new Supplier();
        when(supplierRepository.save(supplier)).thenReturn(supplier);
        Supplier result = supplierService.updateSupplier(supplier);
        assertEquals(supplier, result);
    }

    @Test
    void deleteSupplier() {
        Long id = 1L;
        doNothing().when(supplierRepository).deleteById(id);
        supplierService.deleteSupplier(id);
        verify(supplierRepository, times(1)).deleteById(id);
    }

    @Test
    void retrieveSupplier() {
        Long id = 1L;
        Supplier supplier = new Supplier();
        when(supplierRepository.findById(id)).thenReturn(Optional.of(supplier));
        Supplier result = supplierService.retrieveSupplier(id);
        assertEquals(supplier, result);
    }
}
