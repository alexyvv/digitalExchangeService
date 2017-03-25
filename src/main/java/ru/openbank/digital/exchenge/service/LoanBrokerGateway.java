package ru.openbank.digital.exchenge.service;

import org.springframework.util.concurrent.ListenableFuture;

public interface LoanBrokerGateway {
    ListenableFuture<Double> bestQuotation(Double loanAmount);
}
