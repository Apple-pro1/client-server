//package com.Nathan.springboottutorial.controller;
//
//import com.Nathan.springboottutorial.dto.MemberDto;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.reactive.server.StatusAssertions;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@Slf4j
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class MemberControllerTest {
//    public static final String TEST_MEMBER_NAME = "test_member_name";
//    private static Long createdMemberId;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Order(1)
//    @Test
//    public void createMemberTest() throws Exception {
//        MemberDto.Request request = new MemberDto.Request();
//        request.setMemberName(TEST_MEMBER_NAME);
//        String jsonRequestString = objectMapper.writeValueAsString(request);
//
//
//        ResultActions resultActions = mockMvc.perform(
//                post("/member")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .characterEncoding("UTF-8")
//                        .content(jsonRequestString));
//
//        MvcResult mvcResult = resultActions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("memberId").isNotEmpty())
//                .andExpect(jsonPath("memberName").value(TEST_MEMBER_NAME))
//                .andReturn();
//
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        log.info("contentAsString = {}", contentAsString);
//
//        MemberDto.Response response = objectMapper.readValue(contentAsString, MemberDto.Response.class);
//        createdMemberId = response.getMemberId();
//    }
//
//    @Test
//    @Order(2)
//    public void getMemberTest() throws Exception {
//        log.info("createMemberId = {}", createdMemberId);
//
//        ResultActions resultActions = mockMvc.perform(
//                get("/member/{memberId}", createdMemberId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .characterEncoding("UTF-8"));
//
//        MvcResult mvcResult = resultActions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("memberId").value(createdMemberId))
//                .andExpect(jsonPath("memberName").value(TEST_MEMBER_NAME))
//                .andReturn();
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        log.info("contentAsString = {}", contentAsString);
//
//        MemberDto.Response response = objectMapper.readValue(contentAsString, MemberDto.Response.class);
//        log.info("response = {}", response);
//
//    }
//
//    @Test
//    @Order(3)
//    public void getMemberFail() throws Exception {
//        Long invalidMemberId = 1000000L;
//
//        ResultActions resultActions = mockMvc.perform(
//                get("/member/{memberId}", invalidMemberId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .characterEncoding("UTF-8"));
//
//        MvcResult mvcResult = resultActions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("responseCode").value(20))
//                .andExpect(jsonPath("responseMessage").value("no member in db"))
//                .andExpect(jsonPath("memberId").doesNotExist())
//                .andExpect(jsonPath("memberName").doesNotExist())
//                .andReturn();
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        log.info("contentAsString = {}", contentAsString);
//
//        MemberDto.Response response = objectMapper.readValue(contentAsString, MemberDto.Response.class);
//        log.info("response = {}", response);
//    }
//
//    @Test
//    @Order(4)
//    public void deleteMemberTest() throws Exception {
//        log.info("createMemberId to delete = {}", createdMemberId);
//
//        ResultActions resultActions = mockMvc.perform(
//                delete("/member/{memberId}", createdMemberId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .characterEncoding("UTF-8"));
//
//        MvcResult mvcResult = resultActions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("memberId").value(createdMemberId))
//                .andReturn();
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        log.info("contentAsString = {}", contentAsString);
//    }
//}
//
//
//
