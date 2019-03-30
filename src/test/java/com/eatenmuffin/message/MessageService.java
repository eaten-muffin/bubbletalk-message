package com.eatenmuffin.message;

import com.eatenmuffin.message.domain.Member;
import com.eatenmuffin.message.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MessageService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MemberRepository memberRepository;


    private void printAllMessage(){
        System.out.println("--------print all messages--------");

        List<Message> list = messageRepository.findAll();

        list.stream().forEach(x -> System.out.println("> "+x.getContent()+","+x.getMember().getId()));

    }

    private void printAllMember(){
        System.out.println("--------print all  members--------");

        List<Member> list = memberRepository.findAll();
        list.stream().forEach(x -> System.out.println("> "+x.toString()));

    }

    @Test
    public void test(){

        Member member = Member.builder()
                .name("user1")
                .build();


        Message message = Message.builder()
                .content("message message")
                .member(member)
                .build();

        member.setMessage(message);


        Member save = memberRepository.save(member);

        entityManager.clear();


        Member m1 = memberRepository.findById(save.getId()).get();
        assertTrue(m1.getMessages().size() == 1);
//        assertTrue(m1.getMessages().contains(message));
      assertTrue(m1.getName().equals("user1"));

      printAllMember();
      printAllMessage();

    }
    @Test
    public void test2(){

        Member member = Member.builder()
                .name("user1")
                .build();


        Message message = Message.builder()
                .content("message message")
                .member(member)
                .build();

        member.setMessage(message);


        Member save = memberRepository.save(member);

        entityManager.clear();



        Member save2 = memberRepository.save(member);
        entityManager.clear();


        List<Member> list = memberRepository.findAll();
        assertTrue(list.size()==1);
//        assertTrue(m1.getMessages().size() == 1);
//        assertTrue(m1.getMessages().contains(message));
//        assertTrue(m1.getName().equals("user1"));

        printAllMember();
        printAllMessage();

    }

    @Test
    public void test3 (){

        Member member = Member.builder()
                .name("user1")
                .build();


        Message message = Message.builder()
                .content("message message")
                .member(member)
                .build();

        member.setMessage(message);


        Member save = memberRepository.save(member);

        entityManager.clear();

        Optional<Member> byId = memberRepository.findById(save.getId());

        memberRepository.delete(byId.get());



//        assertTrue(list.size()==1);
//        assertTrue(m1.getMessages().size() == 1);
//        assertTrue(m1.getMessages().contains(message));
//        assertTrue(m1.getName().equals("user1"));

        entityManager.clear();
        printAllMember();
        printAllMessage();

    }
}
