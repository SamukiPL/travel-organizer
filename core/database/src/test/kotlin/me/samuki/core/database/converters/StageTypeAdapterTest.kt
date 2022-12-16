package me.samuki.core.database.converters

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import me.samuki.core.domain.StageType

class StageTypeAdapterTest : BehaviorSpec({

    lateinit var underTest: StageTypeAdapter

    given("StageTypeAdapter") {
        underTest = StageTypeAdapter()

        StageType.values().forEach { type ->
            and("using String with StageType.$type name") {
                val typeName = type.name

                `when`("StageTypeAdapter.decode is invoked") {
                    val returned = underTest.decode(typeName)

                    then("returned value is a StageType.$type enum") {
                        returned shouldBe type
                    }
                }
            }

            and("using StageType.$type") {
                `when`("StageTypeAdapter.encode is invoked") {
                    val returned = underTest.encode(type)

                    then("returned value is a string of enum name \"${type.name}\"") {
                        returned shouldBe type.name
                    }
                }
            }
        }
    }

})
