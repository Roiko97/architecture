package com.cd.coordination.dao;

import com.cd.coordination.entity.Track;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("trackDao")
public interface TrackDao {

    public Integer getTrack(@Param("student_id") String student_id, @Param("mark") String mark, @Param("dealTime") String dealTime);

    public Integer insertTrack(@Param("student_id") String student_id, @Param("mark") String mark, @Param("dealTime") String dealTime);

    public Track cs();
}
