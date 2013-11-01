/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager.services;

import cz.muni.fi.pa165.sportactivitymanager.User;
import cz.muni.fi.pa165.sportactivitymanager.UserDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Dobes Kuba
 */

public class UserDAOMock implements UserDAO{

    private List<User> mockList = new ArrayList<User>();
    private long id = 0;
    
     // Dobes Kuba: vytvorim si list mockList a do nej pridam usera
     // v dalsich metodach pracuju jen s MOCKListem a ten prochazim a hledam odpovidajiciho usera
    // a s nim potom pracuju(updatuju, mazu...)
    public void create(User user) {
     if(user == null){
            throw new NullPointerException("User is Null");
        }
     if (user.getId() == null){
            user.setId(Long.valueOf(id));
            id++;
        }
      mockList.add(user);
    }

    public User getByID(Long id) {
    if (id == null) {
            throw new NullPointerException("User ID is null ");
        }
        for (User user : mockList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void delete(User user) {
    if (user == null) {
            throw new NullPointerException("User is Null");
        }
        for (User u : mockList) {
            if (u.getId().equals(user.getId())) {
                mockList.remove(Integer.parseInt((u.getId()).toString())); //conversion Long (u.getid()) to Int
            }
        }   
    }

    public void update(User user) {
    if (user == null) {
            throw new NullPointerException("User is Null");
        }
        for (User u : mockList) {
            if (u.getId().equals(user.getId())) {                             
                    u.setBirthDay(user.getBirthDay());
                    u.setFirstName(user.getFirstName());
                    u.setGender(user.getGender());
                    u.setLastName(user.getLastName());
                    u.setWeight(user.getWeight());
            }
        }
    }

    public List<User> findAll() {
        return Collections.unmodifiableList(mockList);
    }
    
}
