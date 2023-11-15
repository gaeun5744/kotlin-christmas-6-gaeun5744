package christmas.util

enum class DecemberEvent(val eventName: String, val period: List<Int>, val benefitAmount: Int) {
    WEEK_EVENT("평일 할인", listOf(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31), 2_023),
    WEEKEND_EVENT("주말 할인", listOf(1, 2, 8, 9, 15, 16, 22, 23, 29, 30), 2_023),
    SPECIAL_EVENT("특별 할인", listOf(3, 10, 17, 24, 45, 31), 1_000),
    PRESENT_EVENT("증정 이벤트", (1..31).toList(), 25_000),
    CHRISTMAS_EVENT("크리스마스 디데이 할인", (1..25).toList(), 1_000)
}