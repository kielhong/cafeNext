package net.kiel.cafe.vo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import net.kiel.cafe.entity.RoleEntity;

public class CafeMember {
    @Getter @Setter
    private Member member;
    
    @Getter @Setter
    private CafeVO cafe;

    @Getter @Setter
    private RoleEntity role;
    
    @Setter
    private LocalDateTime joinedAt;
    public Date getJoinedAt() {
        return Date.from(joinedAt.atZone(ZoneId.systemDefault()).toInstant());
    }
}
