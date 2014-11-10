package net.kiel.cafe.domain.id;

import java.io.Serializable;

import net.kiel.cafe.domain.Cafe;
import net.kiel.cafe.domain.Member;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
public class CafeMemberId implements Serializable {
    @Getter @Setter
    private Member member;
    
    @Getter @Setter
    private Cafe cafe;
}
