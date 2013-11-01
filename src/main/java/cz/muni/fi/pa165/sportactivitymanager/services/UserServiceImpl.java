/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager.services;

import cz.muni.fi.pa165.sportactivitymanager.UserDTO;
import cz.muni.fi.pa165.sportactivitymanager.UserDAO;
import cz.muni.fi.pa165.sportactivitymanager.UserDTOChanger;
import cz.muni.fi.pa165.sportactivitymanager.User;
import cz.muni.fi.pa165.sportactivitymanager.DataAccException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.ServiceMode;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Dobes KUba
 */
//TODO datasource do applicatonContext.xml
//1.11 NEW repository

@Service
public class UserServiceImpl implements UserService{
    
    private UserDAO uDao;
    
    public void setUserDAO(UserDAO uDao) {
        this.uDao = uDao;
    }

    public void create(UserDTO userDto) {
        if (userDto!=null)
        {
            try{
                    User user = UserDTOChanger.dtoToUserEntity(userDto);
                    uDao.create(user);
                    userDto.setId(user.getId());
            }
            catch(DataAccessException ex)
                {
                    throw new DataAccException(ex.toString());
                }
        }else{
            throw new NullPointerException("User can not be null.");
        }
    }

    public UserDTO getByID(Long id) {
        UserDTO userDto = null;
       
        if(id != null){  
            try{
                        User user = uDao.getByID(id);
                         userDto = UserDTOChanger.entityToDTO(user);
                }
                catch(DataAccessException ex)
                    {
                        throw new DataAccException(ex.toString());
                    }
        }else{ 
            throw new NullPointerException("User ID is Null");
        }
            return userDto;
    }

    public void delete(UserDTO userDto){
     if (userDto!=null)
        {
            try{
                    User user = UserDTOChanger.dtoToUserEntity(userDto);
                    uDao.delete(user);
            }
            catch(DataAccessException ex)
                {
                    throw new DataAccException(ex.toString());
                }
        }else{
            throw new NullPointerException("User can not be null.");
        }
    }

    public void update(UserDTO userDto) {
     if (userDto!=null)
        {
            try{
                    User user = UserDTOChanger.dtoToUserEntity(userDto);
                    uDao.update(user);
            }
            catch(DataAccessException ex)
                {
                    throw new DataAccException(ex.toString());
                }
        }else{
            throw new NullPointerException("User can not be null.");
        }
    }

    public List<UserDTO> findAll() {
        List<UserDTO> usersDto = new ArrayList<UserDTO>();
        List<User> users = new ArrayList<User>();
            try{                    
                    users = uDao.findAll();                    
                    usersDto = UserDTOChanger.entityListToDtoList(users);
            }
            catch(DataAccessException ex)
                {
                    throw new DataAccException(ex.toString());
                }
            return usersDto;
    }
    
}
