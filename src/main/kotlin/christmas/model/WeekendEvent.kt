package christmas.model

import christmas.model.CalculateResult.getTotalOrderAmount
import christmas.util.Menu

class WeekendEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = listOf(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
    private val benefitAmount = 2_023

    fun getBenefitAmount(): Int {

        if (!checkMatch()) return 0
        return -getCountMain() * benefitAmount
    }

    private fun checkMatch(): Boolean =
        date in period && getCountMain() > 0 && getTotalOrderAmount(order) > 10_000


    private fun getCountMain(): Int {
        val dessertName = Menu.MAIN.detailMenu.map { it.menuName }
        return dessertName.intersect(order.keys).size
    }
}