package cn.zuoye.chat.controller;

import cn.zuoye.chat.Responder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private Responder responder;

    @GetMapping("/{msg}")
    public String chat(@PathVariable String msg){
        String s = responder.generateResponse(msg);
        return s;
    }

}
