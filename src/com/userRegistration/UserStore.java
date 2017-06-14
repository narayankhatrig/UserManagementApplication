package com.userRegistration;

import java.util.HashMap;
import java.util.Map;

public class UserStore {
    int i = 1;
    Map<Integer,User> m = new HashMap<Integer, User>();

    public void addUser(User user){
        m.put(i,user);
        i++;

    }
    public Map display(){
        return m;
    }

    public void deleteUser(int id){
        m.remove(id);

    }

    public void editUsers(User user,int id){
        User newuser = m.get(id);
        newuser.setName(user.getName());
        m.put(id,newuser);

    }

    public Map searchByName(String name) {
        Map<Integer,User> tempMap = new HashMap<Integer, User>();
        for(int key:m.keySet()){
            User u = m.get(key);

            if(u.getName().contains(name)){
                tempMap.put(key,u);
            }

        }
        return tempMap;
    }

    public Map searchByAddress(String address) {
        Map<Integer,User> tempMap = new HashMap<Integer, User>();
        for(int key:m.keySet()){
            User u = m.get(key);

            if(u.getAddress().contains(address)){
                tempMap.put(key,u);
            }

        }
        return tempMap;
    }
}
