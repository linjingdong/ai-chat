package com.Lin.service.impl;

import com.Lin.mapper.ConversationMapper;
import com.Lin.mod.Api;
import com.Lin.pojo.Conversation;
import com.Lin.pojo.Question;
import com.Lin.service.ConversationService;
import com.Lin.utils.R;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Date 2023/12/10 21:37
 * @Author Lin
 * @Version 1.0
 */
@Service
public class ConversationServiceImpl implements ConversationService {
    @Autowired
    private Api api;

    @Autowired
    private Conversation conversation;

    @Autowired
    private ConversationMapper conversationMapper;
    @Override
    public R postConversation(Question question) {
        JSONObject answerJSON =null;
        if (question.getConversationId()==null) {
            answerJSON = api.open(question.getQuestion(), "");
        }else{
            answerJSON = api.open(question.getQuestion(), question.getConversationId());
        }

        String answer = answerJSON.getString("answer");
        String conversationId = answerJSON.getString("conversation_id");

        conversation.setConversationId(conversationId);
        conversation.setQuestion(question.getQuestion());
        conversation.setAnswer(answer);

        int row = conversationMapper.insert(conversation);

        if (row == 1) {
            return R.ok(conversationId);
        }

        return R.fail(null);
    }

    @Override
    public R getConversation(String conversationId) {

        List<Conversation> conversations = conversationMapper.queryByConId(conversationId);

        return R.ok(conversations);
    }

    @Override
    public R deleteConversation(String conversationId) {

        int row = conversationMapper.deleteByConId(conversationId);

        return R.ok(null);
    }

    @Override
    public R getQuestion() {
        List<Question> questions = conversationMapper.getQuestions();

        return R.ok(questions);
    }
}
