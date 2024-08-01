package com.xiazhimiao.mapper;

import com.xiazhimiao.pojo.Category;
import com.xiazhimiao.pojo.Grade;
import com.xiazhimiao.pojo.TableName;
import com.xiazhimiao.pojo.Topic;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface TextMapper {
    @Select("select  language from `examination-system`.exam_types")
    List<String> category();


    @Select("select  id, name, state, create_time from `examination-system`.japanese_table")
    List<TableName> textNameJapanese();

    @Select("select  id, name, state, create_time from `examination-system`.english_table")
    List<TableName> textNameEnglish();

    @Select("select id, topic, select1, select2, select3, select4, answer from `examination-system`.japanese_table_topic where name=#{name}")
    List<Topic> getTpoicJapanese(String name);

    List<Topic> getTpoicEnglish(String name);

    @Select("select answer from `examination-system`.japanese_table_topic where name=#{name}")
    List<Character> getAnswerJapanese(String name);

    @Select("select answer from `examination-system`.japanese_table_topic where id=#{key}")
    Character GetKeyByIdAnswer(Integer key);

    @Insert("insert into `examination-system`.grade_table (user_id,name,grade,created_at) value (#{userId},#{name},#{count},#{created_at})")
    void InsertByIdGrade(Integer userId,String name, Integer count, LocalDateTime created_at);


    @Insert("insert into `examination-system`.user_select ( user_id, name, body, created_at) VALUE (#{userId},#{name},#{string},#{created_at})")
    void InsertByIdSelect(Integer userId, String name, String string, LocalDateTime created_at);

    @Select("select  user_id, name, grade, created_at from `examination-system`.grade_table where user_id=#{id}")
    List<Grade> getByIdGrade(Integer id);
}


