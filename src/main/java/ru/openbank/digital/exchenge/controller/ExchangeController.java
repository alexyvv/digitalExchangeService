package ru.openbank.digital.exchenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import ru.openbank.digital.exchenge.data.Quote;
import ru.openbank.digital.exchenge.service.QuoteService;

/**
 * Rest controller for exchange service.
 */
@RestController
public class ExchangeController {

//    @Autowired
//    private LoanBrokerGateway loanBrokerGateway;

    @Autowired
    private QuoteService quoteService;

    private static final double BEST_QUOTE_VALUE = 0.04;

    @RequestMapping(value = "/quote/{currencyName}",
            method = RequestMethod.GET)
    public ResponseEntity<Quote> getQuote(@PathVariable("currencyName") String currencyName) {

        return new ResponseEntity<>(quoteService.getQuote(currencyName), HttpStatus.OK);
    }

    @RequestMapping("/quotation")
    public DeferredResult<ResponseEntity<?>> quotation(final @RequestParam(value="loanAmount")
                                                                   Double loanAmount) throws Exception {

        final DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>(5000L);
        deferredResult.onTimeout(() -> { // Retry on timeout
            deferredResult.setErrorResult(ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
                    .body("Request timeout occurred."));
        });

//        ListenableFuture<Double> future = loanBrokerGateway.bestQuotation(loanAmount);
//        future.addCallback(new ListenableFutureCallback<Double>() {
//            @Override
//            public void onSuccess(Double result) {
//                // Double check response matches with request
//                if(result.equals(loanAmount * BEST_QUOTE_VALUE))
//                    deferredResult.setResult(ResponseEntity.ok(result));
//                else
//                    deferredResult.setErrorResult(ResponseEntity.status(HttpStatus.CONFLICT)
//                            .body("Invalid quotation "+result+" for loan amount "+loanAmount));
//            }
//            @Override
//            public void onFailure(Throwable t) {
//                deferredResult.setErrorResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(t));
//            }
//        });
        return deferredResult;
    }
}


