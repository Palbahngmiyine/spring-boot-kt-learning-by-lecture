package dev.subux.springbootinfearnkt

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SampleController {


    @GetMapping("/hello")
    fun hello(model: Model): String {
        model.addAttribute("name", "subin")
        return "hello"
    }
}