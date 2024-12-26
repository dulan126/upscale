package com.devstack.ecom.upscale.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RequestCustomerdto {
    private String name;
    private String email;
    private String phone;
    private String address;
    private boolean isActive;

}
