package com.cd.coordination;

import org.json.JSONObject;

public interface TeamService {
    public JSONObject teamFind(String student_id);

    public String teamCreate(String student_id, String heading, String endT);

    public String teamChange(String student_id, String mark);

    public String sendMessage(String student_id, String receiveid);

    public String receiveMessage(String result, String mark, String student_id);

    public String positionRevice(String student_id, String position);

    public JSONObject memberFind(String student_id);

    public String leaveTeam(String student_id);

    public JSONObject checkMessage(String student_id);
}
