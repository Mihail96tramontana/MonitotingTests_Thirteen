package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
    public interface TestConfig extends Config {
        String login();
        String password();
    }
