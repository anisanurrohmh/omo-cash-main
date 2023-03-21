package com.mandiri.omocash.service;

import com.mandiri.omocash.entity.Wallet;
import com.mandiri.omocash.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService{

    WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet getBalance(String email) {
        return walletRepository.findWalletByEmail(email);
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public List<Wallet> findAllWallet() {
        return walletRepository.findAll();
    }

    @Override
    public void debit(String email, Integer amount) {
        Wallet wallet = walletRepository.findWalletByEmail(email);
        wallet.setBalance(wallet.getBalance()-amount);
        walletRepository.save(wallet);
    }
}
