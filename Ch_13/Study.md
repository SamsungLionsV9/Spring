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

<img width="891" height="752" alt="image" src="https://github.com/user-attachments/assets/c61aabe8-109e-42c1-bf43-a0eac823ef3c" />

<img width="894" height="149" alt="image" src="https://github.com/user-attachments/assets/ff2bda02-221b-40e1-bdce-f07d6b72c586" />

```
또한, 지금까지 작성한 ArticleRepository와 ArticleService의 호환성을 해결하기 위해서 CrudRepository를 JpaRepository로 바꿔준다.
```

<img width="434" height="161" alt="image" src="https://github.com/user-attachments/assets/d5db8455-548d-4313-8dc7-2976c84cdd52" />

<img width="796" height="178" alt="image" src="https://github.com/user-attachments/assets/0a29209c-d556-4649-b744-989545e74123" />

```
데이터가 일치하여 테스트를 통과하면 다음과 같이 터미널에 출력된다.
```

<img width="1353" height="464" alt="image" src="https://github.com/user-attachments/assets/9eb0f9d7-742b-4d75-a56f-b3b11be1d8a6" />

```
테스트가 실패시 다음과같이 출력된다. id값을 일부로 하나 수정해보았다.
```

<img width="732" height="271" alt="image" src="https://github.com/user-attachments/assets/61ad6e10-6784-4571-94af-d0972052213f" />

<img width="1371" height="420" alt="image" src="https://github.com/user-attachments/assets/83e7883e-9651-4758-b573-e167a98af3e7" />

---
show()메서드 테스트하기
---

<img width="1002" height="789" alt="image" src="https://github.com/user-attachments/assets/106b6fa7-cfb4-4afa-a2c6-4e77cf7e1166"/>

```
show()메서드는 성공과 실패 두가지 경우로 나누어서 작성하였다. 성공은 존재하는 id를 입력했다는거고, 실패는 존재하지 않는 id를 입력했다는 뜻이다.
```

<img width="635" height="232" alt="image" src="https://github.com/user-attachments/assets/e9b12c41-87b3-43c6-adec-6774d0b12daf" />

<img width="1314" height="427" alt="image" src="https://github.com/user-attachments/assets/3ec3ea2f-f3ff-4986-b7e2-c89d1584efbf" />

```
위 사진은 성공일 시 나오는 터미널 출력이다.
```

<img width="1161" height="715" alt="image" src="https://github.com/user-attachments/assets/263266f0-23ae-456b-bb2a-ee3bb1c62d4c" />

```
게시물 조회에 실패했을 경우에도 테스트는 잘 통과하지만, null값을 반환하기 때문에 조회에는 실패한것이다.
```

---
create() 테스트
---

`
성공의 경우
`

<img width="1277" height="741" alt="image" src="https://github.com/user-attachments/assets/aa33c890-918b-4481-85e5-1bbaf92e3cf4" />

`
실패의 경우(null값을 반환하기에 toString()은 쓰지않는다.)
`

<img width="1251" height="761" alt="image" src="https://github.com/user-attachments/assets/3f62c612-f1fe-45ff-bfd9-070e3f06c583" />


---
여러 테스트 케이스 동시에 실행
---

<img width="841" height="344" alt="image" src="https://github.com/user-attachments/assets/141f3e05-f68d-4ec0-b78d-637e3a3da944" />



```
상단에 있는 메인 class를 실행하면 지금까지 만든 5가지의 테스트 케이스를 동시 실행이 가능하다.
```

<img width="1266" height="427" alt="image" src="https://github.com/user-attachments/assets/b58b9e00-aea4-4ac3-808d-497f19e549c1" />

```
만약, 문제가 발생하면 트랜잭션으로 처리하여 롤백하도록 해야한다. 이를 위해서 성공 테스트 케이스 상단에 @Transactional 어노테이션을 붙혀야한다.
```

<img width="837" height="654" alt="image" src="https://github.com/user-attachments/assets/622c3415-a060-4fb2-8996-9fe75674f341" />


---
확인 문제
---

(ㄱ) 프로그램의 다양한 상황을 자동으로 검증하기 위한 테스트 코드 -> 테스트 케이스
(ㄴ) 프로그램에서 발생한 문제의 원인을 찾고 고치는 작업 -> 디버깅
(ㄷ) 프로그램의 수행 결과는 그대로 유지하면서 코드의 구조 및 성능을 개선하는 작업 -> 리팩터링
(ㄹ) 스프링부트 환경과 연동된 테스트를 위한 어노테이션 -> @SpringBootTest
(ㅁ) 테스트를 수행해 조작된 데이터를 복구하는 어노테이션 -> @Transactional
