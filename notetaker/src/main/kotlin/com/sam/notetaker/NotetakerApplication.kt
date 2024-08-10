package com.sam.notetaker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NotetakerApplication

fun main(args: Array<String>) {
	runApplication<NotetakerApplication>(*args)
}
