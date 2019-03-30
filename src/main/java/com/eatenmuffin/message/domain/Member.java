package com.eatenmuffin.message.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "messages")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private Set<Message> messages = new HashSet<>();

    public void setMessage(Message message){
        messages.add(message);

    }

    public void removeMessage(Message message){
        messages.remove(message);

    }

    @Builder
    public Member(String name) {
        this.name = name;
    }
}
