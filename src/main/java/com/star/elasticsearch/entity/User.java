package com.star.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {

    private String name;
    private char sex;
    private Integer age;
    // 省略其他属性
}
