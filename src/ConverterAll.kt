fun main() {
    println("=== КОНВЕРТЕР ЕДИНИЦ ИЗМЕРЕНИЯ ===\n")

    while (true) {
        println("Выберите тип конвертации:")
        println("1. Длина")
        println("2. Вес")
        println("3. Температура")
        println("0. Выход")
        print("Ваш выбор: ")

        when (readLine()?.toIntOrNull()) {
            1 -> convertLength()
            2 -> convertWeight()
            3 -> convertTemperature()
            0 -> {
                println("Чтобы у вас руки оторвались!")
                return
            }
            else -> println("Неверный выбор, попробуйте снова.\n")
        }
        println()
    }
}

fun convertLength() {
    println("\n=== КОНВЕРТАЦИЯ ДЛИНЫ ===")

    print("Введите значение: ")
    val value = readLine()?.toDoubleOrNull() ?: return

    println("Выберите исходную единицу измерения:")
    println("1. Метры (м)")
    println("2. Сантиметры (см)")
    println("3. Километры (км)")
    println("4. Миллиметры (мм)")
    print("Ваш выбор: ")

    val fromUnit = when (readLine()?.toIntOrNull()) {
        1 -> "м"
        2 -> "см"
        3 -> "км"
        4 -> "мм"
        else -> return
    }

    val meters = when (fromUnit) {
        "м" -> value
        "см" -> value / 100
        "км" -> value * 1000
        "мм" -> value / 1000
        else -> value
    }

    println("\nРезультаты конвертации:")
    println("=".repeat(50))
    println("Метры: ${"%.2f".format(meters)} м")
    println("Сантиметры: ${"%.2f".format(meters * 100)} см")
    println("Километры: ${"%.2f".format(meters / 1000)} км")
    println("Миллиметры: ${"%.2f".format(meters * 1000)} мм")
    println("=".repeat(50))
}

fun convertWeight() {
    println("\n=== КОНВЕРТАЦИЯ ВЕСА ===")

    print("Введите значение: ")
    val value = readLine()?.toDoubleOrNull() ?: return

    println("Выберите исходную единицу измерения:")
    println("1. Килограммы (кг)")
    println("2. Граммы (г)")
    println("3. Тонны (т)")
    println("4. Миллиграммы (мг)")
    print("Ваш выбор: ")

    val fromUnit = when (readLine()?.toIntOrNull()) {
        1 -> "кг"
        2 -> "г"
        3 -> "т"
        4 -> "мг"
        else -> return
    }

    val kilograms = when (fromUnit) {
        "кг" -> value
        "г" -> value / 1000
        "т" -> value * 1000
        "мг" -> value / 1000000
        else -> value
    }

    println("\nРезультаты конвертации:")
    println("=".repeat(50))
    println("Килограммы: ${"%.2f".format(kilograms)} кг")
    println("Граммы: ${"%.2f".format(kilograms * 1000)} г")
    println("Тонны: ${"%.2f".format(kilograms / 1000)} т")
    println("Миллиграммы: ${"%.2f".format(kilograms * 1000000)} мг")
    println("=".repeat(50))
}

fun convertTemperature() {
    println("\n=== КОНВЕРТАЦИЯ ТЕМПЕРАТУРЫ ===")

    print("Введите значение: ")
    val value = readLine()?.toDoubleOrNull() ?: return

    println("Выберите исходную единицу измерения:")
    println("1. Цельсий (°C)")
    println("2. Фаренгейт (°F)")
    println("3. Кельвин (K)")
    print("Ваш выбор: ")

    val fromUnit = when (readLine()?.toIntOrNull()) {
        1 -> "°C"
        2 -> "°F"
        3 -> "K"
        else -> return
    }

    val celsius = when (fromUnit) {
        "°C" -> value
        "°F" -> (value - 32) * 5 / 9
        "K" -> value - 273.15
        else -> value
    }

    println("\nРезультаты конвертации:")
    println("=".repeat(50))
    println("Цельсий: ${"%.2f".format(celsius)} °C")
    println("Фаренгейт: ${"%.2f".format(celsius * 9 / 5 + 32)} °F")
    println("Кельвин: ${"%.2f".format(celsius + 273.15)} K")
    println("=".repeat(50))
}