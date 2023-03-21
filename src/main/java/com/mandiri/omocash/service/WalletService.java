package com.mandiri.omocash.service;

import com.mandiri.omocash.entity.Wallet;

import java.util.List;

public interface WalletService {
    public Wallet getBalance(String email);
    public Wallet createWallet(Wallet wallet);
    public List<Wallet> findAllWallet();
    public void debit(String email, Integer amount);
}
