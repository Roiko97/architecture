package com.cd.coordination;

import org.json.JSONObject;

public interface LevelService {

    public JSONObject demandLevel(String student_id);

    public JSONObject intermediateLevel(String student_id);

    public JSONObject missionLevel(String student_id) throws Exception;

    public JSONObject primaryLevel(String student_id);

    public JSONObject seniorLevel(String student_id);

}