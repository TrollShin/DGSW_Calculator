package kr.hs.dgsw.calculator.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    //모든 데이터 조회
    @GetMapping("/user")
    @ResponseBody
    public List<User> list()
    {
        return userService.list();
    }

    //입력받은 id값의 데이터 조회
    @GetMapping("/user/{id}")
    @ResponseBody
    public User view(@PathVariable String id)
    {
        return userService.view(id);
    }

    //입력받은 User를 추가함
    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user)
    {
        return userService.add(user);
    }

    //입력받은 User를 변경함
    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user)
    {
        return userService.update(user);
    }

    //입력받은 id값을 지움
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id)
    {
        return userService.delete(id);
    }
}