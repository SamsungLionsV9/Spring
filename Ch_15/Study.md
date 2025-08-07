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

<img width="528" height="123" alt="image" src="https://github.com/user-attachments/assets/6c277d3e-82a3-4942-a4e3-ce1266722bc3" />

```
결과응답에서는 서비스에서 반환받은 dtos를 응답 본문에 실어 보낸다. REST API의 응답은 ResponseEntity에 실어 보낸다고 했으므로, return 문에 null을 지우고 ResponseEntity의 상태는 ok, 본문에는 dtos(조회한 댓글 목록)을 실어서 보낸다.

하지만 return문에는 에러가 날텐데, 이는 CommentDto 클래스가 아직 없기 때문이다.
```

---
CommentDto.java 만들기
---







