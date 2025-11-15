package org.example

import org.jsoup.Jsoup
import org.jsoup.select.Elements

fun main() {
    val url = "https://mybook.ru/author/duglas-adams/avtostopom-po-galaktike-restoran-u-konca-vselennoj/citations/"

    val doc = Jsoup.connect(url)
        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36")
        .timeout(10000)
        .get()

    val elements: Elements = doc.select("div.sc-2aegk7-2, bzpNIu")

    val quoteList = elements.map { it.text().trim() }

    println("--- Парсер цитат из 'Автостопом по галактике' ---\n")

    if (quoteList.isNotEmpty()) {
        println("Найдено ${quoteList.size} цитат:\n")

        quoteList.forEachIndexed { index, quote ->
            println("${index + 1}. $quote\n")
        }
    } else {
        println("Цитаты не найдены.")
    }
}