package ru.itmo.sd.reactive.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import ru.itmo.sd.reactive.model.Product

@Repository
interface ProductRepository : ReactiveCrudRepository<Product, String>