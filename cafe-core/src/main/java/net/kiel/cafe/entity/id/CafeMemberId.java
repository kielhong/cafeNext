package net.kiel.cafe.entity.id;

import java.io.Serializable;

import net.kiel.cafe.entity.Cafe;
import net.kiel.cafe.entity.Member;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
public class CafeMemberId implements Serializable {
    @Getter @Setter
    private Member member;
    
    @Getter @Setter
    private Cafe cafe;
}
