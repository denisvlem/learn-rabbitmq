package com.denisvlem.learnrabbitmqreceiver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class MessageRequestDto {

    private String subject;
    private String message;
    private List<String> recipients;
}
