---
15.1 댓글 REST API의 개요
---

```
REST 컨트롤러: 댓글 REST API를 위한 컨트롤러로 서비스와 협업, 클라이언트 요청을 받아 응답하며, 뷰가 아닌 데이터를 반환한다.
서비스: REST 컨트롤러와 레포지토리 사이에서 비즈니스 로직, 즉 처리 흐름을 담당, 예외 상황은 @Transactional로 변경된 데이터 롤백
DTO: 사용자에게 보여줄 댓글 정보를 담는 것, 단순히 클라이언트와 서버 간에 댓글 JSON 데이터 전송
엔티티: DB 데이터를 담는 자바 객체, 이를 기반으로 테이블 생성, 레포지토리가 DB속 데이터를 조회하거나 전달할 떄 사용
리포지토리: 엔티티를 관리하는 인터페이스로 데이터 CRUD 등의 기능을 제공, 서비스로부터 댓글 CRUD등의 명령을 받아 DB에 보내고 응답받음
```
```
15장 핵심 개념

JSON -(DTO)> REST컨트롤러/서비스
JSON <(DTO)- REST컨트롤러/서비스
```

---
15.2 댓글 컨트롤러와 서비스 틀 만들기
---

<img width="655" height="325" alt="image" src="https://github.com/user-attachments/assets/b7ce60c8-44fe-4590-972e-8d483b53db80" />

1. CommentApiController.java를 먼저 생성(Rest 컨트롤러이므로 @RestController 어노테이션을 선언)


<img width="725" height="411" alt="image" src="https://github.com/user-attachments/assets/94b21ddc-16d1-4224-8939-63a88aeef15a" />

2. CommentService.java를 생성(서비스이므로 @Service 어노테이션을 선언)

---
15.3 댓글 조회하기
---

```
CommentApiController.java은 다음과 같다. @GetMapping으로 댓글 조회 요청을 받고, {articleId}를 써서 id를 매번 바뀌게해준다.
또한, 메서드는 comments()로 하고, 매개변수는 몇 번 게시글을 조회하는지 알아야하므로 @GetMapping의 articleId를 받아온다.
```

<img width="491" height="291" alt="image" src="https://github.com/user-attachments/assets/a8b65cf2-41ad-49ff-a4bc-13ecf285fe2e" />

---
요청을 받아서 응답할 컨트롤러 생성
---

1. 댓글 조회
<img width="884" height="267" alt="image" src="https://github.com/user-attachments/assets/b747219c-8567-4b31-96d6-4595328944b2" />

```
기본적인 구조는 다음과 같다. 다만 List<Comment>가 아닌 ResponseEntity<List<CommentDto>>인 이유는 엔티티를 DTO로 변환하면 List<CommentDto>로 변환되기 때문이다.

메서드 실행 결과는 아직 아무것도 없으므로 null이다.

서비스에 댓글 조회를 위임하기 위해서 CommentService의 comments(articleId) 메서드를 호출한다. 이렇게 넘긴 이유는 게시글의 id를 알아야 해당 게시글의 댓글을 가져올 수 있기 때문이다.

또한, 결과 응답에서 삼항 연산보단 예외처리 방식이 더 선호된다. 예외처리는 예기치 못한 상황이 발생할 때를 대비해서 대처하는 코드를 미리 작성하는것이다.
```

<img width="527" height="127" alt="image" src="https://github.com/user-attachments/assets/2291c764-60cc-4363-b4d2-0873e1cc19d0" />


```
결과응답에서는 서비스에서 반환받은 dtos를 응답 본문에 실어 보낸다. REST API의 응답은 ResponseEntity에 실어 보낸다고 했으므로, return 문에 null을 지우고 ResponseEntity의 상태는 ok, 본문에는 dtos(조회한 댓글 목록)을 실어서 보낸다.

하지만 return문에는 에러가 날텐데, 이는 CommentDto 클래스가 아직 없기 때문이다. 이를 만들면 에러가안난다.
```

---
CommentDto.java 만들기
---

<img width="569" height="458" alt="image" src="https://github.com/user-attachments/assets/d1db971b-3ed5-4e29-902f-5b7ab927b55c" />

```
여기서는 롬복으로 기능을 설정해주었고, CommentDto(댓글 엔티티를 담을 그릇)을 만든다. 내부 구조는 사진과 같다.
이렇게 되면 CommentDto의 빨간색 표시가 사라진다.
```

---
요청을 처리할 서비스 만들기
---

<img width="704" height="485" alt="image" src="https://github.com/user-attachments/assets/4293653b-85f8-48d9-89c7-13d06cdb9efa" />

이렇게 되면 서비스에 comments()메서드가 생성된다.

<img width="611" height="335" alt="image" src="https://github.com/user-attachments/assets/1704389d-486f-4965-aa3e-666e55614f73" />


```
빨간줄이 그여져서 나올텐데, 이를 해결하기 위해서 createCommentDto()를 생성해야한다. CommentDto에서 createCommentDto메서드를 만들어야한다. Comment comment를 매개변수로 가져온다.
```

<img width="794" height="227" alt="image" src="https://github.com/user-attachments/assets/85c6f3b8-23f4-446d-a8c0-dd7ca18bb131" />

<img width="649" height="99" alt="image" src="https://github.com/user-attachments/assets/6db3f671-26f2-4c57-83ad-7fdc1e22e6f5" />

그리고 createCommentDto메서드를 완성해준다. 가져온것들은 상단에 있는 CommentDto 클래스 내부의 요소들이다.

<img width="630" height="108" alt="image" src="https://github.com/user-attachments/assets/dff93c76-36e9-4b15-b284-0c0c15a08e0c" />

---
결과 확인하기
---

프로젝트를 실행 후(자바 메인 메서드를) Talented Api Tester에서 메서드를 GET으로 다음과 같은 링크를 입력한다.

<img width="823" height="776" alt="image" src="https://github.com/user-attachments/assets/00075bef-6002-4f3a-a12f-a67e8a6473c3" />

다음과 같이 잘 나오는걸 확인 할 수 있다.

---
가독성 처리
---

<img width="587" height="278" alt="image" src="https://github.com/user-attachments/assets/042a23b5-671b-4ceb-8a4f-0d1f93094cd7" />


이 부분을 전체주석 처리해준다.

<img width="1095" height="140" alt="image" src="https://github.com/user-attachments/assets/5dd718cb-0eb8-407a-979e-18a88df71ad4" />


그 후에 다음과 같이 수정해준다.

```
(비고)
stream()은 컬렉션이나 리스트에 저장된 요소들을 하나씩 참조하며 반복 처리할때 사용
map은 스트림의 각 요소 a를 꺼내어 b를 수행한 결과로 매핑
.collect(Collectors.toList());은 스트림 데이터를 리스트 자료형으로 변환하는 코드
```

<img width="1244" height="984" alt="image" src="https://github.com/user-attachments/assets/b21e312a-ad5d-447e-a9d5-987b48d6efee" />

위 처럼 코드를 작성하여도 잘 나오는걸 확인가능하다.

---
확인 문제
---

```
(ㄱ) 레포지토리가 DB 속 데이터를 조회하거나 전달할 때 사용하는 객체 -> 엔티티
(ㄴ) 단순 데이터 전송만을 목적으로 하는 객체, 클라이언트와 서버 사이에서 사용됨 -> DTO
(ㄷ) 컨트롤러와 레포지토리의 사이에서 비즈니스 로직, 즉 처리 흐름을 담당하는 객체 -> 서비스
(ㄹ) 클라이언트의 요청을 받고 응답하는 객체로, 뷰가 아닌 데이터를 반환 -> REST컨트롤러
```


---
15.4 댓글 생성하기
---

TALENTED API Tester로 댓글 생성을 요청하고 결과를 확인해보겠다. 단, 컨트롤러를 먼저 생성해야 댓글 생성이 가능하다.

```
@PathVariable로 요청 URL의 articleId를 가져오고, 두번째 매개변수는 @RequestBody로 매개변수를 받아온다. CommentDto dto로 받는다.
```

<img width="771" height="194" alt="image" src="https://github.com/user-attachments/assets/1a6f86a6-3fb5-4c19-ab9e-9a4ff7bc7d25" />

```
CommentService의 create() 메서드는 컨트롤러의 메서드 이름과 같게 지었다. 메서드의 전달값은 댓글이 소속될 부모 게시글의 id인 articleId와 생성 데이터인 dto를 넘겼다. 하지만 여기서 return문은 댓글 생성이 성공 했을때의 응답이고, 실패한 경우에는 없다.
의외로 실패는 스프링부트가 예외처리를 담당하므로 이대로 코드를 작성하면 된다.
```

---
요청을 처리할 서비스 만들기
---

서비스에 create()메서드를 만들고, 다음과 같은 동작들을 추가한다.

<img width="877" height="296" alt="image" src="https://github.com/user-attachments/assets/f32cbffd-2612-43e2-8089-2ff33804dd2f" />

그 후에 createComment 메서드를 Comment에 생성해준다.

<img width="821" height="120" alt="image" src="https://github.com/user-attachments/assets/5d0d1196-816f-415b-b5cb-22c56e97e975" />

엔티티 생성 과정은 다음 주석과 같다. 예외는 두가지가 있고, dto에 id가 존재하는 경우와 게시글 id가 잘못된 경우

<img width="627" height="151" alt="image" src="https://github.com/user-attachments/assets/9e86a6cc-1574-49ec-ba93-7d79123cef7e" />

예외 상황 발생하지 않을 시 엔티티를 만들어서 반환하게 한다.

