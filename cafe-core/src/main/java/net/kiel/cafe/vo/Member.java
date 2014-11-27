package net.kiel.cafe.vo;

import net.kiel.cafe.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;

public class Member {

    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private String nickname;
    
    public MemberEntity toMemberEntity() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(id);
        memberEntity.setNickname(nickname);
        
        return memberEntity;
    }
}
