package com.sparta.limited.user_coupon_service.infrastructure.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

@Configuration
public class RedisLuaConfig {

    @Bean
    public DefaultRedisScript<String> stockAndDuplicateScript() {
        DefaultRedisScript<String> script = new DefaultRedisScript<>();
        script.setScriptSource(new ResourceScriptSource(
            new ClassPathResource(RedisScriptKey.CREATE_ISSUE_COUPON.getLuaScripName())
        ));
        script.setResultType(String.class);
        return script;
    }

}
