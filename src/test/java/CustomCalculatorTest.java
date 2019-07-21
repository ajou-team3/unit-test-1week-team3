
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;



    //이연주
    //0으로 나눌 때 예외처리
    @Test
    public void 분자가_0일때_예외처리하는지_검증테스트() {
        customCalculator = new CustomCalculator();
        customCalculator.divide(anyInt(), 0);
    }


    //더하기 테스트 작성
    //박수린
    @Test
    public void add() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(10,15);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertThat(result, is(25));
        assertFalse(result == 10);
        System.out.println("result :: " + result);
    }

    //빼기 테스트 작성
    //박수린
    @Test
    public void subtract() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertFalse(result == 12);
        assertTrue(result == 13);
        System.out.println("result :: " + result);
    }

    //곱하기 테스트 작성
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        /* 이곳에 테스트 코드를 작성하세요. */
        System.out.println("result :: " + result);
    }

    //나누기 테스트 작성
    @Test
    public void divide() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        /* 이곳에 테스트 코드를 작성하세요. */
        System.out.println("result :: " + result);
    }
}