package com.hotelreserve.http.model;

import com.hotelreserve.model.User;

/**
 * Created by zouwei on 2018/12/29.
 */
public class UserModel {
    public Integer id;

    public Integer level;

    public String phone;

    public String nickname;

    public Integer gender;

    public String avatarurl;

    public void copyFromUser(User user){
        this.id = user.getId();
        this.level = user.getLevel();
        this.phone = user.getPhone();
        this.nickname = user.getNickname();
        this.gender = user.getGender();
        this.avatarurl = user.getAvatarurl();
    }

    public User copyToHotelRoom(){
        User user = new User();
        user.setId(this.id);
        user.setLevel(this.level);
        user.setPhone(this.phone);
        user.setNickname(this.nickname);
        user.setGender(this.gender);
        user.setAvatarurl(this.avatarurl);
        return user;
    }

}
