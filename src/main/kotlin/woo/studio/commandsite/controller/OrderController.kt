package woo.studio.commandsite.controller

import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import woo.studio.commandsite.commands.CreateOrderCommand
import java.math.BigInteger
import java.util.*

@RestController
@RequestMapping("/order")
class OrderController {

    @Autowired
    lateinit var commandGateway: CommandGateway

    @RequestMapping("/", method = [RequestMethod.POST])
    fun create() {
        val id = UUID.randomUUID()
        val product = UUID.randomUUID()
        val direction = 1
        val price = BigInteger("10000")
        val quantity = BigInteger("1000")
        commandGateway.sendAndWait<String>(CreateOrderCommand(
                id = id,
                product = product,
                direction = direction,
                price = price,
                quantity = quantity
        ))
    }

}