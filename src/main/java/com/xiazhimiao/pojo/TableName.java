package com.xiazhimiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableName {
    private Integer id;
    private String name;
    private Integer state;
    private LocalDateTime createTime;
}
