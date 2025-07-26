---
11.1 REST API 동작 이해하기
---

`
요청 메세지의 구조: 요청라인+헤더+본문
`

```
요청이 성공시 200, 생성 완료시 201, 찾을 수 없을 때 404, 서버에 오류가 났을때 500
이렇게 5가지의 그룹으로 나눠져있다.

응답 표준으로는 JSON이 있고, 키와 값의 쌍으로 된 속성으로 데이터를 표현한다.
```

---
11.2 REST API의 구현 과정
---

```
1. 조회 요청: GET 메서드로 Article 목록 전체 혹은 단일로 조회한다. (/api/articles/{id})
2. 생성 요청: POST 메서드로 새로은 Article을 생성해 목록에 저장한다. (/api/articles)
3. 수정 요청: PATCH 메서드로 특정 Article의 내용을 수정한다. (/api/articles/{id})
4. 삭제 요청: DELETE 메서드로 특정 Article을 삭제합니다.  (/api/articles/{id})
```

`
클라이언트의 JSON 이 REST API URL을 REST 컨트롤러로 보내면 REST 컨트롤러는 ResponseEntity를 클라이언트로 보낸다.
`

---
11.3 REST API 구현하기
---

<img width="879" height="429" alt="image" src="https://github.com/user-attachments/assets/dbf36e48-4912-4ca0-a6d7-aad9e96236fb" />

<img width="850" height="672" alt="image" src="https://github.com/user-attachments/assets/ffbc7c33-fc68-4b7e-9fea-223110fc7ad8" />

`
전에 사용했던 Talented API Controller로도 해당 URL 요청을 처리할 수 있다.
`

```
*REST API와 일반 컨트롤러의 차이점: 일반 컨트롤러는 mustache 파일(뷰 페이지)을 반환하도록 되어있지만, REST 컨트롤러는 데이터를 반환한다.
```

---
11.3.2 REST API로 GET 구현하기
---

<img width="596" height="488" alt="image" src="https://github.com/user-attachments/assets/40c8429c-c30a-4e3f-a246-b97e58009396" />

<img width="849" height="813" alt="image" src="https://github.com/user-attachments/assets/22d1b399-dce5-42f3-839c-5455eadfbe34" />

---
단일 게시글 조회하는법
---
`
{id}를 붙히면 게시글을 하나씩 조회가 가능하다.
`

<img width="602" height="220" alt="image" src="https://github.com/user-attachments/assets/4eab1c18-4d58-415c-96a4-65f6b30bfee0" />

---
11.3.3 POST 구현
---

<img width="546" height="141" alt="image" src="https://github.com/user-attachments/assets/b457c633-0c81-424d-90c4-58b1d2ff1969" />

<img width="853" height="846" alt="image" src="https://github.com/user-attachments/assets/15b5128f-d1d5-4599-966c-865bfb9a8daf" />

`
API Tester에서 다음처럼 데이터를 추가해준다.
`

<img width="812" height="816" alt="image" src="https://github.com/user-attachments/assets/80ea865d-6f02-4046-8716-7b3c33bc1aaa" />

---
11.3.4 PATCH 구현
---

<img width="721" height="403" alt="image" src="https://github.com/user-attachments/assets/10d81702-02bd-4a54-9a1f-5854b75bee1c" />

<img width="806" height="766" alt="image" src="https://github.com/user-attachments/assets/83fa85ad-5e53-450a-bb00-ed41c5b4bd63" />

`
1번 게시물을 다음과 같이 바뀐걸 알 수 있다. 일부 데이터만 수정도 가능하다.
`

<img width="832" height="800" alt="image" src="https://github.com/user-attachments/assets/a7a7aa1c-7af6-4303-b9bc-5820f37c4677" />

---
업데이트 및 정상 응답
---

<img width="675" height="252" alt="image" src="https://github.com/user-attachments/assets/790db3ae-f308-46d9-8838-03f5b17ebadf" />

<img width="503" height="210" alt="image" src="https://github.com/user-attachments/assets/78c48ae0-e334-45b8-9e65-53edfa648c30" />

`
patch 메서드를 Article.java에 만들어준다. 이 기능으로 기존 title은 유지되면서 content만 바뀌게 할 수 있다.
`

<img width="829" height="825" alt="image" src="https://github.com/user-attachments/assets/306867d9-ebd6-4e41-bc43-22b06a655837" />

`
바뀌지 않은 title은 null로 나타난다.
`

---
11.3.5 DELETE 구현
---

<img width="695" height="314" alt="image" src="https://github.com/user-attachments/assets/905022a5-4004-4a19-a33b-ac7c2afb7196" />

<img width="859" height="676" alt="image" src="https://github.com/user-attachments/assets/36fd1a0a-f708-45c8-8f7b-f6534f44bb3f" />

`
잘 삭제되었는지 확인하기 위해서 h2-console에 들어가면 확인가능하다. 위에서 삭제한 2번 테이블이 없어진걸 확인 가능하다.
`

<img width="620" height="380" alt="image" src="https://github.com/user-attachments/assets/2d1e426c-caa1-4ba2-a790-2682c45d9735" />


---
확인 문제
---

(ㄱ): REST API 구현을 위한 컨트롤러에 사용하는 어노테이션 ->  @RestController
(ㄴ): HTTP 요청 중 PATCH 메서드를 처리하는 어노테이션 -> @PatchMapping
(ㄷ): HTTP 요청 중 DELETE 메서드를 처리하는 어노테이션 -> @DeleteMapping
(ㄹ): REST API 요청을 받아 응답할 때 생기는 HTTP 상태 코드, 헤더, 본문을 실어 보내는 클래스 -> ResponseEntity
(ㅁ): HTTP 상태 코드를 관리하는 클래스 -> HttpStatus
