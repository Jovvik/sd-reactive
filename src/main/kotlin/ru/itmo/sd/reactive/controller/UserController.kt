package ru.itmo.sd.reactive.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import ru.itmo.sd.reactive.model.Currency
import ru.itmo.sd.reactive.model.User
import ru.itmo.sd.reactive.repository.UserRepository
import java.util.UUID

@RestController
@RequestMapping("/users")
class UserController(private val userRepository: UserRepository) {
    @PostMapping("/register")
    fun register(name: String, currency: Currency): Mono<User> {
        return userRepository.save(User(
            id = UUID.randomUUID().toString(),
            name = name,
            currency = currency
        ))
    }
}