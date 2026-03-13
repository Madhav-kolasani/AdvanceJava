package in.cg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import feign.codec.ErrorDecoder;

@Configuration
public class FeignConfig {
	@Primary
	@Bean
	public ErrorDecoder errorDecoder() {
		return new ErrorDecoder.Default();
	}
}
