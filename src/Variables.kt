fun main() {

    val name = "Иван"
    var age = 19
    val city = "Майкоп"

    println("=== Информация обо мне ===")
    println("Имя: $name")
    println("Возраст: $age")
    println("Город: $city")

    var counter = 0

    println("\n=== Счетчик ===")
    counter++
    println("Счетчик после первого увеличения: $counter")

    counter++
    println("Счетчик после второго увеличения: $counter")
}

fun counterExample() {
    var count = 0

    count = count + 1


    println("Итоговое значение счетчика: $count")
}