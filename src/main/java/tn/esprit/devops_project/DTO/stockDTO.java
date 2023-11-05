package tn.esprit.devops_project.DTO;

import tn.esprit.devops_project.entities.Product;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

public class stockDTO {

   private long idStock;
    private String title;

    private  Set<Product> products;
}
