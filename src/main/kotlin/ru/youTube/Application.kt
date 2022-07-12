package ru.youTube

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ru.youTube.database.DatabaseFactory
import ru.youTube.plugins.*
import ru.youTube.routing.configureMainRouting

fun main() {
    embeddedServer(
        Netty,
        environment = applicationEngineEnvironment {

            build {
//                rootPath = "youTube"
//
//                config = ApplicationConfig(
//                    configPath = "https://api.cfif31.ru/youTube/"
//                )
            }

            module {
                DatabaseFactory.init()

                installPlugins()
                configureMainRouting()
            }

            connector {
                port = 8080
                host = "0.0.0.0"
            }
        }
    ).start(wait = true)
}