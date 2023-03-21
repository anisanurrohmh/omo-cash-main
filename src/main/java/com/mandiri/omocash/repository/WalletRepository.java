package com.mandiri.omocash.repository;

import com.mandiri.omocash.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {
    public Wallet findWalletByEmail(String email);
}
