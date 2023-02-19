package ru.myQuiz.fetures.login

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.myQuiz.cache.InMemoryCache
import ru.myQuiz.cache.TokenCache
import java.util.UUID

fun Application.configureLoginRouting() {
    routing {
        post("/login") {
            val receive = call.receive<LoginReceiveRemote>()
            val user = InMemoryCache.userList.firstOrNull { it.login == receive.login }
            if (user == null) {
                call.respond(HttpStatusCode.BadRequest, " User not found")
            } else if (user.password != receive.password) {
                call.respond(HttpStatusCode.BadRequest, "Invalid password")
            } else {
                val token = UUID.randomUUID().toString()
                InMemoryCache.token.add(TokenCache(login = receive.login, token = token))
                call.respond(LoginResponseRemote(token = token))
            }
        }
    }
}