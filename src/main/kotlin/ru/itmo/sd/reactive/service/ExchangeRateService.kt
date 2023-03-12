package ru.itmo.sd.reactive.service

import org.springframework.stereotype.Service
import ru.itmo.sd.reactive.model.Currency
import java.math.BigDecimal

@Service
class ExchangeRateService {
    fun exchangeRate(currency: Currency): BigDecimal =
        when (currency) {
            Currency.USD -> BigDecimal.ONE
            Currency.EUR -> BigDecimal.valueOf(1.07)
            Currency.RUB -> BigDecimal.valueOf(0.013)
        }
}