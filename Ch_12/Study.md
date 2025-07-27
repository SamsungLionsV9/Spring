---
12.1 서비스&트랜잭션
---

```
서비스: 컨트롤러와 리파지터리 사이에 위치하는 계층, 서버의 핵심 기능(비즈니스 로직)을 처리하는 순서를 총괄함
트랜잭션: 서비스 업무 처리의 단위, 모두 성공해야 하는 일련의 과정을 의미한다.
롤백: 트랜잭션이 실패로 돌아갈 경우 진행 초기단계로 돌리는 것을 의미한다.
```

---
12.2 서비스 계층 만들기
---

```
1. ArticleApiController 전체 주석 처리
2. 객체 주입된 리파지터리를 서비스화
```

<img width="553" height="237" alt="image" src="https://github.com/user-attachments/assets/f418514a-1a5b-4b9f-aeea-a14eb99e9fbb" />

```
3. ArticleService 패키지 생성 후 ArticleService(자바 클래스)를 service 패키지에서 생성
4. @Service 어노테이션을 붙히기, 자동적으로 스프링부트에 서비스 객체를 생성한다.
5. @Autowired를 통해서 ArticleService 클래스를 REST 컨트롤러에서 연결해서 가져온다.
6. ArticleService에서 레포지토리와 협업을 위해서 게시글 레포지토리 객체를 주입하고, 앞서 주석처리한걸 하나씩 풀면서 리팩터링한다.
```

<img width="568" height="418" alt="image" src="https://github.com/user-attachments/assets/65f77a4b-b92f-4f15-89db-ad3daf8d779f" />

<img width="686" height="297" alt="image" src="https://github.com/user-attachments/assets/9281275d-9336-4323-9eae-5358ac4e9e35" />

---
12.3 게시글 조회 요청 개선
---

```
컨트롤러에서 GET 메서드 부분을 전부 주석 해제하고, 다음과 같이 컨트롤러를 수정한다.
```

<img width="423" height="281" alt="image" src="https://github.com/user-attachments/assets/0bb3ca59-b6ed-425c-8740-2be862e11fda" />

```
그리고 index라는 메서드를 ArticleService에 생성한다.
```

<img width="422" height="97" alt="image" src="https://github.com/user-attachments/assets/c8a8b088-5e4b-485d-a014-2734c6e8c5bc" />

```
그리고 ArticleService에 return articleRepository.findAll();를 넣고 DB에서 조회한 결과를 반환하게 한다.
```

<img width="623" height="226" alt="image" src="https://github.com/user-attachments/assets/77da00f7-54c9-444a-9d7a-522d404e9c33" />

```
이 후에 서버 실행 후 API test를 하면 다음과 같이 정상적으로 데이터가 조회되는걸 확인 가능하다.
```

<img width="864" height="820" alt="image" src="https://github.com/user-attachments/assets/66ec58f6-18e6-4d24-b61b-da23f9f2ea77" />

---
단일 게시글 조회 요청 개선
---

```
컨트롤러에서 주석을 해제하고 다음과 같이 바꾸고, show메서드를 ArticleService에 생성해준다.
```

<img width="424" height="126" alt="image" src="https://github.com/user-attachments/assets/3815cc16-dad3-4b7b-b050-32caf6ec421a" />

<img width="550" height="110" alt="image" src="https://github.com/user-attachments/assets/fb466e14-74f8-48f2-96ff-2459749d8d1a" />

---
게시글 생성 요청 개선
---

```
dto.toEntity()를 삭제하고 articleService.create()를 호출한다.
return문에서 결과로 받은 created가 null이 아니면 good 요청을 보내고 그렇지 않으면 bad 요청을 보내도록 한다.
삼항 연산자를 통해서 조건에 따라 실행되게 한다.
```

<img width="648" height="225" alt="image" src="https://github.com/user-attachments/assets/73d33957-e335-4a82-a238-8673d39d0271" />

```
ArticleService에 create메서드를 생성한다.
```

<img width="444" height="133" alt="image" src="https://github.com/user-attachments/assets/a042e480-a217-4cf5-8b16-9c466a446341" />

```
이 상태에서 서버를 실행 후 API테스트에서 게시글을 입력하면 정상적으로 게시글이 작성되는걸 확인 할 수 있다.
```

<img width="817" height="806" alt="image" src="https://github.com/user-attachments/assets/40146275-175a-440e-add8-e281ed3a1215" />

```
하지만, 이미 존재하는 id가 있다면 null을 반환하는 코드를 추가해서 게시글이 겹치는걸 막아줘야한다.
```

<img width="327" height="98" alt="image" src="https://github.com/user-attachments/assets/e274fcf5-a418-4404-8fb1-ee6ebbdf5a1c" />

---
게시글 수정 요청 개선
---

<img width="716" height="217" alt="image" src="https://github.com/user-attachments/assets/b41b9285-0fd2-4bed-b0af-bff6bf3bc028" />

```
컨트롤러 코드는 다음과 같이 수정해준다. 삼항 연산자를 활용하여 업데이트 된 내용이 있다면 null이 아니라는 의미라서 수정이 잘 되었다는 이야기이다. 만약 내용이 없다면 ResponseEntity의 BAD_REQUEST를 반환해서 보내게한다.
```

<img width="640" height="399" alt="image" src="https://github.com/user-attachments/assets/c758b8bd-6b6d-4a91-88ae-ff428cdfe4d8" />

```
그리고 기존에 있던 컨트롤러 코드를 잘라내어 ArticleService의 update메서드로 옮겨준다. 옮겨준 다음 잘못된 요청 처리 부분에서 응답은 컨트롤러가 하므로 return은 null;로 바꾸고, 업데이트 부분도 컨트롤러가 하므로 여기서는 수정 데이터만 반환하게끔 updated;를 반환하게한다.
```

---
게시글 삭제 요청 개선
---

```
컨트롤러에서는 ArticleService에 생성된 delete 메서드를 통해서 게시글을 삭제해주게 하고, 하단에 삼항연산구문은 삭제 결과에 따라 삭제가 되었으면 NO_CONTENT를 반환시키고, 없는 게시물을 삭제하려고 할때는 BAD_REQUEST를 반환하게 한다.
```

<img width="689" height="223" alt="image" src="https://github.com/user-attachments/assets/9a95e602-ebef-48cc-acfd-58997f98677b" />

```
ArticleService에서는 대상을 찾고, 없으면 null을 반환하게 하고, 잘못된 요청을 처리하게 된다면 if문으로 null을 반환하게 하며, 대상을 삭제하게 되면, 레포지토리에서 target이 삭제되게하고, 삭제된 target 자체를 반환하게 코드를 작성한다.
```

<img width="725" height="279" alt="image" src="https://github.com/user-attachments/assets/a7dc0576-2278-4707-b63c-44397a45c890" />

```
테스트 해보면 게시글 1번이 잘 삭제 된것을 확인 할 수 있다.
```

<img width="831" height="615" alt="image" src="https://github.com/user-attachments/assets/26f954fb-d618-4d36-a5d3-d90250b8394d" />

---
확인 문제
---

```
1. 클라이언트의 요청이 오면 클라이언트-컨트롤러-서비스-레포지토리-DB 순으로 작업해 결과를 응답한다. 이를 음식점에 빗대어 클라이언트를 손님 DB를 식자재 창고라고 할때 '컨트롤러->서비스->리파지터리'의 관계로 적절한 것은?
```

-> 웨이터-주방장-보조 요리사
