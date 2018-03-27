package woo.studio.commandsite.commands.handlers

import org.axonframework.commandhandling.CommandHandler
import org.axonframework.commandhandling.model.Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import woo.studio.commandsite.aggregates.OrderAggregate
import woo.studio.commandsite.commands.CreateOrderCommand

@Component
class OrderHandler(@Autowired
                   var repository: Repository<OrderAggregate>) {

    @CommandHandler
    fun handle(command: CreateOrderCommand) {
        repository.newInstance {
            OrderAggregate(
                    id = command.id!!,
                    product = command.product!!,
                    direction = command.direction!!,
                    price = command.price!!,
                    quantity = command.quantity!!
            )
        }
    }

}