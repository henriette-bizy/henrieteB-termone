package com.learning.eveningClass.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.eveningClass.dto.DoMathRequest;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerTest {



    @Autowired
    private MathController mathController;


//    @Test
//    public void testMathController() throws Exception {
//        // Set up the input values for the math operation
//        Map<String, Object> requestBody = new HashMap<>();
//        requestBody.put("operation", "addition");
//        requestBody.put("operands", Arrays.asList(1, 2, 3));
//
//        // Send a POST request to the MathController API
//        mathController.doMath()
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(requestBody)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.result").value(6));
//    }


    @Test
    public void testDoMath() {
        // Create a new DoMathRequest object with the input data
        DoMathRequest request = new DoMathRequest();
        request.setOperand1(2);
        request.setOperand2(3);
        request.setOperation("+");

        // Call the doMath method and store the result
        ResponseEntity<?> result = mathController.doMath(request);

        // Verify that the result is correct
        assertEquals(5, result);
    }



}
