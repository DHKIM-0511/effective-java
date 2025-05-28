package com.nrz.efj.chapter04.item26.genericdao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class AccountRepositoryTest {

    @Test
    void findById(){
        AccountRepository accountRepository = new AccountRepository();
        Account account = new Account(1L, "nrz");
        accountRepository.add(account);

        Optional<Account> byId = accountRepository.findById(1L);
        assertTrue(byId.isPresent());
    }
 }