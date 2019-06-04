package com.cd.coordination.global;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class LoginSessionListener implements HttpSessionAttributeListener {

    private static final String LOGIN_USER="student_id";

    @Override
    public void attributeAdded(HttpSessionBindingEvent hsbe) {
        String attrName = hsbe.getName();

        if(LOGIN_USER.equals(attrName)){
            String attrVal = (String)hsbe.getValue();
            HttpSession session = hsbe.getSession();
            String sessionId = session.getId();

            String sessionId2 = LoginCache.getInstance().getSessionIdByUsername(attrVal);
            if(null == sessionId2){

            }else{
                HttpSession session2 = LoginCache.getInstance().getSessionBySessionId(sessionId2);
                session2.invalidate();
            }
            LoginCache.getInstance().setSessionIdByUserName(attrVal, sessionId);
            LoginCache.getInstance().setSessionBySessionId(sessionId, session);

        }

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub

    }
}
