package br.com.sboot.colaboradores.config;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisTemplateConfig {
	
	 private final StringRedisTemplate template;

	    public RedisTemplateConfig(StringRedisTemplate template) {
	        this.template = template;
	    }

	    public Boolean someMethod() {
	        return this.template.hasKey("spring");
	    }
	
}
