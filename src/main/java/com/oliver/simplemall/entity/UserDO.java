package com.oliver.simplemall.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserDO {
    private String userId;

    private String username;

    private String password;

    private String email;

    private String gender;

    private String phoneNumber;

    private int userAuthority;
}
