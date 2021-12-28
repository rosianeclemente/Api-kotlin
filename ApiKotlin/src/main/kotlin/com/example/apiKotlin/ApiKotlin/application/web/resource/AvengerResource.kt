package com.example.apiKotlin.ApiKotlin.application.web.resource

import com.example.apiKotlin.ApiKotlin.application.domain.AvengerRepository
import com.example.apiKotlin.ApiKotlin.application.web.resource.request.AvengerRequest
import com.example.apiKotlin.ApiKotlin.application.web.resource.response.AvengerResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid

private const val API_PATH = "/v1/api/avenger"
@RestController
@RequestMapping(value = [API_PATH])
class AuthorityResource(
    @Autowired private val repository: AvengerRepository
) {

    @GetMapping
    @Transactional(readOnly = true)
    fun getAvengers() = repository.getAvenger().map { AvengerResponse.from(it)}
        .let {
            ResponseEntity.ok().body(it)
    }


    @GetMapping("{id")
    fun getAvengersDetails(@PathVariable("id") id: Long) =
        repository.getDetail(id).let{
            ResponseEntity.ok().body(AvengerResponse.from(it))
        } ?: ResponseEntity.notFound().build<Void>()


    @PostMapping
    fun createAvenger(@Valid @RequestBody request: AvengerRequest) =
        request.toAvenger().run{
            repository.create(this)
        }.let {
            ResponseEntity.created(URI("$API_PATH/${it.id}")).body(AvengerResponse.from(it))
        }
    @PutMapping("{id}")
    fun updateAvenger(@Valid @RequestBody request: AvengerRequest, @PathVariable("id") id: Long) =
        repository.getDetail(id)?.let {
            AvengerRequest.to(it.id, request).apply {
               repository.update(this)

            }.let {
                ResponseEntity.ok().body(AvengerResponse.from(it))
            }
        } ?: ResponseEntity.notFound().build<Void>()

    @DeleteMapping("id")
    fun deleteAvenger(@PathVariable("id") id: Long) =
        repository.delete(id).let {
            ResponseEntity.accepted().build<Void>()
        }

}