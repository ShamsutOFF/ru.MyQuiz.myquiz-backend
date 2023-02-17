package ru.myQuiz

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import ru.myQuiz.fetures.login.configureLoginRouting
import ru.myQuiz.fetures.register.configureRegisterRouting
import ru.myQuiz.plugins.*

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureTestRouting()

    configureRegisterRouting()
    configureLoginRouting()
    configureSerialization()
}
