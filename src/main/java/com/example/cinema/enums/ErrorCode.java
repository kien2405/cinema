package com.example.cinema.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(500, "Uncategorized error!", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_EXITSTED(403, "User existed!", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(403, "Username must be at least 3 characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(403, "Password must be at least 8 characters", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(403, "Emails must have @", HttpStatus.BAD_REQUEST),
    WRONG_EMAIL(403, "Emails wrong", HttpStatus.BAD_REQUEST),
    WRONG_PASSWORD(403, "Wrong password", HttpStatus.BAD_REQUEST),
    INVALID_KEY(403,"Invalid message key!", HttpStatus.BAD_REQUEST),
    OTP_TIME_OUT(403,"OTP time out!", HttpStatus.BAD_REQUEST),
    ERROR_SENDING_EMAIL(403,"Error sending email", HttpStatus.BAD_REQUEST),
    INVALID_OTP_CODE(403,"Invalid OTP code", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(400, "User does'nt exist!", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(401, "Unauthenticated!", HttpStatus.UNAUTHORIZED),
    RESEND_TOO_SOON(403, "Wait 1 minute to send again", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(403, "You do not have permission!", HttpStatus.FORBIDDEN)



    ;
    private Integer code;
    private String message;
    private HttpStatusCode statusCode;
}
