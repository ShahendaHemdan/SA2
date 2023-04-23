package com.sa2.lms.domain;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class courseDto {

    private String name;

    private String code;

    public boolean delete;
}
