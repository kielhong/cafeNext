package net.kiel.cafe.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.kiel.cafe.entity.id.CafeMemberId;
import net.kiel.cafe.vo.CafeMember;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "cafe_member")
@IdClass(CafeMemberId.class)
public class CafeMemberEntity {
    @Id
    @ManyToOne
    @Getter @Setter
    private MemberEntity member;
    
    @Id
    @ManyToOne
    @Getter @Setter
    private CafeEntity cafe;

    @ManyToOne
    @Getter @Setter
    private RoleEntity role;
    
    @Column(name = "joined_at")
    @Getter @Setter
    private LocalDateTime joinedAt;
    
    public CafeMember toCafeMemberVO() {
        CafeMember cafeMemberVO = new CafeMember();
        cafeMemberVO.setMember(member.toMemberVO());
        cafeMemberVO.setCafe(cafe.toCafeVO(false));
        cafeMemberVO.setRole(role);
        cafeMemberVO.setJoinedAt(joinedAt);
        
        return cafeMemberVO;
    }
}
