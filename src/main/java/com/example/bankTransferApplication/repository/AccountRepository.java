package com.example.bankTransferApplication.repository;

import com.example.bankTransferApplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
