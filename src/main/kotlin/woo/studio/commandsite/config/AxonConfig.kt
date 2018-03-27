package woo.studio.commandsite.config

import com.mongodb.MongoClient
import com.mongodb.ServerAddress
import org.axonframework.eventsourcing.eventstore.EventStorageEngine
import org.axonframework.mongo.DefaultMongoTemplate
import org.axonframework.mongo.MongoTemplate
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine
import org.axonframework.mongo.eventsourcing.eventstore.MongoFactory
import org.axonframework.mongo.eventsourcing.eventstore.documentperevent.DocumentPerEventStorageStrategy
import org.axonframework.serialization.json.JacksonSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AxonConfig {

    @Bean
    fun mongoClient(): MongoClient {
        val factory = MongoFactory()
        factory.setMongoAddresses(arrayListOf(ServerAddress("localhost")))
        return factory.createMongo()
    }

    @Bean
    fun axonMongoTemplate(): MongoTemplate {
        return DefaultMongoTemplate(mongoClient(), "axon-demo")
    }

    @Bean
    fun eventStorageEngine(): EventStorageEngine {
        return MongoEventStorageEngine(
                JacksonSerializer(),
                null,
                axonMongoTemplate(),
                DocumentPerEventStorageStrategy())
    }

}