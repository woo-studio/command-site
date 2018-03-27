package woo.studio.commandsite.commands

import org.axonframework.commandhandling.TargetAggregateIdentifier
import java.math.BigInteger
import java.util.*

data class CreateOrderCommand(
        @TargetAggregateIdentifier
        val id: UUID? = null,
        val product: UUID? = null,
        val direction:Int? = null,
        val price:BigInteger? = null,
        val quantity:BigInteger? = null
)