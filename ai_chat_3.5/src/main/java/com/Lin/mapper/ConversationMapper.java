package com.Lin.mapper;

import com.Lin.pojo.Conversation;
import com.Lin.pojo.Question;

import java.util.List;

/**
 * @Description TODO
 * @Date 2023/12/10 21:49
 * @Author Lin
 * @Version 1.0
 */
public interface ConversationMapper {
    List<Conversation> queryByConId(String conversationId);

    int insert(Conversation conversation);

    int deleteByConId(String conversationId);

    List<Question> getQuestions();
}
