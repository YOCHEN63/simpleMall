package com.oliver.simplemall.entity;

import lombok.Data;

@Data
public class UserDo {
    private String id;

    private String username;

    private String password;

    private String email;

    private String gender;

    private String phoneNumber;

    private int userAuthority;
}
