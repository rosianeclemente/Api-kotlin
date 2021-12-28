package com.example.apiKotlin.ApiKotlin.application.web.resource.request

import com.example.apiKotlin.ApiKotlin.application.domain.Avenger
import com.sun.istack.NotNull
import org.springframework.data.jpa.domain.AbstractPersistable_.id
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
    val id: Long,
    val person: String,
    val description: String? = "",
    val history: String? = ""
){
    fun toAvenger()=  Avenger(
        nick = nick,
        person = person,
        description = description,
        history = description )
    companion object{
        fun to(id: Long?, request: AvengerRequest) = Avenger(
            id = id,
            nick = request.nick,
            person = request.person,
            description = request.description,
            history = request.history
        )
    }
}
