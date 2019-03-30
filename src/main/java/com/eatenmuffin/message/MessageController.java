package com.eatenmuffin.message;

import com.eatenmuffin.message.domain.Member;
import com.eatenmuffin.message.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/")
    public List<Message> listAll(@RequestParam String region){
        return messageRepository.findAll();
    }


    @GetMapping("/0")
    public void test() {
        messageRepository.deleteAll();;

    }
    @GetMapping("/1")
    @Transactional
    public void test1(){

        Member member = Member.builder()
                .name("user1")
                .build();


        Message message = Message.builder()
                .content("message message")
                .member(member)
                .build();


        member.setMessage(message);


        Member save = memberRepository.save(member);


    }
    @GetMapping("/3")
    @Transactional
    public void test3(){

        Member member = Member.builder()
                .name("user3")
                .build();

//        Category category = Category.builder().name("ca1").build();

        Message message = Message.builder()
                .content("2222wqeqwe")
                .member(member)
//                .category(category)
                .build();


        member.setMessage(message);


        Member save = memberRepository.save(member);


    }
    @GetMapping("/2")
    @Transactional
    public void test2(){



        Member save = memberRepository.findById(1L).get();
        Message message = Message.builder()
                .content("message 222")
                .build();

        Message s = messageRepository.save(message);

        save.setMessage(s);



    }


}
