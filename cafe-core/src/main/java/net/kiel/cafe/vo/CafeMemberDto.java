package net.kiel.cafe.vo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.RoleEntity;

public class CafeMemberDto {
    @Getter @Setter
    private MemberDto member;
    
    @Getter @Setter
    private CafeDto cafe;

    @Getter @Setter
    private RoleEntity role;
    
    @Setter
    private LocalDateTime joinedAt;
    public Date getJoinedAt() {
        return Date.from(joinedAt.atZone(ZoneId.systemDefault()).toInstant());
    }
}
