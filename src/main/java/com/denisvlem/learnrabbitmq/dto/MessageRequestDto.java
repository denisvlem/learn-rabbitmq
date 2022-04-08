package com.denisvlem.learnrabbitmq.dto;

import java.util.List;

public record MessageRequestDto(String subject, String content, List<String> recipients) {}
