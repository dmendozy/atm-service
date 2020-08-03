package com.atm.atm.service;

import com.atm.atm.adds.Account;
import com.atm.atm.adds.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AtmService {

    @Autowired
    WebClient.Builder webClientBuilder;

    public Mono<Account> deposit(String accountId, Double amount){
        Transaction transaction = new Transaction("Deposit",amount,accountId);
        Mono<Transaction> transactionMono = webClientBuilder
                .build()
                .post()
                .uri("http://localhost:8084/transactions")
                .body(Mono.just(transaction),Transaction.class)
                .retrieve()
                .bodyToMono(Transaction.class);
        return transactionMono.flatMap(t->
                webClientBuilder
                .build()
                .put()
                .uri("http://localhost:8083/accounts/atm/deposit/"+accountId+"/"+amount)
                .retrieve()
                .bodyToMono(Account.class));
    }
}
