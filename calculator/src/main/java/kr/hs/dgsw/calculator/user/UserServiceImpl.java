package kr.hs.dgsw.calculator.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    List<User> userList;
    public UserServiceImpl()
    {
        userList = new ArrayList<>(); // userLIst를 ArrayList로 선언
        userList.add(new User("user1", "가", "user111@dgsw")); // userList에 user1, 가, user111@dgsw 추가
        userList.add(new User("user2", "나", "user222@dgsw")); // userList에 user2, 나, user222@dgsw 추가
        userList.add(new User("user3", "다", "user333@dgsw")); // userList에 user2, 다, user333@dgsw 추가
    }

    //모든 유저를 리턴
    @Override
    public List<User> list() {
        return userList;
    }

    //입력받은 id의 값의 유저를 리턴
    @Override
    public User view(String id) {
        User user = userList.stream()
                            .filter(x -> x.getId().equals(id)) // userList의 모든id를 비교해서 같은 id를 가진User를 리턴
                            .findAny()// 먼저 찾는 객체 리턴
                            .orElse(null); //null 체크
        return user;
    }

    //유저 하나를 추가
    @Override
    public boolean add(User user) {
        User found = view(user.getId());
        if(found == null)
        {
            return userList.add(user);
        }
        return false;
    }

    //유저를 변경
    @Override
    public User update(User user) {
        User found = view(user.getId());
        if(found != null)
        {
            found.setName(user.getName());
            found.setEmail(user.getEmail());
        }
        return found;
    }

    //유저를 삭제
    @Override
    public boolean delete(String id) {
        User found = view(id);
        return userList.remove(found);
    }
    
}