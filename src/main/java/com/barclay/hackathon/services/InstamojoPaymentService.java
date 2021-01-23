package com.barclay.hackathon.services;

import com.barclay.SwaggerCodgen.model.Payment;
import com.instamojo.wrapper.api.ApiContext;
import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.HTTPException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.model.PaymentOrderResponse;
import org.springframework.stereotype.Service;

import java.util.logging.Level;

@Service
public class InstamojoPaymentService {


   public void createNewOrder(Payment payment) {
        ApiContext context = ApiContext.create("test_r4t0RavKX8V9aGuCNTsS149lnJi6EWgcKeM", "test_YTpZ3oeWsBP1WNFtBANYnL1TiH6uNruDUmallUlUKkY5tq6RWKa9EkOKYMlbgXV8xb7cxHz1AeYe8e6F07jDiZrcYItXBVgtU6hOGUCJR1enYWo6B0RkYAFtENM", ApiContext.Mode.TEST);
        Instamojo api = new InstamojoImpl(context);

        /*
         * Create a new payment order
         */
        PaymentOrder order = new PaymentOrder();
        order.setName("John Smith");
        order.setEmail("john.smith@gmail.com");
        order.setPhone("+918411016050");
        order.setCurrency("INR");
        order.setAmount(9D);
        order.setDescription("This is a test transaction.");
        order.setRedirectUrl("http://www.someexample.com");
        order.setWebhookUrl("http://www.someurl.com/");
        order.setTransactionId("34467");

        try {
            PaymentOrderResponse paymentOrderResponse = api.createPaymentOrder(order);
            System.out.println(paymentOrderResponse.getPaymentOptions().getPaymentUrl());

        } catch (HTTPException e) {
            System.out.println(e.getStatusCode());
            System.out.println(e.getMessage());
            System.out.println(e.getJsonPayload());

        } catch (ConnectionException e) {
            System.out.println(e.getMessage());
        }
    }
}

