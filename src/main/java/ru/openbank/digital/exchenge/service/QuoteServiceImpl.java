package ru.openbank.digital.exchenge.service;

import org.springframework.stereotype.Service;
import ru.openbank.digital.exchenge.data.Quote;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Quote service.
 */
@Service
public class QuoteServiceImpl implements QuoteService {

    private Map<String, Quote> stubQuoteMap = new HashMap<>();
    private Quote defaultQuote = new Quote("EUR/JPY", 100, 100);
    {
        stubQuoteMap.put("USDRUR", new Quote("USD/RUR", 60, 30));
        stubQuoteMap.put("EURRUR", new Quote("EUR/RUR", 80, 40));
    }

    @Override
    public Quote getQuote(String currencyName) {

        return Optional.ofNullable(stubQuoteMap.get(currencyName))
                .orElse(defaultQuote);
    }
}
