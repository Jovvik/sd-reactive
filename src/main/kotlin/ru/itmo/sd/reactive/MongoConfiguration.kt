package ru.itmo.sd.reactive

import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories


@EnableMongoRepositories
class MongoConfiguration : AbstractReactiveMongoConfiguration() {
    override fun getDatabaseName(): String = "products"
}