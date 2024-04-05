package com.example.cinema.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserForgetPasswordRequest {
    String email;
    String otp;
    String newPassword;
}
