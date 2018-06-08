package net.chrisrichardson.ftgo.restaurantorderservice.domain;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import net.chrisrichardson.ftgo.common.CommonConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@ComponentScan
@EntityScan
@Import({TramEventsPublisherConfiguration.class, CommonConfiguration.class})
public class RestaurantOrderDomainConfiguration {

  @Bean
  public RestaurantOrderService restaurantOrderService() {
    return new RestaurantOrderService();
  }

  @Bean
  public RestaurantOrderDomainEventPublisher restaurantAggregateEventPublisher(DomainEventPublisher domainEventPublisher) {
    return new RestaurantOrderDomainEventPublisher(domainEventPublisher);
  }
}
