package dev.subux.springbootinfearnkt

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@RunWith(SpringRunner::class)
@WebMvcTest(SampleController::class)
internal class SampleControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun hello() {
        mockMvc.get("/hello")
                .andExpect {
                    status { isOk }
                    jsonPath("$._links.self").exists()
                }
                .andDo { print() }
    }
}