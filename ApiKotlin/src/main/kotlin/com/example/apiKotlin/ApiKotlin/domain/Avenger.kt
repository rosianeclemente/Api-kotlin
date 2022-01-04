package com.example.apiKotlin.ApiKotlin.domain

import org.springframework.data.jpa.domain.AbstractPersistable
import java.io.Serializable
import javax.persistence.metamodel.SingularAttribute

data class Avenger(
    val id: Long? = null,
    val nick: String,
    val person: String,
    val description: String?,
    val history: String?
)
