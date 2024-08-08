package org.vck.payments.factoryservice;

import org.vck.payments.paymentimpl.PaymentService;
import org.vck.payments.enums.PaymentMethod;

public interface PaymentFactory {
    public PaymentService create(PaymentMethod paymentMethod) throws ClassNotFoundException;
}
