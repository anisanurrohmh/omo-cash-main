package com.mandiri.omocash.controller;

import com.mandiri.omocash.entity.Wallet;
import com.mandiri.omocash.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
public class WalletController {
    WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public Wallet createWallet(@RequestBody Wallet wallet){
        return walletService.createWallet(wallet);
    }

    @GetMapping
    public List<Wallet> findAllWallet(){
        return walletService.findAllWallet();
    }

    @PostMapping("/debit")
    public void debit(@RequestParam String email,
                      @RequestParam Integer amount){
        walletService.debit(email, amount);
    }

    @GetMapping("/{email}")
    public Wallet getWalletByEmail(@PathVariable String email){
       return walletService.getBalance(email);
    }
}
