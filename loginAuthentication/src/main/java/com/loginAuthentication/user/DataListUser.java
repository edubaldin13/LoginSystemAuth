package com.loginAuthentication.user;

public record DataListUser(
        Long id,
        String name,
        String email,
        Integer phone,
        String username) {
    public DataListUser(User user){
        this(user.getId(),user.getName(), user.getEmail(), user.getPhone(), user.getUsername());
    }
}
