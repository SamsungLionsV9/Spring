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





