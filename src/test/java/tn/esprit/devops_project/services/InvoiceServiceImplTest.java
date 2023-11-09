package tn.esprit.devops_project.services;
import org.junit.jupiter.api.Test; // Pour annoter les méthodes de test

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Invoice;

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


