package com.Lin.controller;

import com.Lin.pojo.Question;
import com.Lin.service.ConversationService;
import com.Lin.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Date 2023/12/10 21:33
 * @Author Lin
 * @Version 1.0
 */
@RestController
@RequestMapping("/Conversations")
@CrossOrigin
public class ConversationController {
    @Autowired
    private ConversationService conversationService;

    @GetMapping
    public R getQuestion(){
        R r = conversationService.getQuestion();
        return r;
    }

    @PostMapping
    public R postConversation(@RequestBody Question question){

        R r = conversationService.postConversation(question);

        return r;
    }



    @GetMapping("/{conversationId}")
    public R getConversation(@PathVariable String conversationId){

        R r = conversationService.getConversation(conversationId);

        return r;
    }

    @DeleteMapping("/{conversationId}")
    public R deleteConversation(@PathVariable String conversationId){

        R r = conversationService.deleteConversation(conversationId);

        return r;
    }
}
