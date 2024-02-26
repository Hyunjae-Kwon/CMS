package com.zerobase.cms.user.service;

import com.zerobase.cms.user.domain.SignUpForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SignUpCustomerServiceTest {

    @Autowired
    private SignUpCustomerService service;

    @Test
    void signUp() {
        // given
        // when
        SignUpForm form = SignUpForm.builder()
                .name("name")
                .birth(LocalDate.now())
                .email("abc@gmail.com")
                .password("1")
                .phone("01000000000")
                .build();

        // then
        assertEquals(1L, service.signUp(form).getId());
        assertEquals("name", service.signUp(form).getName());
        assertEquals("abc@gmail.com", service.signUp(form).getEmail());
        assertEquals("1", service.signUp(form).getPassword());
        assertEquals("01000000000", service.signUp(form).getPhone());

    }

}