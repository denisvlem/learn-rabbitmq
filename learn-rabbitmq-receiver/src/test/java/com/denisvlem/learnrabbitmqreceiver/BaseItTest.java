package com.denisvlem.learnrabbitmqreceiver;

import com.denisvlem.learnrabbitmqreceiver.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.lang.NonNull;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.TestPropertySourceUtils;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@ContextConfiguration(initializers = BaseItTest.WiremockInitializer.class)
@Slf4j
public abstract class BaseItTest {

    public static WireMockServer wireMockServer = new WireMockServer(wireMockConfig().dynamicPort());

    static {
        wireMockServer.start();
        int wmPort = wireMockServer.port();
        log.info("WireMock started on port {}", wmPort);
        WireMock.configureFor(wmPort);
    }

    @LocalServerPort
    protected int port;

    @BeforeEach
    public final void setUpEnv() {
        RestAssured.port = port;
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setPort(port)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    @Autowired
    protected MessageService messageService;

    @Autowired
    protected ObjectMapper objectMapper;

    public static class WiremockInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(@NonNull ConfigurableApplicationContext applicationContext) {
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(applicationContext, "wiremock.server.port=" + wireMockServer.port());
        }
    }

}
