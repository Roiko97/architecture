package com.cd.coordination;

import java.util.List;

public interface TrackService {

    public List<Integer> getTrack(String student_id, String mark);

    public Integer insertTrack(String student_id, String mark);

    public String getUserMark(String student_id);

    public List<String> getDate();

}
