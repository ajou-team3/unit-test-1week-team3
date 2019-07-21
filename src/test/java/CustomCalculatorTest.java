

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;



    //이연주
    //0으로 나눌 때 예외처리
    @Test(expected = ArithmeticException.class)
    public void 분자가_0일때_예외처리하는지_검증테스트() {
        customCalculator = new CustomCalculator();
        customCalculator.divide(anyInt(), 0);
    }

    //이연주
    //연산이10ms이내되는지_검증테스트
    @Test(timeout = 1)
    public void 곱하기연산이1ms이내되는지_검증테스트() throws InterruptedException {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(152,1215);
        System.out.println("연산이 1ms 내에 성공되었습니다.");
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

    //이연주
    //곱하기 테스트 작성
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        assertThat(result, is(45));
        System.out.println("result :: " + result);
    }

    //이연주
    //나누기 테스트 작성
    @Test
    public void divide() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        assertThat(result, is(5));
        System.out.println("result :: " + result);
    }
}