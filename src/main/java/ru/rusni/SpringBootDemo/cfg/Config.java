package ru.rusni.SpringBootDemo.cfg;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rusni.SpringBootDemo.DevProfile;
import ru.rusni.SpringBootDemo.ProductionProfile;
import ru.rusni.SpringBootDemo.SystemProfile;

@Configuration
public class Config {
    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "true", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}