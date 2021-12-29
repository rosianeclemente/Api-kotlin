package com.example.apiKotlin.ApiKotlin.resource

import com.example.apiKotlin.ApiKotlin.application.web.resource.request.AvengerRequest
import com.example.apiKotlin.ApiKotlin.domain.Avenger.Avenger
import javax.persistence.*

@Entity
class AvengerEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? ,
    @Column(nullable = false)
    val nick: String,
    @Column(nullable = false)
    val person: String,
    val description: String?,
    val history: String?
){
    fun toAvenger()=  Avenger(
        nick = nick,
        person = person,
        description = description,
        history = history )
    companion object{
        fun from (avenger: Avenger) = AvengerEntity(
            id = avenger.id,
            nick = avenger.nick,
            person = avenger.person,
            description = avenger.description,
            history = avenger.history
        )

    }
}
