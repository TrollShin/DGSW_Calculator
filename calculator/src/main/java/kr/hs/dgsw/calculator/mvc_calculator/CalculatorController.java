package kr.hs.dgsw.calculator.mvc_calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService cs;

    @GetMapping("/calculator/{num1}/{num2}/{operator}")
    public String calculator(@PathVariable String num1, @PathVariable String num2, @PathVariable String operator)
    {
        return calculate(num1, num2, operator);        
    }

    private String calculate(String num1, String num2, String operator) 
    {        
        try
        {
            int tmp1 = Integer.parseInt(num1);
            int tmp2 = Integer.parseInt(num2);
        }
        catch (NumberFormatException numberFormatException)
        {
            return "숫자를 입력해 주세요.";
        }

        try
        {
            return String.valueOf(cs.Calculate(num1, num2, operator));
        }    
        catch (ArithmeticException arithmeticException)
        {
            return "0으로 나눌 수 없습니다.";
        }
    }
}