package woo.studio.commandsite.config

import org.axonframework.commandhandling.model.Repository
import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.eventsourcing.eventstore.EventStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import woo.studio.commandsite.aggregates.OrderAggregate

@Configuration
class OrderConfig {

    @Autowired
    lateinit var eventStore: EventStore

    @Bean
    fun orderAggregateRepository(): Repository<OrderAggregate> {
        return EventSourcingRepository<OrderAggregate>(OrderAggregate::class.java, eventStore)
    }

}