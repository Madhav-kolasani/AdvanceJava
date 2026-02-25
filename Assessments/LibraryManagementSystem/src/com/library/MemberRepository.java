package com.library;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository {

    private List<Member> members = new ArrayList<>();

    public void save(Member member) {
        members.add(member);
    }

    public Member findById(Long id) {
        return members.stream()
        		.filter(m -> m.getId().equals(id))
        		.findFirst()
        		.orElse(null); // because findFirst returns optional so we can have optional return type or else use orElse(), orElseThrow()
    }
    
    public MemberRepository() {
        members.add(new Member(1L, "Madhav", "madhav@mail.com"));   // adding it to get one hardcode data
    }
}