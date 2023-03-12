package ru.itmo.sd.reactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveApplication

fun main(args: Array<String>) {
    runApplication<ReactiveApplication>(*args)
}
