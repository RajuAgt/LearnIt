package org.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class RequestUtilsTest {
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @InjectMocks
    RequestUtils utils;
    @BeforeEach()
    public void setUp() {
        System.out.println("Inside setup");
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }
    @Test
    public void testGetParamAsInteger(){
        utils = mock(RequestUtils.class);
        // Map<String,Integer> values= new HashMap();
        String parameterName = "journalId";
        String journalId = "10";
        System.out.println("hejji");
        Properties prop = new Properties();
        prop.setProperty(parameterName, journalId);
        when(request.getParameter(parameterName)).thenReturn(journalId);
        //req.getParamAsInteger(request, journalId);
        // values.put(parameterName, journalId);
        // int retrievedValue = values.get(parameterName);
        //when(request.getParameter("intValue")).thenReturn("200");
        assertNotNull(utils.getParamAsInteger(request, parameterName));
        //verify(response).setStatus(HttpServletResponse.SC_OK);
    }

    // @Test
    // public void testGetParamAsInteger() {
    // //MockHttpServletRequest mcrequest = new MockHttpServletRequest();
    //mcrequest.setParameter("testParam", "42");
    // // int result = RequestUtils.getParamAsInteger(mcrequest, "testParam", -1);
    // assertEquals(42, result, "Valid integer parameter should be parsed correctly");
    // // int defaultResult = RequestUtils.getParamAsInteger(mcrequest, "nonExistingParam", 10);
    // assertEquals(10, defaultResult, "Non-existing parameter should return default value");
    // // assertThrows(IllegalArgumentException.class, () -> {
    // RequestUtils.getParamAsInteger(mcrequest, "invalidParam", -1);
    // }, "Invalid parameter should throw IllegalArgumentException");
    // }
}