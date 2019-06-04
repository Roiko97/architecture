package com.cd.coordination.dao;

import com.cd.coordination.entity.Team;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("teamDao")
public interface TeamDao{
    public Integer teamCreate(@Param("heading") String heading, @Param("mark") String mark, @Param("student_id") String student_id, @Param("end") Integer end);

    public Team teamId(@Param("mark") String mark);

    public Integer teamRevice(@Param("data") String data, @Param("schedule") String schedule, @Param("level") String level, @Param("mark") String mark);

    public Team teamMark(@Param("student_id") String student_id, @Param("mark") String mark);

    public Team teamFind(@Param("student_id") String student_id, @Param("mark") String mark);
}