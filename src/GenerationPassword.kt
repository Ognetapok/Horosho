import kotlin.random.Random

fun main() {
    println("=== ГЕНЕРАТОР ПАРОЛЕЙ ===\n")

    // Запрос длины пароля
    print("Введите длину пароля (от 6 до 32): ")
    val length = readLine()?.toIntOrNull() ?: 12

    if (length < 6 || length > 32) {
        println("Длина должна быть от 6 до 32 символов. Установлена длина по умолчанию: 12")
    }

    val validLength = if (length in 6..32) length else 12

    // Выбор типов символов
    println("\nВыберите типы символов для пароля:")
    println("1. Буквы (A-Z, a-z)")
    println("2. Цифры (0-9)")
    println("3. Специальные символы (!@#\$%^&*()_+-=)")
    println("4. Все типы символов")
    print("Ваш выбор: ")

    val choice = readLine()?.toIntOrNull() ?: 4

    val includeLetters = choice == 1 || choice == 4
    val includeDigits = choice == 2 || choice == 4
    val includeSpecial = choice == 3 || choice == 4

    // Генерация пароля
    val password = generatePassword(validLength, includeLetters, includeDigits, includeSpecial)

    // Вывод результатов
    println("\n" + "=".repeat(50))
    println("СГЕНЕРИРОВАННЫЙ ПАРОЛЬ")
    println("=".repeat(50))
    println("Пароль: $password")
    println("Длина: ${password.length} символов")

    // Оценка сложности
    val strength = evaluatePasswordStrength(password)
    println("Сложность: $strength")

    // Рекомендации
    println("\nРекомендации:")
    when (strength) {
        "Очень слабый" -> println("Используйте больше различных типов символов и увеличьте длину")
        "Слабый" -> println("Добавьте специальные символы и цифры")
        "Среднячок" -> println("Хороший пароль, можно добавить больше символов")
        "Мощный" -> println("Отличный пароль!")
        "Слишком мощный" -> println("Превосходный пароль! Идеальная защита!")
    }

    println("=".repeat(50))
}

fun generatePassword(length: Int, includeLetters: Boolean, includeDigits: Boolean, includeSpecial: Boolean): String {
    val letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    val digits = "0123456789"
    val special = "!@#\$%^&*()_+-=[]{}|;:,.<>?/"

    var charPool = ""

    if (includeLetters) charPool += letters
    if (includeDigits) charPool += digits
    if (includeSpecial) charPool += special

    // Если ничего не выбрано, используем все типы
    if (charPool.isEmpty()) charPool = letters + digits + special

    return StringBuilder().apply {
        repeat(length) {
            val randomIndex = Random.nextInt(charPool.length)
            append(charPool[randomIndex])
        }
    }.toString()
}

fun evaluatePasswordStrength(password: String): String {
    var score = 0

    // Проверка длины
    when (password.length) {
        in 6..8 -> score += 1
        in 9..12 -> score += 2
        in 13..16 -> score += 3
        else -> score += 4
    }

    // Проверка наличия разных типов символов
    val hasUpperCase = password.any { it.isUpperCase() }
    val hasLowerCase = password.any { it.isLowerCase() }
    val hasDigits = password.any { it.isDigit() }
    val hasSpecial = password.any { !it.isLetterOrDigit() }

    if (hasUpperCase) score += 1
    if (hasLowerCase) score += 1
    if (hasDigits) score += 1
    if (hasSpecial) score += 2

    // Определение сложности
    return when (score) {
        in 0..2 -> "Очень слабый"
        in 3..4 -> "Слабый"
        in 5..6 -> "Среднячок"
        in 7..8 -> "Мощный"
        else -> "Слишком мощный"
    }
}