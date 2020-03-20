package dev.subux.springbootinfearnkt.user

import dev.subux.springbootinfearnkt.UserController
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringRunner::class)
@WebMvcTest(UserController::class)
class UserControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun hello() {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk)
                .andExpect(content().string("hello"))
    }

    @Test
    fun createUser_JSON() {
        val userJson = "{\"username\": \"subin\", \"password\": \"123\"}"
        mockMvc.perform(
                post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.username").value("subin"))
                .andExpect(jsonPath("$.password").value("123"))
    }
}
