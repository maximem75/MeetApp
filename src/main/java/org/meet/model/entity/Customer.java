package org.meet.model.entity;

import io.swagger.annotations.Api;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.meet.enums.ECustomerState;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

//@Document(collection = "customer")
@Api("Customer")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    String id;

    @NonNull
    String firstname;

    @NonNull
    String lastname;

    @NonNull
    String email;

    @NonNull
    String password;

    ECustomerState state;

    @NonNull
    LocalDate birthday;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}

