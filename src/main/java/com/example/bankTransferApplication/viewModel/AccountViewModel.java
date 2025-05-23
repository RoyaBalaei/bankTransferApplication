package com.example.bankTransferApplication.viewModel;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountViewModel {
    private Long fromId;
    private Long toId;
    private BigDecimal amount;
}
