package woo.studio.commandsite.aggregates

import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.commandhandling.model.AggregateLifecycle.apply
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.spring.stereotype.Aggregate
import woo.studio.commandsite.events.OrderCreateEvent
import java.math.BigInteger
import java.util.*

@Aggregate
class OrderAggregate {

    @AggregateIdentifier
    lateinit var id: UUID

    lateinit var product: UUID

    lateinit var price: BigInteger

    lateinit var quantity: BigInteger

    var direction: Int = 1

    constructor()

    constructor(id: UUID, product: UUID, direction: Int, price: BigInteger, quantity: BigInteger) {
        apply(OrderCreateEvent(
                id = id,
                product = product,
                direction = direction,
                price = price,
                quantity = quantity
        ))
    }

    @EventSourcingHandler
    fun on(event: OrderCreateEvent) {
        this.id = event.id!!
        this.product = event.product!!
        this.direction = event.direction!!
        this.price = event.price!!
        this.quantity = event.quantity!!
    }

}