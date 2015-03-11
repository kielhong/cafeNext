package net.kiel.cafe.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.kiel.cafe.dto.CafeMemberDto;
import net.kiel.cafe.entity.id.CafeMemberId;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "cafe_member")
@IdClass(CafeMemberId.class)
public class CafeMember {
    @Id
    @ManyToOne
    @Getter @Setter
    private Member member;
    
    @Id
    @ManyToOne
    @Getter @Setter
    private Cafe cafe;

    @ManyToOne
    @Getter @Setter
    private RoleEntity role;
    
    @Column(name = "joined_at")
    @Getter @Setter
    private LocalDateTime joinedAt;
    
    public CafeMemberDto toCafeMemberVO() {
        CafeMemberDto cafeMemberVO = new CafeMemberDto();
        cafeMemberVO.setMember(member.toMemberVO());
        cafeMemberVO.setCafe(cafe.toCafeVO(false));
        cafeMemberVO.setRole(role);
        cafeMemberVO.setJoinedAt(joinedAt);
        
        return cafeMemberVO;
    }
}
