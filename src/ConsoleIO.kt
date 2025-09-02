fun main() {
    println("=== Программа: Анкета студента ===\n")

    print("Введите ваше имя: ")
    val name = readLine() ?: "Неизвестно"

    print("Введите вашу фамилию: ")
    val surname = readLine() ?: "Неизвестно"

    print("Введите ваш возраст: ")
    val ageInput = readLine()
    val age = ageInput?.toIntOrNull() ?: 0

    print("Введите название вашего университета: ")
    val university = readLine() ?: "Не указан"

    print("Введите номер курса (1-6): ")
    val courseInput = readLine()
    val course = courseInput?.toIntOrNull() ?: 1

    print("Введите вашу среднюю оценку (например, 4.5): ")
    val gradeInput = readLine()
    val averageGrade = gradeInput?.toDoubleOrNull() ?: 0.0

    print("Вы любите программирование? (да/нет): ")
    val programmingLove = readLine()?.lowercase() == "да"

    println("\n" + "=".repeat(40))
    println("АНКЕТА СТУДЕНТА")
    println("=".repeat(40))

    println("Полное имя: $surname $name")
    println("Возраст: $age ${getAgeWord(age)}")
    println("Университет: $university")
    println("Курс: $course")
    println("Средняя оценка: $averageGrade")
    println("Любит программирование: ${if (programmingLove) "Да" else "Нет"}")

    val nextYear = age + 1
    val graduationYear = 2024 + (6 - course)

    println("\nДополнительная информация:")
    println("В следующем году вам будет: $nextYear ${getAgeWord(nextYear)}")
    println("Примерный год окончания: $graduationYear")

    val performanceLevel = when {
        averageGrade >= 4.5 -> "Отличная"
        averageGrade >= 4.0 -> "Хорошая"
        averageGrade >= 3.0 -> "Удовлетворительная"
        else -> "Требует улучшения"
    }

    println("Оценка успеваемости: $performanceLevel")

    val message = if (programmingLove) {
        "Отлично! Продолжайте изучать программирование!"
    } else {
        "Возможно, Kotlin поможет вам полюбить программирование!"
    }

    println("\nСообщение: $message")
    println("=".repeat(40))
}
fun getAgeWord(age: Int): String {
    return when {
        age % 10 == 1 && age % 100 != 11 -> "год"
        age % 10 in 2..4 && age % 100 !in 12..14 -> "года"
        else -> "лет"
    }
}