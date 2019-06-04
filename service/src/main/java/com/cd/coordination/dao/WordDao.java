package com.cd.coordination.dao;

import com.cd.coordination.entity.Demand;
import com.cd.coordination.entity.Demo;
import com.cd.coordination.entity.Mission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wordDao")
public interface WordDao{
    public Mission missionId(@Param("id") int id);

    public Demo demoId(@Param("id") String id);

    public Demo demoSelect(@Param("id") String id);

    public Demand demandCheck(@Param("mark") String mark);

    public Integer demandInsert(@Param("title") String title, @Param("date") String date, @Param("mark") String mark);

    public List<Demand> demandFind(@Param("mark") String mark);


}