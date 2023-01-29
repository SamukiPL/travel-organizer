package me.samuki.travel.common.algorithms

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeSameSizeAs
import io.kotest.matchers.shouldBe

class LinkedListSortingKtTest : BehaviorSpec({

    lateinit var underTest: List<Pair<String, String?>>

    val correctList = listOf(
        Pair("1", "2"),
        Pair("2", "3"),
        Pair("3", "4"),
        Pair("4", "5"),
        Pair("5", null)
    )
    val incorrectList = listOf(
        Pair("1", "2"),
        Pair("2", "3"),
        Pair("Some itemId is not associated with any other item", "4"),
        Pair("4", null),
    )
    val listWithDoublingIds = listOf(
        Pair("1", "2"),
        Pair("2", "Same Id Two Times"),
        Pair("Same Id Two Times", "3"),
        Pair("Same Id Two Times", "4"),
        Pair("4", null),
    )

    given("List of items with id and nextId, that we want to sort") {
        and("We want to sort correct list with relations for every item in the list") {
            underTest = correctList.shuffled()

            `when`("We invoke linkedSort on shuffled list") {
                val result = underTest.linkedSort(
                    key = { it.first },
                    nextKey = { it.second }
                )

                then("Result should be size of the original list") {
                    result shouldBeSameSizeAs underTest
                }
                then("Result should be sorted like LinkedList") {
                    result shouldBe correctList
                }
            }
        }

        and("We want to sort incorrect") {
            underTest = incorrectList.shuffled()

            `when`("We invoke linkedSort on incorrect list") {
                then("linkedSort should throw exception") {
                    shouldThrow<IllegalStateException> {
                        underTest.linkedSort(
                            key = { it.first },
                            nextKey = { it.second }
                        )
                    }
                }
            }
        }

        and("We want to sort list with doubling ids") {
            underTest = listWithDoublingIds.shuffled()

            `when`("We invoke linkedSort on incorrect list") {
                then("linkedSort should throw exception") {
                    shouldThrow<IllegalStateException> {
                        underTest.linkedSort(
                            key = { it.first },
                            nextKey = { it.second }
                        )
                    }
                }
            }
        }
    }
})
