package christmas.util

enum class Badge(val badgeName: String, val criteriaAmount: Int) {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000),
    NOTHING("없음", 0)
}