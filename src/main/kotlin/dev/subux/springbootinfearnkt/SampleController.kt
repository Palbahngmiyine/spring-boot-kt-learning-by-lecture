package dev.subux.springbootinfearnkt

import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {

    @GetMapping("/hello")
    fun hello(): EntityModel<Hello> {
        val Hello = Hello("Hey, ", "Subin")
        val helloEntityModel: EntityModel<Hello> = EntityModel(Hello)
        helloEntityModel.add(linkTo(methodOn(this.javaClass).hello()).withSelfRel())
        return helloEntityModel
    }
}