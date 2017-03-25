package ru.openbank.digital.exchenge.service;

import ru.openbank.digital.exchenge.data.Quote;

public interface QuoteService {

    Quote getQuote(String currencyName);
}
