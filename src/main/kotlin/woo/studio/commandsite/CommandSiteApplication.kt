package woo.studio.commandsite

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CommandSiteApplication

fun main(args: Array<String>) {
    runApplication<CommandSiteApplication>(*args)
}
