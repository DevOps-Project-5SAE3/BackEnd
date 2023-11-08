package tn.esprit.devops_project.services;
import org.junit.jupiter.api.Test; // Pour annoter les méthodes de test
import org.junit.jupiter.api.BeforeEach; // Pour annoter les méthodes d'initialisation avant chaque test
import org.junit.jupiter.api.AfterEach; // Pour annoter les méthodes de nettoyage après chaque test
import org.junit.jupiter.api.BeforeAll; // Pour annoter les méthodes d'initialisation avant tous les tests
import org.junit.jupiter.api.AfterAll; // Pour annoter les méthodes de nettoyage après tous les tests
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.InvoiceRepository;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.repositories.SupplierRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*; // Pour les assertions JUnit
import static org.mockito.Mockito.when;


    @ExtendWith(MockitoExtension.class)
    public class InvoiceServiceImplTest {

        @InjectMocks
        private InvoiceServiceImpl invoiceService;

        @Mock
        private InvoiceRepository invoiceRepository;

        @Mock
        private OperatorRepository operatorRepository;

        @Mock
        private SupplierRepository supplierRepository;

        @Test
        public void testRetrieveAllInvoices() {
            // Créez une liste d'invoices simulées pour les tests
            List<Invoice> invoices = Arrays.asList(new Invoice(), new Invoice());

            // Configurez le comportement du mock InvoiceRepository
            when(invoiceRepository.findAll()).thenReturn(invoices);

            List<Invoice> retrievedInvoices = invoiceService.retrieveAllInvoices();

            // Effectuez des assertions pour vérifier que les invoices sont récupérées correctement
            assertEquals(2, retrievedInvoices.size());
        }

        @Test
        public void testCancelInvoice() {
            Long invoiceId = 1L;
            Invoice invoice = new Invoice();

            // Configurez le comportement du mock InvoiceRepository
            when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(invoice));

            invoiceService.cancelInvoice(invoiceId);

            // Effectuez des assertions pour vérifier que l'invoice est archivé
            assertTrue(invoice.getArchived());
        }

        @Test
        public void testRetrieveInvoice() {
            Long invoiceId = 1L;
            Invoice invoice = new Invoice();

            // Configurez le comportement du mock InvoiceRepository
            when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(invoice));

            Invoice retrievedInvoice = invoiceService.retrieveInvoice(invoiceId);

            // Effectuez des assertions pour vérifier que l'invoice est correctement récupéré
            assertEquals(invoice, retrievedInvoice);
        }

      /*  @Test
        public void testGetInvoicesBySupplier() {
            Long supplierId = 1L;
            Supplier supplier = new Supplier();
            Invoice invoice1 = new Invoice();
            Invoice invoice2 = new Invoice();

            // Configurez le comportement du mock SupplierRepository
            when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(supplier));
            when(supplier.getInvoices()).thenReturn((Set<Invoice>) Arrays.asList(invoice1, invoice2));

            List<Invoice> invoices = invoiceService.getInvoicesBySupplier(supplierId);

            // Effectuez des assertions pour vérifier que les invoices du fournisseur sont correctement récupérées
            assertEquals(2, invoices.size());
        }*/



     /*  @Test
        public void testAssignOperatorToInvoice() {
            Long operatorId = 1L;
            Long invoiceId = 2L;
            Operator operator = new Operator();
            Invoice invoice = new Invoice();

            // Configurez le comportement du mock OperatorRepository et InvoiceRepository
            when(operatorRepository.findById(operatorId)).thenReturn(Optional.of(operator));
            when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(invoice));

            // Appelez la méthode pour assigner l'opérateur à l'invoice
            invoiceService.assignOperatorToInvoice(operatorId, invoiceId);

            // Obtenez la liste des factures de l'opérateur
            Set<Invoice> operatorInvoices = operator.getInvoices();

            // Effectuez des assertions pour vérifier que l'opérateur est correctement assigné à l'invoice
            assertTrue(operatorInvoices.contains(invoice));
        }*/




        @Test
        public void testGetTotalAmountInvoiceBetweenDates() {
            Date startDate = new Date();
            Date endDate = new Date();
            float totalAmount = 100.0f;

            // Configurez le comportement du mock InvoiceRepository
            when(invoiceRepository.getTotalAmountInvoiceBetweenDates(startDate, endDate)).thenReturn(totalAmount);

            float result = invoiceService.getTotalAmountInvoiceBetweenDates(startDate, endDate);

            // Effectuez des assertions pour vérifier que le montant total est correct
            assertEquals(totalAmount, result, 0.01); // Utilisez une tolérance pour les comparaisons de valeurs flottantes
        }
    }


