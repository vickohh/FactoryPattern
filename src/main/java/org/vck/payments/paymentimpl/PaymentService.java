package org.vck.payments.paymentimpl;

import java.math.BigDecimal;

public interface PaymentService {

    String pay(BigDecimal amount);

}
