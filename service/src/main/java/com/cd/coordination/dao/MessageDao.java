package com.cd.coordination.dao;

import com.cd.coordination.entity.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("messageDao")
public interface MessageDao{
    public List<Message> messageFind(@Param("receiveid") String receiveid);

    public Message messageGet(@Param("receiveid") String receiveid);

    public Integer sendMessage(@Param("sendid") String sendid, @Param("receiveid") String receiveid, @Param("result") Integer result, @Param("mark") String mark, @Param("sendname") String sendname, @Param("heading") String heading);

    public Integer messageRevise(@Param("result") String result, @Param("receiveid") String receiveid);

    public Integer deleteMessage(@Param("mark") String mark, @Param("receiveid") String receiveid);
}