package com.cd.coordination.dao;

import com.cd.coordination.entity.Cooperation;
import com.cd.coordination.entity.Test;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cooperationDao")
public interface CooperationDao{
    public Integer communicateInsert(@Param("mark") String mark, @Param("data") String data, @Param("announcer") String announcer, @Param("state") String state, @Param("heading") String heading);

    public List<Cooperation> communicateFind(@Param("mark") String mark);

    public Integer testUnitInsert(@Param("mark") String mark, @Param("subject") String subject, @Param("operator") String operator, @Param("frequency") String frequency,
                                  @Param("field") String field, @Param("process") String process, @Param("testprocess") String testprocess,
                                  @Param("result") String result, @Param("conclusion") String conclusion, @Param("remark") String remark);

    public List<Test> testUnitFind(@Param("mark") String mark);

    public Integer testUnitDelete(@Param("mark") String mark, @Param("id") int id);

}