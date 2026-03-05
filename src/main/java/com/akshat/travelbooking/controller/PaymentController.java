package com.akshat.travelbooking.controller;



import com.akshat.travelbooking.dto.PaymentRequestDTO;
import com.akshat.travelbooking.dto.PaymentResponseDTO;
import com.akshat.travelbooking.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> makePayment(
            @Valid @RequestBody PaymentRequestDTO requestDTO) {

        return ResponseEntity.ok(service.makePayment(requestDTO));
    }
}
