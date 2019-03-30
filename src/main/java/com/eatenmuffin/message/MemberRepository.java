package com.eatenmuffin.message;

import com.eatenmuffin.message.domain.Member;
import com.eatenmuffin.message.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
}
