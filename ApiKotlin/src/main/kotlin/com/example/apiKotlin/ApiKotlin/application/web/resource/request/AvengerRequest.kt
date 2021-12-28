package com.example.apiKotlin.ApiKotlin.application.web.resource.request

import com.sun.istack.NotNull
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class AvengerRequest(
    @field:NotNull
    @field:NotBlank
    @field:NotEmpty
    val nick: String,
    @field:NotNull
    @field:NotBlank
    @field:NotEmpty
    val person: String,
    val description: String? = "",
    val history: String? = ""
)
