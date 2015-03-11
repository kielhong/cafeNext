package net.kiel.cafe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.kiel.cafe.dto.MemberDto;
import lombok.Data;

@Entity
@Table(name = "member")
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String nickname;
    
    //private String email;
    
    public MemberDto toMemberVO() {
        MemberDto member = new MemberDto();
        member.setId(id);
        member.setNickname(nickname);
        
        return member;
    }
}