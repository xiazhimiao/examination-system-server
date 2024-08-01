package com.xiazhimiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    private Integer userId;
    private String name;
    private Integer grade;
    private LocalDateTime createdAt;
}
