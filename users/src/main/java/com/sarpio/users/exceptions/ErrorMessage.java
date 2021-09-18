package com.sarpio.users.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private int statusCode;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date timestamp;
    private String message;
    private String description;
}
