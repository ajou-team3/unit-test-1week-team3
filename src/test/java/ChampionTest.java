import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.object.HasToString.hasToString;
import static org.junit.Assert.*;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test //lww
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList.size(), is(0));
//        assertThat(emptyList, empty());
    }

    //notNullValue 활용한 테스트
    @Test  //lww
    public void notNullCheck() {
        String lck = "LCK";
        assertNotNull(lck);
//        assertThat(lck, notNullValue());
    }

    //nullValue 활용한 테스트
    @Test //lww
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertEquals(lck, null);
//        assertThat(lck, nullValue());
    }


    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test //lww
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";
        String contain = "yer";
        assertThat(sampleString1, is(startsWith(startString)));
        assertThat(sampleString2, allOf(containsString(contain), endsWith(endString)));
//        assertThat(sampleString1, anyOf(startsWith(startString), containsString(endString)));
//        assertThat(sampleString2, is(endsWith(endString)));
    }

    //부동소수점 범위 closeTo 테스트
    @Test //lww
    public void testForFloatingPoint() {
//        assertThat(3.14, closeTo(3, 0.2));
        assertThat(3.11, closeTo(3, 0.12));
    }

    // 이영주
    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
//        assertThat(championList.get(2), anything());
        assertThat(championList.get(0), anything());
        assertThat(championList.get(1), any(Champion.class));
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
//        assertTrue(championList.size() == 5);
//        assertThat(championList.size(), is(5));
//        assertThat(championList, hasSize(5));

        assertThat(championList, hasSize(5));
        assertEquals(5, championList.size());
    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");
//        assertThat("타릭", is(supportChamp.getName()));
//        assertThat("타릭", is(equalTo(supportChamp.getName())));
//        assertThat("타릭", equalTo(supportChamp.getName()));
        assertEquals("타릭", supportChamp.getName());
        assertTrue(supportChamp.getName().equals("타릭"));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
//        assertThat(championList.get(0), hasProperty("position"));
//        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));

        assertThat(championList.get(1), hasProperty("name", equalTo("리신")));
        assertThat(championList.get(1), hasProperty("position", is("정글")));
    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");
//        assertThat(champListNames.get(0), hasToString("루시안"));

        assertThat(champListNames.get(1), hasToString(any(String.class)));
        assertThat(champListNames.get(1), hasToString("애쉬"));
    }


    //property와 value가 같은지 테스트
    //박수린
    @Test
    public void shouldHaveSamePropertyAndValue() {
        Champion champion = new Champion("애쉬", "원딜");
        Champion champion1 = new Champion("루시안", "원딜");
        Champion champion2 = new Champion("애쉬", "원딜");

        assertThat(champion, samePropertyValuesAs(champion2));
        // assertThat(champion1, samePropertyValuesAs(champion2));
    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    //박수린
    @Test
    public void shouldTopChampionIsDarius() {
        Optional<Champion> filteredChampion = championList.stream()
                .filter(c -> c.getPosition().equals("정글"))
                .findFirst();

        System.out.println("result :: " + filteredChampion);

        String champName = filteredChampion.get().getName();
        // assertThat(champName, is("리신"));
        assertTrue(champName.equals("리신"));
    }

}