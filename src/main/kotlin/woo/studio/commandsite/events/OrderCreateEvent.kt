package woo.studio.commandsite.events

import org.axonframework.commandhandling.TargetAggregateIdentifier
import java.math.BigInteger
import java.util.*

data class OrderCreateEvent(
        @TargetAggregateIdentifier
        val id: UUID? = null,
        val product: UUID? = null,
        val direction: Int? = null,
        val price: BigInteger? = null,
        val quantity: BigInteger? = null
)