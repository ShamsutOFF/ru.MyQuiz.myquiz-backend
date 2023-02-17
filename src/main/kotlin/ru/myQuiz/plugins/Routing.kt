package ru.myQuiz.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import ru.myQuiz.model.Test

fun Application.configureTestRouting() {
    routing {
        get("/1") {
            call.respondText("Hello My World!")
        }
        get("/2") {
            call.respond(Test("Строка", 888))
        }
        get("/3") {
            call.respond(
                listOf(
                    Test("Строка", 888),
                    Test("Second String", 222)
                )
            )
        }
    }
}
