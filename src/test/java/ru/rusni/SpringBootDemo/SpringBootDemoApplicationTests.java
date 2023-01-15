package ru.rusni.SpringBootDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootDemoApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;
    @Container
    private final GenericContainer<?> myDevApp = new GenericContainer<>("devapp")
            .withExposedPorts(8080);
    @Container
    private final GenericContainer<?> myProdApp = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    @Test
    void contextLoads() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(
                "http://localhost:" + myDevApp.getMappedPort(8080) + "/profile",
                String.class
        );
        System.out.println("Dev: " + forEntity.getBody());
        assertEquals(forEntity.getBody(), "Current profile is dev");

        forEntity = restTemplate.getForEntity(
                "http://localhost:" + myProdApp.getMappedPort(8081) + "/profile",
                String.class
        );
        System.out.println("Prod: " + forEntity.getBody());
        assertEquals(forEntity.getBody(), "Current profile is prod");
    }

}
