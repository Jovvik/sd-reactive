package ru.itmo.sd.reactive.service

import org.springframework.stereotype.Service
import ru.itmo.sd.reactive.model.Currency
import java.math.BigDecimal

@Service
class CurrencyService(private val exchangeRateService: ExchangeRateService) {
    fun convert(priceUsd: BigDecimal, currency: Currency): BigDecimal =
        priceUsd * exchangeRateService.exchangeRate(currency)
}