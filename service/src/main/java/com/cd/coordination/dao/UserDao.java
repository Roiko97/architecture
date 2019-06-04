package com.cd.coordination.dao;

import com.cd.coordination.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {
    public User userLogin(@Param("student_id") String student_id, @Param("password") String password);

    public User userCheck(@Param("student_id") String student_id);

    public Integer userRevise(@Param("student_id") String student_id, @Param("password") String password);

    public Integer userMark(@Param("mark") String mark, @Param("student_id") String student_id);

    public Integer userTime(@Param("lasttime") String lasttime, @Param("thistime") String thistime, @Param("student_id") String student_id);

    public List<User> userMessage(@Param("student_id") String student_id);

}