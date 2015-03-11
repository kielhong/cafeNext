package net.kiel.cafe.web.controller.dto;

import net.kiel.cafe.entity.Member;
import lombok.Getter;
import lombok.Setter;

public class MemberDto {

    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private String nickname;
    
    public Member toMemberEntity() {
        Member memberEntity = new Member();
        memberEntity.setId(id);
        memberEntity.setNickname(nickname);
        
        return memberEntity;
    }
}
