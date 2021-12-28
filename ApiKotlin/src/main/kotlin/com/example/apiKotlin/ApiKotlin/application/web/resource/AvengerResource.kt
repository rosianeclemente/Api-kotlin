package com.example.apiKotlin.ApiKotlin.application.web.resource

import com.example.apiKotlin.ApiKotlin.application.web.resource.request.AvengerRequest
import com.example.apiKotlin.ApiKotlin.application.web.resource.response.AvengerResponse
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping(value = ["/v1/api/avenger"])
class AuthorityResource {

    @GetMapping
    @Transactional(readOnly = true)
    fun getAvengers() = ResponseEntity.ok().body(emptyList<AvengerResponse>())

    @GetMapping("{id")
    fun getAvengersDetails(@PathVariable("id") id: Long) = ResponseEntity.ok().body(emptyList<AvengerResponse>())

    @PostMapping
    fun createAvenger(@Valid @RequestBody request: AvengerRequest) = {

    }
}