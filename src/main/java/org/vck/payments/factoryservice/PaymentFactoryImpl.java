package org.vck.payments.factoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vck.payments.enums.PaymentMethod;
import org.vck.payments.paymentimpl.CreditCardPaymentService;
import org.vck.payments.paymentimpl.GooglePayPaymentService;
import org.vck.payments.paymentimpl.PayPalPaymentService;
import org.vck.payments.paymentimpl.PaymentService;

import java.text.MessageFormat;
import java.util.List;

@Component
public class PaymentFactoryImpl implements PaymentFactory {

    //******************************************************
//FORMA SENCILLA DE HACERLO


//    private final CreditCardPaymentService creditCardPaymentService;
//    private final PayPalPaymentService payPalPaymentService;
//    private final GooglePayPaymentService googlePayPaymentService;



//    @Autowired
//    public PaymentFactoryImpl(CreditCardPaymentService creditCardPaymentService, GooglePayPaymentService googlePayPaymentService, PayPalPaymentService payPalPaymentService) {
//        this.creditCardPaymentService = creditCardPaymentService;
//        this.googlePayPaymentService = googlePayPaymentService;
//        this.payPalPaymentService = payPalPaymentService;
//    }


//    public PaymentService create(PaymentMethod paymentMethod) throws ClassNotFoundException {
//        switch (paymentMethod){
//            case CREDIT_CARD ->{
//                return  creditCardPaymentService;
//            }
//            case PAYPAL -> {
//                return  payPalPaymentService;
//            }
//            case GOOGLE -> {
//                return  googlePayPaymentService;
//            }
//            default -> {
//                throw  new ClassNotFoundException(MessageFormat.format(
//                        "{0} is not currently as a payment method", paymentMethod
//                ));
//            }
//        }
//    }
//*****************************************************************************


    //FORMA MAS PRACTICA DE HACERLO CUANDO SON MULTIPLES INJECCIONES Y NO SE NECESITA ESCRIBIR TANTO CODIGO

    private final List<PaymentService> concretePaymentServices;

    @Autowired
    public PaymentFactoryImpl(List<PaymentService> concretePaymentServices) {
        this.concretePaymentServices = concretePaymentServices;
    }


    public PaymentService create(PaymentMethod paymentMethod) throws ClassNotFoundException {
        switch (paymentMethod){
            case CREDIT_CARD ->{
                return  getPaymentService(CreditCardPaymentService.class);
            }
            case PAYPAL -> {
                return  getPaymentService(PayPalPaymentService.class);
            }
            case GOOGLE -> {
                return  getPaymentService(GooglePayPaymentService.class);
            }
            default -> {
                throw  new ClassNotFoundException(MessageFormat.format(
                        "{0} is not currently as a payment method", paymentMethod
                ));
            }
        }
    }
//el type representa la clase
    private PaymentService getPaymentService(Class type){
        return (PaymentService) concretePaymentServices.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .findFirst()
                .orElse(null);
    }
}
