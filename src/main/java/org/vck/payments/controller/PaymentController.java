package org.vck.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vck.payments.factoryservice.PaymentFactory;
import org.vck.payments.paymentimpl.PaymentService;
import org.vck.payments.dto.PaymentRequestDto;

@RestController
@RequestMapping(path = "/api/payments")
public class PaymentController {


//    private final PaymentAbsFactory paymentFactory;
//
//    @Autowired
//    public PaymentController(PaymentAbsFactory paymentFactory) {
//        this.paymentFactory = paymentFactory;
//    }


// INTERFACE IMPLEMENTATION
    private final PaymentFactory paymentFactory;

    @Autowired
    public PaymentController(PaymentFactory paymentFactory) {
        this.paymentFactory = paymentFactory;
    }


    @PostMapping(path = "/makepayment")
    public ResponseEntity<String> pay(@RequestBody PaymentRequestDto paymentRequestDto) throws ClassNotFoundException {

        try {
            PaymentService paymentService = paymentFactory.create(paymentRequestDto.getPaymentMethod());
            return new ResponseEntity<>(paymentService.pay(paymentRequestDto.amount), HttpStatus.OK);

        } catch (ClassNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }


}
