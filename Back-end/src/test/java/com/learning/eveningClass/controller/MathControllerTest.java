package com.learning.eveningClass.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.eveningClass.dto.DoMathRequest;
import com.learning.eveningClass.dto.DoMathResponse;
import com.learning.eveningClass.service.MathOperator;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {

        @Autowired


        @MockBean
        private MathController controller;

        @MockBean
        private MathOperator operator;

        @Test
        public void testDoMath() throws Exception {
            // Mock the MathOperator to return a fixed result
            // when the doMath() method is called
            double operand1 = 1.0;
            double operand2 = 2.0;
            String operation = "+";
            double expectedResult = 3.0;
            when(operator.doMath(operand1, operand2, operation)).thenReturn(expectedResult);

            // Create a JSON object that represents the request
            DoMathRequest request = new DoMathRequest();
            request.setOperand1(operand1);
            request.setOperand2(operand2);
            request.setOperation(operation);

            // Perform a POST request to

            ResponseEntity<?> result = controller.perform(post("/math/calculate")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(toJson(request)))
                    .andReturn();

            // get the response object from the result
            DoMathResponse response = fromJson(result.getResponse().getContentAsString(), DoMathResponse.class);

            // verify that the response has a result value of 5
            assertEquals(5, response.getResult(), 0.001);
        }

    @Test
    public void testWholeOperation() {
        // Create a new DoMathRequest object with the input data
        DoMathRequest request = new DoMathRequest();
        request.setOperand1(2);
        request.setOperand2(3);
        request.setOperation("+");

        // Call the doMath method and store the result
        ResponseEntity<?> result = controller.doMath(request);

        // Verify that the result is correct
        assertEquals(5, result);
    }



}
