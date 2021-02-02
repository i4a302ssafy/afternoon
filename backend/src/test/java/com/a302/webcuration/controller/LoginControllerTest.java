package com.a302.webcuration.controller;

import com.a302.webcuration.common.BaseControllerTest;
import com.a302.webcuration.domain.Account.AccountDto;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LoginControllerTest extends BaseControllerTest {


    //---------------------------------로그인-------------------------------------------

    @Test
    public void Login_이메일요청_성공() throws Exception {

        AccountDto.LoginRequest account = new AccountDto.LoginRequest();
        account.setAct("login-request");
        account.setAccountEmail("jason967@naver.com");

        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void Login_이메일요청_실패_형식오류() throws Exception {

        AccountDto.LoginRequest account = new AccountDto.LoginRequest();
        account.setAct("login-request");
        account.setAccountEmail("ㄹasdkom");

        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void Login_이메일요청_실패_존재하지않음() throws Exception {

        AccountDto.LoginRequest account = new AccountDto.LoginRequest();
        account.setAct("login-request");
        account.setAccountEmail("none@test.com");

        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void Login_AuthKey_Off_성공() throws Exception {

        String AuthKey = "fbirccsj";

        AccountDto.LoginRequest  account = new AccountDto.LoginRequest();
        account.setAct("check-authKey-off");
        account.setAccountEmail("jason967@naver.com");
        account.setAccountAuthKey(AuthKey);

        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void Login_AuthKey_Off_실패() throws Exception {

        String AuthKey = "qqvyne13!";

        AccountDto.LoginRequest  account = new AccountDto.LoginRequest();
        account.setAct("check-authKey-off");
        account.setAccountEmail("jason967@naver.com");
        account.setAccountAuthKey(AuthKey);

        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void Login_AuthKey_On_성공() throws Exception {


        String AuthKey = "fbirccsj";

        AccountDto.LoginRequest  account = new AccountDto.LoginRequest();
        account.setAct("check-authKey-on");
        account.setAccountEmail("jason967@naver.com");
        account.setAccountAuthKey(AuthKey);

        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void auto_login_성공() throws Exception {

        String AuthKey = "fbirccsj";
        Long id = 2L;
        String email = "jason967@naver.com";
        AccountDto.LoginRequest  account = new AccountDto.LoginRequest();
        account.setAccountEmail(email);
        account.setAccountId(id);

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLroZzqt7jsnbjthqDtgbAiLCJleHAiOjE2MTI2ODEwOTEsImFjY291bnRJZCI6MiwiYWNjb3VudEVtYWlsIjoiamFzb245NjdAbmF2ZXIuY29tIn0.QjDFiYA35WZy7sH_pOld3KeL99fAKLaNbalmrA_AWng";
        mockMvc.perform(post("/api/auto-login")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization","Bearer "+token)
                .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
