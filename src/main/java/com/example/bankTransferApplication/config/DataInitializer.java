package com.example.bankTransferApplication.config;

import com.example.bankTransferApplication.model.Account;
import com.example.bankTransferApplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AccountRepository repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count()==0){
            Account accountAli=new Account();
            accountAli.setOwner("Ali");
            accountAli.setBalance(new BigDecimal(1000000000));

            Account accountMaryam=new Account();
            accountMaryam.setOwner("Maryam");
            accountMaryam.setBalance(new BigDecimal(1000000000));

            repository.save(accountAli);
            repository.save(accountMaryam);

            System.out.println("حساب ها با موفقیت ساخته شدند");
        }
    }
}
