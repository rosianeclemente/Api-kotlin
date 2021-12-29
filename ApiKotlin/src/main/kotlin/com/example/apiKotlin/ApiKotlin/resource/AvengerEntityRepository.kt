package com.example.apiKotlin.ApiKotlin.resource

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AvengerEntityRepository : JpaRepository<AvengerEntity, Long> {
}