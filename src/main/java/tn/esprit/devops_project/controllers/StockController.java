package tn.esprit.devops_project.controllers;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.DTO.stockDTO;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.services.Iservices.IStockService;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class StockController {

    @Autowired
    IStockService stockService;

    @Autowired
    private ModelMapper modelMapper;
    @PostMapping("/stock")
    stockDTO addStock(@RequestBody stockDTO stock){

        Stock stock1 = modelMapper.map(stock,Stock.class);
        Stock stock2 = stockService.addStock(stock1);
        return modelMapper.map(stock2, stockDTO.class);
    }

    @GetMapping("/stock/{id}")
    Stock retrieveStock(@PathVariable Long id){
        return stockService.retrieveStock(id);
    }

    @GetMapping("/stock")
    List<Stock> retrieveAllStock(){
        return stockService.retrieveAllStock();
    }


}
