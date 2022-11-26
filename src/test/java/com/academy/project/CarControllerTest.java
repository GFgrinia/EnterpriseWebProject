package com.academy.project;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@RequiredArgsConstructor
public class CarControllerTest {

    private MockMvc mockMvc;

    @Test
    public void testPage() throws Exception {

    }
}
