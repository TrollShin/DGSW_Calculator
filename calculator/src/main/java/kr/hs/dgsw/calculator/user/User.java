package kr.hs.dgsw.calculator.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor //파라미터가 없는 생성자
@AllArgsConstructor //모든 속성에 대한 생성자
public class User {
        
    //게터 세터
    @Getter @Setter private String id;
    @Getter @Setter private String name;
    @Getter @Setter private String email;

    @Override
    public String toString() {
        return id + "/" + name + "/" + email;
    }
}