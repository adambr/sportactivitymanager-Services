/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager.services;

import cz.muni.fi.pa165.sportactivitymanager.UserDTO;
import cz.muni.fi.pa165.sportactivitymanager.UserDAO;
import cz.muni.fi.pa165.sportactivitymanager.UserDTOChanger;
import cz.muni.fi.pa165.sportactivitymanager.User;
import java.util.List;
import javax.xml.ws.ServiceMode;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author tempest
 */

@Service
public class UserServiceImpl implements UserService{
    
    private UserDAO uDao;
    
    public void setsDAO(UserDAO uDao) {
        this.uDao = uDao;
    }
    

    public void create(UserDTO userDto) {
        if (userDto!=null){
        try{
                User user = UserDTOChanger.dtoToUserEntity(userDto);
                uDao.create(user);
                userDto.setId(user.getId());
        }
        catch(DataAccessException ex)
            {
   //             throw new DataAccessException(ex.toString());
            }
        }else{
            throw new NullPointerException("User cant not be null.");
        }
    }
            
    

    public UserDTO getByID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(UserDTO user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(UserDTO user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<UserDTO> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
