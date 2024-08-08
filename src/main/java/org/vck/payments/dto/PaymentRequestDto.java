package org.vck.payments.dto;

import org.vck.payments.enums.PaymentMethod;

import java.math.BigDecimal;

public class PaymentRequestDto {
    public BigDecimal amount;
    public PaymentMethod paymentMethod;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
