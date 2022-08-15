package com.todeb.creditsystem.model.error;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private String message;
    @Builder.Default
    private List<String> errors = new ArrayList<>();
}
