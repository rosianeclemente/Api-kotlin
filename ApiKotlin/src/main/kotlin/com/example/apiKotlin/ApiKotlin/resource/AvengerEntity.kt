package com.example.apiKotlin.ApiKotlin.resource

import com.example.apiKotlin.ApiKotlin.domain.Avenger
import javax.persistence.*

@Entity
@Table(name = "avenger")
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
    fun toAvenger()=  Avenger(id, nick,person,description,history )
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
