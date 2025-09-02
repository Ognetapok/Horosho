package com.example.basics
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
fun main() {

    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")

    println("=== Структура программы Kotlin ===")
    println("Автор: Студент группы X")
    println("Дата запуска: ${currentDateTime.format(formatter)}")
    println("Версия Kotlin: ${KotlinVersion.CURRENT}")
}