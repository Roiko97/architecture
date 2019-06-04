package com.cd.coordination;

import org.json.JSONObject;

public interface TestUnitService {

    public JSONObject communicateFind(String student_id, String number);

    public JSONObject communicateInsert(String student_id, String data, String heading);

    public JSONObject testUnitFind(String student_id, String number);

    public JSONObject testUnit(String student_id, String field, String result,
                               String subject, String frequency, String process,
                               String testprocess, String conclusion, String remark,
                               String operator);

    public JSONObject testUnitRevice(String student_id, int id);

}
