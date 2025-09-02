import kotlin.random.Random

fun main() {
    var playAgain = true

    while (playAgain) {
        println("=== МИНИ-ИГРА 'УГАДАЙ ЧИСЛО' ===\n")

        // Генерация случайного числа от 1 до 100
        val secretNumber = Random.nextInt(1, 101)
        var attempts = 0
        var guessed = false

        println("Я загадал число от 1 до 100. Попробуй угадать!")
        println("У тебя есть 10 попыток.\n")

        // Основной игровой цикл
        while (attempts < 10 && !guessed) {
            attempts++
            print("Попытка $attempts/10. Введи число: ")

            val guess = readLine()?.toIntOrNull()

            if (guess == null) {
                println("Пожалуйста, введи корректное число!\n")
                continue
            }

            when {
                guess < secretNumber -> {
                    println("Мое число БОЛЬШЕ чем $guess\n")
                }
                guess > secretNumber -> {
                    println("Мое число МЕНЬШЕ чем $guess\n")
                }
                else -> {
                    guessed = true
                    println("🎉 Поздравляю! Ты угадал число $secretNumber!")
                    println("Тебе потребовалось $attempts попыток")
                }
            }
        }

        // Вывод результата игры
        if (!guessed) {
            println("\n😢 К сожалению, ты исчерпал все попытки.")
            println("Загаданное число было: $secretNumber")
        }

        // Статистика игры
        println("\n" + "=".repeat(40))
        println("СТАТИСТИКА ИГРЫ")
        println("=".repeat(40))
        println("Загаданное число: $secretNumber")
        println("Потрачено попыток: $attempts")

        when {
            attempts == 1 -> println("Ты гений! Угадал с первой попытки!")
            attempts <= 3 -> println("Отличный результат!")
            attempts <= 6 -> println("Хорошая игра!")
            attempts <= 9 -> println("Неплохо, но можно лучше!")
            else -> println("Попробуй еще раз!")
        }

        println("=".repeat(40))

        // Предложение сыграть еще раз
        print("\nХочешь сыграть еще раз? (да/нет): ")
        val answer = readLine()?.lowercase()

        playAgain = when (answer) {
            "да", "yes", "д", "y" -> true
            else -> false
        }

        if (playAgain) {
            println("\n" + "=".repeat(40))
        }
    }

    println("Спасибо за игру!")
}