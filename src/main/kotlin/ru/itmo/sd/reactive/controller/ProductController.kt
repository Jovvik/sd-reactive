package ru.itmo.sd.reactive.controller

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.itmo.sd.reactive.model.Product
import ru.itmo.sd.reactive.model.ProductView
import ru.itmo.sd.reactive.repository.ProductRepository
import ru.itmo.sd.reactive.repository.UserRepository
import ru.itmo.sd.reactive.service.CurrencyService
import java.math.BigDecimal
import java.util.UUID

@RestController
@RequestMapping("/products")
class ProductController(
    private val currencyService: CurrencyService,
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository,
) {
    @PostMapping("/add")
    fun addProduct(name: String, priceUsd: BigDecimal): Mono<Product> {
        return productRepository.save(
            Product(
                id = UUID.randomUUID().toString(),
                name = name,
                priceUsd = priceUsd,
            )
        )
    }

    @GetMapping("/all")
    fun getAllProducts(userId: String): Flux<ProductView> {
        return userRepository.findById(userId).flatMapMany { user ->
            return@flatMapMany productRepository.findAll().map {
                ProductView(
                    name = it.name,
                    price = currencyService.convert(it.priceUsd, user.currency)
                )
            }
        }
    }
}