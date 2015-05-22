package net.kiel.cafe.web.controller.api.dto;

import net.kiel.cafe.entity.User;

/**
 * Created by 1001982(kielhong@sk.com)
 * Date : 15. 5. 22.
 */
public class UserDto {
    private User user;

    public UserDto(User user) {
        this.user = user;
    }

    public Integer getId() {
        return user.getId();
    }

    public String getUsername() {
        return user.getUsername();
    }

}
