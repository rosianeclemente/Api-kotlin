package com.example.apiKotlin.ApiKotlin.application.web.error.exception

import java.lang.RuntimeException

data class BadRequestException(override val message: String) : RuntimeException(message)