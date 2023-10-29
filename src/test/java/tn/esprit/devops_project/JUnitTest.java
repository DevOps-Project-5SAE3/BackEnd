package tn.esprit.devops_project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.OperatorServiceImpl;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class JUnitTest {

    @Autowired
    OperatorServiceImpl OpeService;

    @Autowired
    OperatorRepository OpeRepo;

    @Test
    public void TestDeletNONExistingeOperator(){
        long Oreratorid= 4;
       OpeService.deleteOperator(Oreratorid);


       assertNull(OpeRepo.findOperatorByIdOperateur(Oreratorid));

    }

    @Test
    public void testDeleteExistingOperator(){
        long Oreratorid= 1;
        OpeService.deleteOperator(Oreratorid);
        assertNull(OpeRepo.findOperatorByIdOperateur(Oreratorid));
    }



}
