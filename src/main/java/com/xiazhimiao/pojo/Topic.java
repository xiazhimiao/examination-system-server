package com.xiazhimiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    private Integer id;
    private String topic;
    private String select1;
    private String select2;
    private String select3;
    private String select4;
    private String answer;
}
