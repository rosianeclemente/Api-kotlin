package com.example.apiKotlin.ApiKotlin.domain

interface AvengerRepository {
    fun getDetail(id: Long): Avenger?
    fun getAvenger(): List<Avenger>
    fun create(avenger: Avenger): Avenger
    fun delete(id: Long)
    fun update(avenger: Avenger): Avenger
}