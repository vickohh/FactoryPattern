package org.vck.payments.paymentimpl;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.MessageFormat;
@Service
public class GooglePayPaymentService implements PaymentService {
    @Override
    public String pay(BigDecimal amount) {
        return MessageFormat.format("Successfully paid ${0} to merchant using a Google Pay", amount);
    }
}
