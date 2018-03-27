package woo.studio.commandsite

import org.axonframework.test.aggregate.AggregateTestFixture
import org.axonframework.test.aggregate.FixtureConfiguration
import org.junit.Before
import org.junit.Test
import woo.studio.commandsite.aggregates.OrderAggregate
import woo.studio.commandsite.commands.CreateOrderCommand
import woo.studio.commandsite.commands.handlers.OrderHandler
import woo.studio.commandsite.events.OrderCreateEvent
import java.math.BigInteger
import java.util.*

class OrderTests {

    lateinit var fixture: FixtureConfiguration<OrderAggregate>

    @Before
    fun setUp() {
        fixture = AggregateTestFixture<OrderAggregate>(OrderAggregate::class.java)
        fixture.registerAnnotatedCommandHandler(OrderHandler(fixture.repository))
    }

    @Test
    fun createCommand() {
        val orderId = UUID.randomUUID()
        val product = UUID.randomUUID()
        val direction = 1
        val price = BigInteger("10000")
        val quantity = BigInteger("1000")
        fixture.given()
                .`when`(CreateOrderCommand(
                        id = orderId,
                        product = product,
                        direction = direction,
                        price = price,
                        quantity = quantity
                )).expectSuccessfulHandlerExecution()
                .expectEvents(OrderCreateEvent(
                        id = orderId,
                        product = product,
                        direction = direction,
                        price = price,
                        quantity = quantity
                ))
    }


}