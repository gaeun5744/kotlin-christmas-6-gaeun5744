package christmas.util


object ErrorMessage {

    const val INVALID_DATE = "$ERROR 유효하지 않은 날짜입니다. $RETRY_MESSAGE"
    const val INVALID_MENU = "$ERROR 유효하지 않은 주문입니다. $RETRY_MESSAGE"
    const val ORDER_ONLY_DRINK = "$ERROR 음료만 주문할 수 없습니다. $RETRY_MESSAGE"
    const val ORDER_MORE_20 = "$ERROR 20개 이상 주문할 수 없습니다. $RETRY_MESSAGE"

}

private const val RETRY_MESSAGE = "다시 입력해 주세요."
private const val ERROR = "[ERROR]"