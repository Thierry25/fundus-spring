package com.thierry.fundus.exceptions;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime currentTime, String description, String details) {
}
