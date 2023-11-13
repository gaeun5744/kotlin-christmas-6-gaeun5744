package christmas

enum class Menu(val detailMenu: List<DetailMenu>) {
    APPETIZERS(listOf(DetailMenu.MUSHROOM_SOUP, DetailMenu.TAPAS, DetailMenu.CAESAR_SALAD)),
    MAIN(
        listOf(
            DetailMenu.TBONE_STEAK,
            DetailMenu.BARBCUED_RIBS,
            DetailMenu.SEAFOOD_PASTA,
            DetailMenu.CHRISTMAS_PASTE
        )
    ),
    DESSERT(listOf(DetailMenu.CHOCOLATE_CAKE, DetailMenu.ICE_CREAM)),
    DRINK(listOf(DetailMenu.ZERO_COKE, DetailMenu.RED_WINE, DetailMenu.SHAMPANGE))
}

enum class DetailMenu(val menuName: String, val price: Int) {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000),
    TBONE_STEAK("티본스테이크", 55_000),
    BARBCUED_RIBS("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTE("크리스마스파스타", 25_000),
    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000),
    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 6_000),
    SHAMPANGE("샴페인", 25_000);
}
