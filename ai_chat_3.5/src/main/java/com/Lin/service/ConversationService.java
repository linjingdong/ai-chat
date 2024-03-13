package com.Lin.service;

import com.Lin.pojo.Question;
import com.Lin.utils.R;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Date 2023/12/10 21:37
 * @Author Lin
 * @Version 1.0
 */
@Service
public interface ConversationService {
    R postConversation(Question question);

    R getConversation(String conversationId);

    R deleteConversation(String conversationId);

    R getQuestion();
}
