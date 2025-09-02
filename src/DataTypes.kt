fun main() {
    println("=== Демонстрация типов данных в Kotlin ===\n")

    val byteMax: Byte = 127
    val shortMax: Short = 32767
    val intMax = 2147483647
    val longMax = 9223372036854775807L
    val floatPi = 3.14159F
    val doublePi = 3.14159265359

    println("Числовые типы:")
    println("Byte (максимум): $byteMax")
    println("Short (максимум): $shortMax")
    println("Int (максимум): $intMax")
    println("Long (максимум): $longMax")
    println("Float π: $floatPi")
    println("Double π: $doublePi")

    val isKotlinFun = true
    val isProgrammingHard = false

    println("\nЛогические значения:")
    println("Kotlin интересный? $isKotlinFun")
    println("Программирование сложное? $isProgrammingHard")

    val grade: Char = '5'
    val letter: Char = 'К'

    println("\nСимволы:")
    println("Оценка: $grade")
    println("Первая буква Kotlin: $letter")

    val studentName = "Иван Петров"
    val groupNumber = "ИП-21"
    val welcomeMessage = "Добро пожаловать в мир Kotlin, $studentName из группы $groupNumber!"

    println("\nСтроки:")
    println("Имя студента: $studentName")
    println("Группа: $groupNumber")
    println(welcomeMessage)

    val schedule = """
 Расписание на понедельник:
 09:00 - Математика
 10:45 - Программирование на Kotlin
 12:30 - Обед
 13:30 - Английский язык
 """.trimIndent()

    println("\n$schedule")

    println("\n=== Преобразование типов ===")
    val intNumber = 42
    val doubleFromInt = intNumber.toDouble()
    val stringFromInt = intNumber.toString()
    val floatFromInt = intNumber.toFloat()

    println("Исходное число (Int): $intNumber")
    println("Преобразованное в Double: $doubleFromInt")
    println("Преобразованное в String: \"$stringFromInt\"")
    println("Преобразованное в Float: $floatFromInt")

    val autoInt = 100
    val autoDouble = 3.14
    val autoString = "Автоопределение"
    val autoBoolean = false

    println("\n=== Автоматическое определение типов ===")
    println("autoInt имеет тип: ${autoInt::class.simpleName}")
    println("autoDouble имеет тип: ${autoDouble::class.simpleName}")
    println("autoString имеет тип: ${autoString::class.simpleName}")
    println("autoBoolean имеет тип: ${autoBoolean::class.simpleName}")
}