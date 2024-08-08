package org.vck.payments.paymentimpl;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreditCardPaymentService extends PaymentServiceAbs implements PaymentService {



    public String pay(BigDecimal amount) {
        return MENSAJE;
    }
}
