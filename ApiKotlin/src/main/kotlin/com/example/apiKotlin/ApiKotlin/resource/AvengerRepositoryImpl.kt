package com.example.apiKotlin.ApiKotlin.resource

import com.example.apiKotlin.ApiKotlin.domain.Avenger.Avenger
import com.example.apiKotlin.ApiKotlin.domain.AvengerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class AvengerRepositoryImpl (@Autowired private val repository: AvengerEntityRepository): AvengerRepository{
    override fun getDetail(id: Long): Avenger? =
        repository.findByIdOrNull(id)?.toAvenger()

    override fun getAvenger(): List<Avenger> =
        repository.findAll().map { it.toAvenger() }

    override fun create(avenger: Avenger): Avenger =
        repository.save(AvengerEntity.from(avenger)).toAvenger()

    override fun delete(id: Long) =
        repository.deleteById(id)




    override fun update(avenger: Avenger): Avenger =
        repository.save(AvengerEntity.from(avenger)).toAvenger()


}