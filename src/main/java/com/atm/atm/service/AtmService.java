package com.atm.atm.service;

import com.atm.atm.adds.Account;
import com.atm.atm.adds.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

@Service
public class AtmService {

    @Autowired
    WebClient.Builder webClientBuilder;

    public Mono<Account> deposit(String accountId, Double amount){
        return webClientBuilder
                .build()
                .put()
                .uri("http://localhost:8083/accounts/atm/deposit/"+accountId+"/"+amount)
                .retrieve()
                .bodyToMono(Account.class);
    }

    public Mono<Account> withdraw(String accountId, Double amount){
        return webClientBuilder
                        .build()
                        .put()
                        .uri("http://localhost:8083/accounts/atm/withdraw/"+accountId+"/"+amount)
                        .retrieve()
                        .bodyToMono(Account.class);
    }

}
