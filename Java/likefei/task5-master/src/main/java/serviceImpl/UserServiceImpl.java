package serviceImpl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;
import utils.Md5;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void insert(User user) {
        user.setUpdate_time(System.currentTimeMillis());
        user.setCreate_time(System.currentTimeMillis());
        String user_password = user.getPassword();
        Md5 md5 = new Md5();
        List<String> list = md5.passwordsalt(user_password);
        user.setPassword(list.get(1));
        user.setSalt(list.get(0));
        userMapper.insert(user);
    }

    @Override
    public User getbyname(String name) {
        return userMapper.getbyname(name);
    }

    @Override
    public boolean passwordtest(String name,String password) {
        String salt = userMapper.getbyname(name).getSalt();
        Md5 md5 = new Md5();
        String pd = Md5.passwordtest(password, salt);
        return pd.equals(userMapper.getbyname(name).getPassword());
    }

    @Override
    public boolean nametest(String name) {
        if (userMapper.getname(name)!=null){
            return  true;
        }
        else  return  false;
    }
}