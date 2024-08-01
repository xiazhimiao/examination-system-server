package com.xiazhimiao.service;

import com.xiazhimiao.pojo.*;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public interface TextService {
    List< String> category();

    List<TableName> textName(String category);

    List<Topic> getTopic(String name);

    Integer nameAndAnswer(NameAndAnswer nameAndAnswer);

    List<Grade> getIdByGrade(Integer id);
}
