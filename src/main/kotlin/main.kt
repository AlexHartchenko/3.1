package ru.netology

fun main() {

    val absenceTime = 70_000

    agoToText(absenceTime)
}

private fun agoToText(absenceTime: Int) {
    when (absenceTime) {
        in 0..60 -> println("Был(а) только что")
        in 61..3_600 -> {
            val time = absenceTime / 60
            val minutesToText = minutes(time)
            println("Был(а) $time $minutesToText назад")
        }
        in 3_601..86_400 -> {
            val time = (absenceTime / 3_600)
            val hoursToText = hours(time)
            println("Был(а) $time $hoursToText назад")
        }
        in 86_401..172_800 -> println("Был(а) сегодня")
        in 172_801..259_200 -> println("Был(а) вчера")
        else -> println("Был(а) давно, уж и не помним когда :)")
    }
}

private fun minutes(time: Int): String {
    return when (time) {
        1, 21, 31, 41, 51 -> "минуту"
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "минуты"
        in 5..20, in 25..30, in 35..40, in 45..50, in 55..60 -> "минут"
        else -> ""
    }
}

private fun hours(time: Int): String {
    return when (time) {
        1, 21 -> "час"
        in 2..4, 22, 23 -> "часа"
        in 5..20 -> "часов"
        else -> ""
    }
}