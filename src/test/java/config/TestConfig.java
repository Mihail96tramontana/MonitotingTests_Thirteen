package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties_examples")
    public interface TestConfig extends Config {
        String login();
        String password();
    }
