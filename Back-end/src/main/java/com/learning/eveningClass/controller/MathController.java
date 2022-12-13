package com.learning.eveningClass.controller;
import com.learning.eveningClass.dto.DoMathRequest;
import com.learning.eveningClass.dto.DoMathResponse;
import com.learning.eveningClass.service.MathOperator;
import com.learning.eveningClass.serviceImpl.MathOperatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @Autowired
    private MathOperator operator;

    @PostMapping("/math/calculate")
    public ResponseEntity<?> doMath(@RequestBody DoMathRequest request) {

        double operand1 = request.getOperand1();
        double operand2 = request.getOperand2();
        String operation = request.getOperation();

        double result = operator.doMath(operand1,operand2,operation);


        // create a response object with the result
        DoMathResponse response = new DoMathResponse();
        response.setResult(result);

        // return the response as a JSON object
        return ResponseEntity.ok(response);
    }
    }


