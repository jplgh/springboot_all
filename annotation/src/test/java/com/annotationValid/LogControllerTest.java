package com.annotationValid;


import com.annotationValid.annotation.demoAop.LogController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 *
 */

@SpringBootTest
public class LogControllerTest {
    @Autowired
    private LogController logController;

    @Test
    public void testLogAspect() {
        logController.testLogAspect();
    }

    @Test
    public void testLogAspect1(){
        logController.testLogAspect("零零",20);
    }
}

