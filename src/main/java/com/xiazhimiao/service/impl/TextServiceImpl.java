package com.xiazhimiao.service.impl;

import com.xiazhimiao.mapper.TextMapper;
import com.xiazhimiao.pojo.*;
import com.xiazhimiao.service.TextService;
import com.xiazhimiao.utils.transitionUtils;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Slf4j
@Service
public class TextServiceImpl implements TextService {

    @Autowired
    private TextMapper textMapper;

    @Override
    public List< String> category() {
        return textMapper.category();
    }

    @Override
    public List<TableName> textName(String category) {

        if(category.equals("日语")){
            return textMapper.textNameJapanese();
        }
        return textMapper.textNameEnglish();


    }

    @Override
    public List<Topic> getTopic(String name) {

        if(name.contains("日语")){
            return textMapper.getTpoicJapanese(name);
        }
        return textMapper.getTpoicEnglish(name);
    }

    @Override
    public Integer nameAndAnswer(NameAndAnswer nameAndAnswer) {
        if(nameAndAnswer.getName().contains("日语")){
            //根据试卷名获取答案列表
            //List<Character> answer = textMapper.getAnswerJapanese(nameAndAnswer.getName());
            Integer count=0;

            Map<Integer, Integer> userAnswer = nameAndAnswer.getAnswer();

            StringJoiner stringJoiner = new StringJoiner("-");

            for (Map.Entry<Integer, Integer> integerIntegerEntry : userAnswer.entrySet()) {

                //拼接答案保存
                stringJoiner.add(integerIntegerEntry.getValue()+"");

                Character answerDb = textMapper.GetKeyByIdAnswer(integerIntegerEntry.getKey());
                if(transitionUtils.transition(answerDb)==integerIntegerEntry.getValue()){
                    count++;
                }

            }

            //下面是插入学生成绩记录
            log.info("考试用户ID:{}成绩插入",String.valueOf(nameAndAnswer.getUserId()));
            textMapper.InsertByIdGrade(nameAndAnswer.getUserId(),nameAndAnswer.getName(),count, LocalDateTime.now());

            //下面是插入学生考试答案
            log.info("用户ID{}考试选择插入",nameAndAnswer.getUserId());
            textMapper.InsertByIdSelect(nameAndAnswer.getUserId(),nameAndAnswer.getName(),stringJoiner.toString(), LocalDateTime.now());


            return count;//textMapper.getNameAndAnswerJapanese(nameAndAnswer);
        }
        return 1;//textMapper.getNameAndAnswerEnglish(nameAndAnswer);
    }

    /**
     * 根据id查询用户成绩
     * @param id
     * @return
     */
    @Override
    public List<Grade> getIdByGrade(Integer id) {
        return textMapper.getByIdGrade(id);
    }
}
