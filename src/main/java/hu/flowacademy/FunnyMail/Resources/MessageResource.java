package hu.flowacademy.FunnyMail.Resources;

import hu.flowacademy.FunnyMail.Models.Message;
import hu.flowacademy.FunnyMail.Models.MessageDTO;
import hu.flowacademy.FunnyMail.Models.User;
import hu.flowacademy.FunnyMail.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class MessageResource {

    @Autowired
    UserService userService;

    public Message convertToMessage(MessageDTO dto) {
        User from = userService.getUser(UUID.fromString(dto.getFromId()));
        User to = userService.getUser(UUID.fromString(dto.getToId()));
        return new Message(dto.getId(), from, to, dto.getContent());
    }

/*    @GetMapping("/message/{id}") TODO
    @GetMapping("/messages")
    @PostMapping("/message")
    @PutMapping("/message")
    @DeleteMapping("/message/{id}")*/

}
