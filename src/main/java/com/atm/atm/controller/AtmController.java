package com.atm.atm.controller;

import com.atm.atm.adds.Account;
import com.atm.atm.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("atm")
public class AtmController {
    @Autowired
    private AtmService atmService;

    @GetMapping("deposit/{accountId}/{amount}")
    public Mono<Account> depositByAtm(@PathVariable("accountId") String accountId,
                                      @PathVariable("amount") double amount){
        return atmService.deposit(accountId,amount);
    }

    @GetMapping("withdraw/{accountId}/{amount}")
    public Mono<Account> withdrawByAtm(@PathVariable("accountId") String accountId,
                                      @PathVariable("amount") double amount){
        return atmService.withdraw(accountId,amount);
    }
    

}
