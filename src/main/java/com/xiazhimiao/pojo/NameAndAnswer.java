package com.xiazhimiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NameAndAnswer {
    private String name;
    private Integer userId;
    private Map<Integer,Integer> answer;
}
