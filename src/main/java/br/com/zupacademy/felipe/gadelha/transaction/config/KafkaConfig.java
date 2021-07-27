package br.com.zupacademy.felipe.gadelha.transaction.config;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import br.com.zupacademy.felipe.gadelha.transaction.v1.dto.TransactionDto;

@EnableKafka
@Configuration
public class KafkaConfig {

	private final KafkaProperties kafkaProperties;

	public KafkaConfig(KafkaProperties kafkaProperties) {
		this.kafkaProperties = kafkaProperties;
	}
	  
	@Bean
	public ConsumerFactory<String, TransactionDto> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(Map.of(
				ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers(),
				ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId(),
				ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getValueDeserializer(),
				ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getKeyDeserializer(),
				ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaProperties.getConsumer().getAutoOffsetReset()
				), 
				new StringDeserializer(),
				new JsonDeserializer<>(TransactionDto.class, false));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, TransactionDto> kafkaListenerContainerFactory() {
		var factory = new ConcurrentKafkaListenerContainerFactory<String, TransactionDto>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
}
