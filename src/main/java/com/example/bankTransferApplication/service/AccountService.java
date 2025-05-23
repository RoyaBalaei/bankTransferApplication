package com.example.bankTransferApplication.service;

import com.example.bankTransferApplication.model.Account;
import com.example.bankTransferApplication.repository.AccountRepository;
import com.example.bankTransferApplication.viewModel.AccountViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Transactional
    public void transfer(AccountViewModel viewModel){
        if (viewModel.getFromId().equals(viewModel.getToId())){
            throw new RuntimeException("شماره حساب درست نمی باشد.");
        }
        Account accountFrom=repository.findById(viewModel.getFromId()).orElseThrow();
        Account accountTo=repository.findById(viewModel.getToId()).orElseThrow();
        if (accountFrom.getBalance().compareTo(viewModel.getAmount()) < 0){
            throw new RuntimeException("موجودی کافی نیست.");
        }
        BigDecimal subtractFrom = accountFrom.getBalance().subtract(viewModel.getAmount());
        accountFrom.setBalance(new BigDecimal(subtractFrom.toPlainString()));
        //برای تست rollback می باشد
//        if (true){
//            throw new RuntimeException("خطای تستی");
//        }
        BigDecimal addTo = accountTo.getBalance().add(viewModel.getAmount());
        accountTo.setBalance(new BigDecimal(addTo.toPlainString()));
        repository.save(accountFrom);
        repository.save(accountTo);

    }
}
