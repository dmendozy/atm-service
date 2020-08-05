package com.atm.atm.service;

import com.atm.atm.adds.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


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

    public Mono<Account> depositInterBank(String accountId, Double amount, String bankId){
        return webClientBuilder
                .build()
                .put()
                .uri("http://localhost:8083/accounts/bank/atm/deposit/"+accountId+"/"+amount+"/"+bankId)
                .retrieve()
                .bodyToMono(Account.class);
    }

    public Mono<Account> withdrawInterBank(String accountId, Double amount, String bankId){
        return webClientBuilder
                .build()
                .put()
                .uri("http://localhost:8083/accounts/bank/atm/withdraw/"+accountId+"/"+amount+"/"+bankId)
                .retrieve()
                .bodyToMono(Account.class);
    }

}
