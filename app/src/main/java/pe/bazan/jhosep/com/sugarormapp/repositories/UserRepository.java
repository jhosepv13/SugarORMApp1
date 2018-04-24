package pe.bazan.jhosep.com.sugarormapp.repositories;

import com.orm.SugarRecord;

import java.util.Iterator;
import java.util.List;

import pe.bazan.jhosep.com.sugarormapp.models.User;

/**
 * Created by Alumno on 19/04/2018.
 */

public class UserRepository {

    private static List<User> users;



    public static List<User> list(){
        users = SugarRecord.listAll(User.class);
        return users;
    }

    public static User read(Long id){
        User user = SugarRecord.findById(User.class, id);
        return user;
    }

    public static void create(String fullname, String email, String password){
        User user = new User(fullname, email, password);
        SugarRecord.save(user);
    }

    public static void update(String fullname, String email, String password, Long id){
        User user = SugarRecord.findById(User.class, id);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        SugarRecord.save(user);
    }

    public static void delete(Long id){
        User user = SugarRecord.findById(User.class, id);
        SugarRecord.delete(user);
    }

    public static User Login(String user, String pass){
        List<User> user1 = list();
        for (User login1: user1 ){
            if (login1.getFullname().equals(user) && login1.getPassword().equals(pass)) {

                return login1;
            }
        }
        return null;
    }
}



