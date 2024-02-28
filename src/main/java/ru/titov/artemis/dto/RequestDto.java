package ru.titov.artemis.dto;

import lombok.Builder;

@Builder
public record RequestDto(String queue, String message) {
}