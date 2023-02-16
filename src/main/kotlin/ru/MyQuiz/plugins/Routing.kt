package ru.MyQuiz.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import ru.MyQuiz.model.Test

fun Application.configureRouting() {
    routing {
        get("/1") {
            call.respondText("Hello My World!")
        }
        get("/2") {
            call.respond(Test("Строка", 888))
        }
    }
}
