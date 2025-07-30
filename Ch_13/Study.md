---
13.1 테스트 코드
---

```
테스트: 프로그램의 품질을 검증하는 것을 의미한다. 이는 의도대로 프로그램이 잘 동작하는지를 확인하는 과정이다.

<단계>
1. 예상 데이터 작성
2. 실제 데이터 획득
3. 예상 데이터와 실제 데이터 비교해서 검증

작성된 코드가 테스트 통과 시, 지속적인 리팩터링으로 코드를 개선하고, 통과하지 못하면 잘못된 부분을 찾아 고치는 디버깅을 해야한다.

테스트 케이스는 다양한 경우를 대비해서 작성하는 테스트 코드들의 모음이다. 테스트 케이스는 성공뿐 아니라 실패의 경우도 고려해서 작성해야한다.
```

*테스트 주도 개발

```
테스트 주도 개발이란 테스트 코드를 일단 작성한 후 이를 통과하는 최소한의 코드부터 시작해서 점진적으로 코드를 개선 및 확장해 나가는 개발 방식이다.

<과정>

1. 실패하는 테스트 코드를 추가한다.
2. 테스트 성공을 위한 최소한의 코드를 작성한다.
3. 테스트 통과를 유지하며 코드를 개선한다.
```

---
13.2 테스트 코드 작성하기
---
메서드에서 우클릭을 하고 Test를 누른다.

<img width="624" height="383" alt="image" src="https://github.com/user-attachments/assets/bc645e73-6d36-4601-8469-6452ead95f4e" />

<img width="614" height="607" alt="image" src="https://github.com/user-attachments/assets/093359df-0a48-42a9-b7e0-2f9896129d02" />

```
@SpringBootTest: 해당 클래스를 스프링부트와 연동해서 통합 테스트를 수행하는 어노테이션
import static org.junit.jupiter.api.Assertions.*;: 앞으로 사용할 수 있는 패키지를 임포트

List<Article> articles = articleService.index(); 에서 메서드를 호출하여 그 결과를 List에 받아온다. 조회 요청하고 그 결과를 반환되는 게시글의 묶음을 받아오는것이다.

또한 예상 데이터는 data.sql 파일을 통해서 확인한다. 예상 데이터를 각각 a,b,c에 저장해준다.
그리고, 실제 데이터를 배열 형태로 저장하기 위해서 import java.util.Arrays;를 임포트해주고, Arrays<Article> articles = articleService.index();의 형태로 바꿔준다.

또한, 정적 리스트를 Arrays.asList() 메서드를 통해서 일반 리스트로 만들 수 있다. 여기서는 List<Article> expected = Arrays.asList(a, b, c);를 사용하여, a,b,c를 예상 데이터인 expected에 저장한다.


assertEquals(expected.toString(), articles.toString());는 JUnit에서 제공하는 메서드인데, 예상테이터(왼쪽)과 실제데이터(오른쪽)을 비교하여 일치하면 테스트를 통과시킨다.
```

<img width="741" height="672" alt="image" src="https://github.com/user-attachments/assets/e6592b21-7036-4752-ae4c-a235b5dabfe8" />

<img width="852" height="573" alt="image" src="https://github.com/user-attachments/assets/facf544b-3088-419a-968d-7843cdae7bed" />

```
또한, 지금까지 작성한 ArticleRepository와 ArticleService의 호환성을 해결하기 위해서 CrudRepository를 JpaRepository로 바꿔준다.
```

<img width="434" height="161" alt="image" src="https://github.com/user-attachments/assets/d5db8455-548d-4313-8dc7-2976c84cdd52" />

<img width="796" height="178" alt="image" src="https://github.com/user-attachments/assets/0a29209c-d556-4649-b744-989545e74123" />



