package com.example.bankTransferApplication.controller;

import com.example.bankTransferApplication.service.AccountService;
import com.example.bankTransferApplication.viewModel.AccountViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransferController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/transfer")
    public String transfer(@RequestBody AccountViewModel viewModel){
        try {
           accountService.transfer(viewModel);
            return "موفق";
        }catch (Exception e){
            return "خطا: "+e.getMessage();
        }

    }
}
