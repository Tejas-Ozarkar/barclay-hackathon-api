package com.barclay.hackathon.controllers;

import com.barclay.SwaggerCodgen.api.PaymentApi;
import com.barclay.SwaggerCodgen.model.GenericResponse;
import com.barclay.SwaggerCodgen.model.Payment;
import com.barclay.hackathon.services.InstamojoPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController implements PaymentApi {

    @Autowired
    private InstamojoPaymentService paymentService;

    @Override
    public ResponseEntity<GenericResponse> payment(Payment payment) {
        paymentService.createNewOrder(payment);
        return null;
    }
}
