fun main() {
    println("=== КАЛЬКУЛЯТОР УСПЕВАЕМОСТИ ===\n")

    print("Введите количество предметов: ")
    val subjectCount = readLine()?.toIntOrNull() ?: return

    val subjects = mutableListOf<String>()
    val grades = mutableListOf<Double>()

    // Ввод данных о предметах и оценках
    for (i in 1..subjectCount) {
        print("Введите название предмета $i: ")
        val subject = readLine() ?: "Предмет $i"
        subjects.add(subject)

        print("Введите оценку по предмету '$subject': ")
        val grade = readLine()?.toDoubleOrNull() ?: 0.0
        grades.add(grade)
        println()
    }

    // Вычисления
    val averageGrade = if (grades.isNotEmpty()) grades.average() else 0.0
    val maxGrade = grades.maxOrNull() ?: 0.0
    val minGrade = grades.minOrNull() ?: 0.0

    // Определение уровня успеваемости
    val performanceLevel = when {
        averageGrade >= 4.5 -> "Отличник"
        averageGrade >= 4.0 -> "Хорошист"
        averageGrade >= 3.0 -> "Троечник"
        else -> "Требуется подтянуть учебу"
    }

    // Вывод отчета
    println("=".repeat(50))
    println("ОТЧЕТ ОБ УСПЕВАЕМОСТИ")
    println("=".repeat(50))

    println("Предметы и оценки:")
    for (i in subjects.indices) {
        println(" ${subjects[i]}: ${grades[i]}")
    }

    println("\nСтатистика:")
    println("Средний балл: %.2f".format(averageGrade))
    println("Наивысшая оценка: $maxGrade")
    println("Наименьшая оценка: $minGrade")
    println("Уровень: $performanceLevel")

    // Рекомендации
    println("\nРекомендации:")
    when {
        averageGrade >= 4.5 -> println("Превосходная работа! Продолжайте в том же духе!")
        averageGrade >= 4.0 -> println("Хорошие результаты! Есть потенциал для отличных оценок.")
        averageGrade >= 3.0 -> println("Средние результаты. Рекомендуется больше времени уделять учебе.")
        else -> println("Необходимо серьезно заняться учебой и обратиться за помощью к преподавателям.")
    }

    println("=".repeat(50))
}