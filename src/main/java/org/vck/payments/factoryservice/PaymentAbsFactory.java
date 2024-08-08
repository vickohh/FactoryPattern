package org.vck.payments.factoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.vck.payments.paymentimpl.PaymentService;
import org.vck.payments.enums.PaymentMethod;
import org.vck.payments.paymentimpl.CreditCardPaymentService;
import org.vck.payments.paymentimpl.GooglePayPaymentService;
import org.vck.payments.paymentimpl.PayPalPaymentService;

public abstract class PaymentAbsFactory {

    public PaymentService create(PaymentMethod paymentMethod) throws ClassNotFoundException {
        return null;
    }

    @Autowired
    protected CreditCardPaymentService creditCardPaymentService = new CreditCardPaymentService();

    @Autowired
    protected GooglePayPaymentService googlePayPaymentService = new GooglePayPaymentService();

    @Autowired
    protected  PayPalPaymentService payPalPaymentService = new PayPalPaymentService();
}
