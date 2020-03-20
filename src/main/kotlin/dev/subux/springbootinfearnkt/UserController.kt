package dev.subux.springbootinfearnkt

import org.springframework.web.bind.annotation.*

@RestController
class UserController {

    @GetMapping("/hello")
    fun hello(): String {
        return "hello"
    }

    // RestController 애노테이션의 경우 response body 애노테이션 생략해도됨
    // Controller 애노테이션은 붙여줘야 됨, 자동으로 view 네임을 찾기 때문
    @PostMapping("/users/create")
    fun create(@RequestBody user: User): User? {
        return user
    }
}