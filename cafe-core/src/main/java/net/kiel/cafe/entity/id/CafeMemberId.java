package net.kiel.cafe.entity.id;

import java.io.Serializable;

import net.kiel.cafe.entity.CafeEntity;
import net.kiel.cafe.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
public class CafeMemberId implements Serializable {
    @Getter @Setter
    private MemberEntity member;
    
    @Getter @Setter
    private CafeEntity cafe;
}
