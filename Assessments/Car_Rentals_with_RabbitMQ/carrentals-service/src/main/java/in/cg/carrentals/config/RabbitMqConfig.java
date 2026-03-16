package in.cg.carrentals.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	public static final String EXCHANGE = "passenger.exchange";
	public static final String QUEUE = "passenger.queue";
	public static final String ROUTING_KEY = "passenger.created";

	@Bean
	public Queue queue() {
		return QueueBuilder.durable(QUEUE).build();
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(ROUTING_KEY);
	}

	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory factory) {
		RabbitTemplate template = new RabbitTemplate(factory);
		template.setMessageConverter(converter());
		template.setConfirmCallback((correlationData, ack, cause) -> {
			if (ack) {
				System.out.println("Message delivered successfully");
			} else {
				System.out.println("Message failed: " + cause);
			}
		});
		return template;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory,
			MessageConverter converter) {

		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();

		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(converter);
		return factory;
	}
}