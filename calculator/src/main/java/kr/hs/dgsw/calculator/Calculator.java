package kr.hs.dgsw.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {
    @GetMapping("/calculate1")
    public String calculate(@RequestParam final String num1, @RequestParam final String num2, @RequestParam final String operator)
    {
        float result = 0;

        float _num1;
        float _num2;

        try {
            _num1 = Float.parseFloat(num1);
            _num2 = Float.parseFloat(num2);
        } catch (NumberFormatException e) {
            return "숫자를 입력하세요";
        }

        switch(operator)
        {
            case "add":
                result = _num1 + _num2;
                break;
            case "sub":
                result = _num1 - _num2;
                break;
            case "mul":
                result = _num1 * _num2;
                break;
            case "div":
                result = _num1 / _num2; 
                break;
        }

        if(result - (int)result == 0) 
        {
            return String.valueOf((int)result);
        }

        return String.valueOf(result);
    }

    @GetMapping("/calculate2/{num1}/{num2}/{operator}")
    public String calculate2(@PathVariable final String num1, @PathVariable final String num2, @PathVariable final String operator)
    {
        float result = 0;
        
        float _num1;
        float _num2;

        try {
            _num1 = Float.parseFloat(num1);
            _num2 = Float.parseFloat(num2);
        } catch (NumberFormatException e) {
            return "숫자를 입력하세요";
        }

        switch(operator)
        {
            case "add":
                result = _num1 + _num2;
                break;
            case "sub":
                result = _num1 - _num2;
                break;
            case "mul":
                result = _num1 * _num2;
                break;
            case "div":
                result = _num1 / _num2; 
                break;
        }
        
        if(result - (int)result == 0) 
        {
            return String.valueOf((int)result);
        }

        return String.valueOf(result);
    }
}