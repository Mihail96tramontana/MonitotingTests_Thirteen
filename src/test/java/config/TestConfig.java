package config;

import org.aeonbits.owner.Config;

@TestConfig.Sources("classpath:config/credentials.properties")
    public interface TestConfig extends TestConfig {
        String login();
        String password();
    }
