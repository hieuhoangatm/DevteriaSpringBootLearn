package com.hieu.SpringJPA.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
    String username;
    @Size(min=8,message = "PASSWORD_INVALID")
    String password;
    String firstname;
    String lastname;
    LocalDate dob;
}
