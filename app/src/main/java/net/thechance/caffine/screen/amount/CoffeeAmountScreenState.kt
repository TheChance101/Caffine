package net.thechance.caffine.screen.amount

data class CoffeeAmountScreenState(
    val cupSizeInMl: Int = 200,
    val availableSizes: List<String> = listOf("S", "M", "L"),
    val caffineAmountIndex: Int = 1,
    val cupSizeIndex: Int = 1
)
