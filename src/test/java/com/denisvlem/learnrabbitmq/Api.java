package com.denisvlem.learnrabbitmq;

import com.denisvlem.learnrabbitmq.dto.MessageRequestDto;
import io.restassured.response.Response;
import com.denisvlem.learnrabbitmq.controller.MessageController;

import static io.restassured.RestAssured.given;

public class Api {

    /**
     * {@link MessageController#doPostSendMessage}
     */
    public static Response doPostSendMessage(MessageRequestDto dto) {
        return given().when().body(dto).post("/message/send");
    }
}
