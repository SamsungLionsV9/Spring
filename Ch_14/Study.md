---
14.1 댓글 기능
---

```
게시글에 여러개의 댓글이 달리는데 이는 1:n 일대다 관계이다.
반대로 댓글 입장에선 n:1 다대일 관계이다.

DB에는 어떤식으로 저장되는가?

id같이 자기 자신을 대표하는 속성은 대표키이다. comment 테이블에는 연관 대상을 가리키는 article_id가 하나 더 있는데, article_id와 같이 연관 대상을 가리키는 속성을 외래키 라고 부른다. 외래키를 따라가면 해당 댓글이 어떤 게시글에 달린것인지 알 수 있다. 외래키는 항상 연관된 테이블의 대표키를 가리킨다.

JPA로 DB에 명령을 내리는데, 개념을 다시 복습해보자면, 엔티티는 DB 데이터를 담는 자바 객체고, 테이블이 엔티티를 기반으로 생성된다.
레포지토리가 엔티티를 관리해주는 인터페이스이며, 데이터 CRUD등의 기능을 제공한다.
```

---
14.2 댓글 엔티티 만들기
---

먼저 엔티티를 만들떄 필요한 어노테이션과 각각의 역할은 다음과 같다.
<img width="511" height="248" alt="image" src="https://github.com/user-attachments/assets/95507eab-3769-4630-9f0c-c7e07571831d" />

그리고 필요한 컬럼들을 지정해준다. 각각의 역할은 다음과 같다.

<img width="596" height="207" alt="image" src="https://github.com/user-attachments/assets/2509ad8f-6d09-4e49-8c60-590838c8cea6" />


```
@ManyToOne 어노테이션 => 엔티티와 엔티티를 다대일 관계로 지정해준다. 
@JoinCollum(name="외래키명") => 외래키 매핑을 위해 사용하는 어노테이션이다.
```

최종 정리하면 Comment.java는 다음과 같다.

<img width="859" height="640" alt="image" src="https://github.com/user-attachments/assets/33fe3ae6-7d17-47c8-8405-69f3855a5e77" />

그 후에 매핑이 잘 되었는지 확인하기 위해서 FirstProjectApplication을 실행한다.

<img width="522" height="191" alt="image" src="https://github.com/user-attachments/assets/93e22234-7464-421a-87d5-278fcba8c81d" />

콘솔을 보면 다음과 같이 테이블이 잘 생성되었음을 확인 가능하다.

<img width="426" height="182" alt="image" src="https://github.com/user-attachments/assets/b1c958b9-5574-47bf-8a99-5f237f645ea5" />

h2-console로 들어가면 테이블이 정확히 생성되어있음을 확인 가능하다.

<img width="521" height="438" alt="image" src="https://github.com/user-attachments/assets/14adf595-686f-46cc-a3fb-8f05b1437635" />

---
더미 데이터 추가
---

```
data.sql에 다음과 같이 추가해준다.

INSERT INTO article(title, content) VALUES ('가가가가', '1111');
INSERT INTO article(title, content) VALUES ('나나나나', '2222');
INSERT INTO article(title, content) VALUES ( '다다다', '3333');

INSERT INTO article(title, content) VALUES('당신의 인생 영화는?', '댓글');
INSERT INTO article(title, content) VALUES('당신의 소울 푸드는?', '댓글 ㄱ');
INSERT INTO article(title, content) VALUES('당신의 취미는?', '댓글 ㄱㄱ');

INSERT INTO comment(article_id, nickname, body) VALUES (4, 'A', '태극기휘날리며');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'B', '비긴어게인');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'C', '올드보이');

INSERT INTO comment(article_id, nickname, body) VALUES (5, 'D', '치킨');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'E', '피자');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'F', '초밥');

INSERT INTO comment(article_id, nickname, body) VALUES (6, 'G', '메이플스토리');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'F', '배틀그라운드');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'K', '오버워치');
```

<img width="333" height="422" alt="image" src="https://github.com/user-attachments/assets/663edac1-836b-46d2-9bec-f18bb40d842c" />

<img width="851" height="577" alt="스크린샷 2025-08-02 17 47 22" src="https://github.com/user-attachments/assets/09ea6fcc-aa16-4cb9-a8e9-308b44c74d46" />

h2-console에도 잘 반영되어있음을 알 수 있다. Article테이블의 id컬럼은 comment 테이블에서 외래키로 Article_id 컬럼으로 지정되어있음을 확인 가능하다.

---
특정 게시물의 모든 댓글 조회
---

<img width="424" height="384" alt="image" src="https://github.com/user-attachments/assets/fbb52221-8a60-40fb-aaac-266d876250a4" />

---
특정 닉네임의 모든 댓글 조회
---

<img width="489" height="354" alt="image" src="https://github.com/user-attachments/assets/dd0d145b-68ee-46d6-9bb7-44194f57c9f9" />

---
확인 문제
---

```
댓글과 게시글 테이블은 (ㄱ) 관계이다. -> 다대일
JPA에서 다대일 관계는 (ㄴ) 어노테이션으로 정의한다. -> @ManyToOne
데이터의 관계는 대표키와 (ㄷ)의 연결로 이뤄진다. -> 외래키
댓글 테이블에서 외래키는 (ㄹ)이다. -> article_id
JPA에서 외래키 지정은 (ㅁ) 어노테이션으로 한다. -> @JoinColumn 
```

---
14.3 댓글 레포지토리 만들기
---

CommentRepository는 JpaRepository를 사용하는것이 좋다.

<img width="849" height="564" alt="image" src="https://github.com/user-attachments/assets/b7ee7467-00af-4bb7-a683-4039943c798f" />

<img width="783" height="350" alt="image" src="https://github.com/user-attachments/assets/dbc194b8-0586-455c-b826-e00b33e1c4b1" />

---
특정 게시글의 모든 댓글 조회
---

<img width="867" height="427" alt="image" src="https://github.com/user-attachments/assets/49ce9b4c-f969-432e-a628-2dc819694c54" />

```
특정 게시글의 모든 댓글을 조회할때 value 속성에 사용할 쿼리를 작성해주면 된다.
특정 닉네임의 모든 댓글을 조회하는 메서드도 만들어주고, 이는 findByNickname으로 한다. 그리고 매개변수로 nickname을 받아온다.
또한, xml파일을 통하여 findByNickname() 메서드에서 수행할 쿼리를 작성해준다. 하단에는 해당 xml파일이 있고, 이는 resource경로의 하위 경로를 하나 더 추가해서 그 경로 내에 xml파일 코드를 작성해준다.
```

<img width="733" height="234" alt="image" src="https://github.com/user-attachments/assets/6d7814ea-7c8c-401f-ae87-41d98592b471" />

```
<entity-mappings>태그 내부에 <named-native-query>와 <query>태그를 이용하여 쿼리를 입력한다.
<name-native-query>태그의 name 속성에는 쿼리를 수행하는 대상 엔티티.메서드 이름을 적는다. 즉 CommentRepository의 findByNickname 메서드가 아래 쿼리를 수행하도록 하겠다는 뜻이다. result-class 속성에는 쿼리가 반환하는 타입의 전체 패키지 경로를 적는다. <query> 태그에는 실제 수행할 쿼리를 적는다.
```

---
댓글 레포지토리 테스트 코드 작성하기
---

먼저 CommentRepositoryTest.java를 생성해준다. 생성할 때 findByArticleId와 findByNickname 두개 항목을 체크한 상태로 테스트 코드를 생성해준다.

<img width="708" height="411" alt="image" src="https://github.com/user-attachments/assets/5f100ee1-1d77-45e6-b9bb-b2e899a69db5" />

---
findByArticleId 메서드의 테스트 코드 작성
---

@DisplayName 어노테이션을 사용한다. 이 어노테이션은 메서드 이름은 그대로 둔 채 테스트 이름을 바꾸고 싶을 때 사용한다.

<img width="338" height="144" alt="image" src="https://github.com/user-attachments/assets/1667e3d9-81ee-4fe5-9c26-f378f8fe387e" />

<img width="859" height="514" alt="image" src="https://github.com/user-attachments/assets/19596dd5-301a-47b0-a027-ba8d11c3f67f" />

예상 데이터를 제외한 다른 테스트 코드는 다음과 같다. 빨간색으로 선언되는 이유는 필드 선언 전이기 때문

<img width="859" height="514" alt="image" src="https://github.com/user-attachments/assets/dd11f2f4-93d1-493b-8a4a-d90c0cedfeb4" />

<img width="325" height="437" alt="image" src="https://github.com/user-attachments/assets/bf5c7508-5d0c-4f61-b4cd-d2447bfedd1a" />

<img width="300" height="386" alt="image" src="https://github.com/user-attachments/assets/fafe216f-a836-455a-bae3-972d80e2c8c0" />

두 테이블을 확인해보면 4번 게시물의 댓글이 1~3번 데이터임을 확인 가능하다.

이제 h2-console기반의 테이블 데이터들을 대입하여 예상 데이터를 작성해준다.

<img width="790" height="790" alt="image" src="https://github.com/user-attachments/assets/814d7e5e-6b22-436a-8a2e-c771fd05e5c0" />

최종적인 findByArticleId() 메서드의 테스트 코드는 다음과 같다. 추가적인 어노테이션으로 @DataJpaTest와 @Autowired 어노테이션을 추가해주면 된다.

<img width="786" height="518" alt="image" src="https://github.com/user-attachments/assets/829def9e-56d5-404c-955d-cf346ad74d26" />

<img width="1253" height="280" alt="image" src="https://github.com/user-attachments/assets/6f9a84e4-3053-4c4a-a3e9-ac6e3988f943" />

테스트 코드는 다음과 같고, CommentRepository에서의 문법오류를 발견하여 :를 추가해주었다. articleId부분에 :를 앞에 붙혀야한다.

<img width="608" height="148" alt="image" src="https://github.com/user-attachments/assets/3c182e3f-d3ab-44cc-bced-fd7ae750cd11" />

---
findByNickname() 테스트
---

<img width="1092" height="367" alt="image" src="https://github.com/user-attachments/assets/1d8294c9-b159-4ac0-a2f3-7136fa86ab0e" />

```
이제 닉네임별로 쓴 댓글들을 테스트 해보았다. 코드는 위에서 한 findByArticleId와 유사한데, 예상 데이터에서는 차이가 있다. 게시글 마다 해당 댓글 작성자의 댓글을 찾는거라 new Article(4L, "당신의 인생 영화는?", "댓글")이런식으로 추가해주어야한다.
추가적으로 앞에 id값을 맞춰주어야한다. 여기서의 4L는 4번 게시물인 영화와 관련된 게시물을 말한다.
```

---
확인 문제
---

```
(ㄱ)은 ListCrudRepository와 ListPagingAndSortingRepository로부터 확장된 레포지토리 인터페이스다. -> JpaRepository
(ㄴ)어노테이션을 사용하면 레포지토리가 수행할 SQL문을 직접 명시할 수 있다. -> @Query
레포지토리가 수행할 SQL문을 (ㄷ)파일로 만들어서 연결할 수도 있다. -> XML
레포지토리와 엔티티 등의 테스트, 즉 JPA 영역의 테스트는 (ㄹ) 어노테이션으로 명시한다. -> @DataJpaTest

```
