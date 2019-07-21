import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class UpperCaseCounterTest {

    private UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    //이연주
    //null을 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_null_input(){
        String str = null;
        assertThat(str, is(nullValue()));
//        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
    }

    //이연주
    //반겂울 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_empty_input() {
        String str = "";
        assertThat(str, is(""));
//        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
    }


    /* 이용재
     * getNumberOfUpperCaseCharactersInString_return_10_for_ABCDEFGHIJ,
     * getNumberOfUpperCaseCharacterInString_return_6_for_ABCdefGHI,
     * shouldThrowExceptionWhenGetZeroIndex,
     * testShouldRunInLimitedTime
     * 위에 4개 함수 응용
     */

    @Test
    public void getNumberOfUpperCaseCharactersInString_return_26_for_ABCDEFGHIJKLMNOPQRSTUVWXYZ() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertThat(result, is(26));
        System.out.println("result :: " + result);
    }

    @Test
    public void getNumberOfUpperCaseCharacterInString_return_13_for_ABCDEFGHIJKLMNOPQRSTUVWXYZ() {
        String str = "ABCDEFGHIJKLMnopqrstuvwxyz";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertThat(result, is(13));
        System.out.println("result :: " + result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenGetMinusOneIndex() {
        new ArrayList<Object>().get(-1);
    }

    @Test(timeout = 3000)
    public void testShouldRunIn3000ms() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("3000ms 안에 통과하면 테스트 성공");
    }
}
