package com.cd.coordination.dao;

import com.cd.coordination.entity.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("memberDao")
public interface MemberDao{
    public Integer memberInsert(@Param("mark") String mark, @Param("student_id") String student_id, @Param("name") String name);

    public List<Member> memberFind(@Param("mark") String mark);

    public Member teamMember(@Param("student_id") String student_id, @Param("mark") String mark);

    public Member memberId(@Param("student_id") String student_id);

    public Integer memberRevise(@Param("mark") String mark, @Param("student_id") String student_id, @Param("position") String position);

    public Integer leaveTeam(@Param("student_id") String student_id, @Param("mark") String mark);

    public List<Member> checkMemMark(@Param("student_id") String student_id);

}