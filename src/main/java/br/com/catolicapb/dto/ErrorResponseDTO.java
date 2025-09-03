package br.com.catolicapb.dto;

import java.time.LocalDateTime;

public class ErrorResponseDTO {

    private String uriPath;

    private LocalDateTime errorTime;

    private String errorMessage;

    private String httpErrorStatus;
}
