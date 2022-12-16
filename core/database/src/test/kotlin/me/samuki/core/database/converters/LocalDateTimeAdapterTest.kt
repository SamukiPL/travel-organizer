package me.samuki.core.database.converters

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kotlinx.datetime.toKotlinLocalDateTime
import java.time.LocalDateTime as JavaLocalDateTime

class LocalDateTimeAdapterTest : BehaviorSpec({

    lateinit var underTest: LocalDateTimeAdapter

    given("LocalDateTimeAdapter") {
        underTest = LocalDateTimeAdapter()

        and("using string of date") {
            val date = JavaLocalDateTime.now().toKotlinLocalDateTime()
            val dateInString = date.toString()

            `when`("LocalDateTime.decode is invoked") {
                val returnedValue = underTest.decode(dateInString)

                then("returned value is a correct date") {
                    returnedValue shouldBe date
                }
            }
        }

        and("using kotlinx.datetime.LocalDateTime") {
            val currentTime = JavaLocalDateTime.now().toKotlinLocalDateTime()

            `when`("LocalDateTime.encode is invoked") {
                val returnedValue = underTest.encode(currentTime)

                then("retruned value is string of date") {
                    returnedValue shouldBe currentTime.toString()
                }
            }
        }
    }

})
