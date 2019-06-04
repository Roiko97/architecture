package com.cd.coordination;

import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WordService {
    public void cooperationExport(String student_id, HttpServletRequest request, HttpServletResponse response);

    public JSONObject demandFind(String student_id);

    public JSONObject demandWrite(String student_id, String date, String title);

    public JSONObject demo(String student_id, String id, String level);

    public void exWord(String student_id, HttpServletRequest request, HttpServletResponse response);

    public JSONObject tablefind(String student_id);

    public JSONObject tableWrite(String student_id, String data);

    public JSONObject templateSelect(String student_id, String id);

    public void testExport(String student_id, HttpServletRequest request, HttpServletResponse response);
}
