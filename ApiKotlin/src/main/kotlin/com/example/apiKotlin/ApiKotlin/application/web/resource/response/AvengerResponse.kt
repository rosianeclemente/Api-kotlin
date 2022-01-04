package com.example.apiKotlin.ApiKotlin.application.web.resource.response

import com.example.apiKotlin.ApiKotlin.domain.Avenger.Avenger

data class AvengerResponse(
    val id: Long? = null,
    val nick: String,
    val person: String,
    val description: String?,
    val history: String?
){
    companion object{
        fun from(avenger: Avenger) = AvengerResponse(
            id= avenger.id,
            nick = avenger.nick,
            person = avenger.person,
            description = avenger.description,
            history = avenger.history

        )
    }
}
