package ru.itmo.sd.reactive.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class User(
    @Id val id: String,
    val name: String,
    val currency: Currency
)