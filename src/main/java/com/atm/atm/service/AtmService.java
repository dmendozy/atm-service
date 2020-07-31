package com.atm.atm.service;

import com.atm.atm.adds.Account;
import com.atm.atm.adds.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AtmService {

    public Mono<Account> deposit(String accountId, Double amount){
        Transaction transaction = new Transaction("Deposit",amount);
        Mono<Transaction> transactionMono = WebClient
                .create("http://transaction-service/transactions")
                .post()
                .body(Mono.just(transaction),Transaction.class)
                .retrieve()
                .bodyToMono(Transaction.class);
        return transactionMono.flatMap(t->{
            return WebClient.create("http://account-service/accounts/atm/deposit/"+accountId+"/"+
                    transaction.getTransactionId()+"/"+amount)
                    .put()
                    .retrieve()
                    .bodyToMono(Account.class);
        });
    }
}
