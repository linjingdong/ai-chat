package com.Lin.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Date 2023/12/10 21:32
 * @Author Lin
 * @Version 1.0
 */
@Data
@Component
public class Conversation {
    private String question;
    private String answer;
    private String conversationId;
}
