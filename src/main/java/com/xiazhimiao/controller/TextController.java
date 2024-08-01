package com.xiazhimiao.controller;

import com.xiazhimiao.pojo.*;
import com.xiazhimiao.service.TextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/text")
public class TextController {

    @Autowired
    private TextService textService;

    @GetMapping("/category")
    public Result textCategoryListService(){
        List<String> category = textService.category();
        return Result.success(category);
    }

    @PostMapping ("")
    public Result textListService(@RequestBody Category category){
        log.info("请求的试卷种类:{}",category.getCategory());
        List<TableName> textName = textService.textName(category.getCategory());

        return Result.success(textName);
    }

    @PostMapping("/name")
    public Result textService(@RequestBody TableName tableName){
        log.info(tableName.getName());
        List<Topic> list= textService.getTopic(tableName.getName());
        return Result.success(list);
    }
    @PostMapping("/Upload")
    public Result textUploadService(@RequestBody NameAndAnswer nameAndAnswer){
        log.info(nameAndAnswer.getName());
        Integer grade = textService.nameAndAnswer(nameAndAnswer);

        return Result.success(grade);
    }

    @GetMapping("/Grade/{id}")
    public Result textGradeListService(@PathVariable Integer id){
        log.info("用户{}查询考试成绩",id);
        List<Grade> list = textService.getIdByGrade(id);
        return Result.success(list);
    }

}
