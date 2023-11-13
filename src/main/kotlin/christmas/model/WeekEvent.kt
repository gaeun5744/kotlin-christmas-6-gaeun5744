package christmas.model

import christmas.model.CalculateResult.getTotalOrderAmount
import christmas.util.Menu

class WeekEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = listOf(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 45, 26, 27, 28, 31)
    private val benefitAmount = 2_023

    fun getBenefitAmount(): Int {
        if (!checkMatch()) return 0
        return -getCountDessert() * benefitAmount
    }

    fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > 0 && getTotalOrderAmount(order) > 10_000


    private fun getCountDessert(): Int {
        val dessertName = Menu.DESSERT.detailMenu.map { it.menuName }
        return dessertName.intersect(order.keys).size
    }


}