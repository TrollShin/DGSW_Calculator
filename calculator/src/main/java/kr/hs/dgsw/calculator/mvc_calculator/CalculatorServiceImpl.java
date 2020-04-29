package kr.hs.dgsw.calculator.mvc_calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public int Calculate(String num1, String num2, String operator) {
        int _num1 = Integer.parseInt(num1);
        int _num2 = Integer.parseInt(num2);
        int result = 0;

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

        return result;
    }
}