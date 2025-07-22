---
7.1 데이터 수정(Update)
---
원리
```
기존 글 불러오기: show(상세 페이지)->컨트롤러->DB에 데이터 요청->서버로 전송 후 전달받은 데이터를 모델에 등록 -> 뷰 페이지 생성-> 수정 페이지로 전달

기존 글 수정: 수정 페이지의 폼 데이터를 DTO에 담음->컨트롤러로 전달->DTO를 엔티티로 변환->DB에서 기존 데이터를 수정 데이터로 갱신->수정 데이터를 상세 페이지로 리다이렉트
```

---
수정 페이지(Update) 실습
---
1. 상세 페이지에 Edit버튼 추가(아래 코드는 article을 일회성으로 사용하는 경우이다.)
<img width="614" height="23" alt="image" src="https://github.com/user-attachments/assets/b1bfdf0a-d9de-4292-ad74-b8a6a4a8ccb4" />
<img width="338" height="307" alt="image" src="https://github.com/user-attachments/assets/04daa8c5-33c2-4137-aadf-c3812dd945cd" />

---
수정 기능 컨트롤러
---
<img width="682" height="202" alt="image" src="https://github.com/user-attachments/assets/23ad6ba8-c07f-4cfb-8ef3-f60f0b2838e4" />

```
1. DB에서 데이터를 가져올때 articleRepository의 findById(id)메서드로 데이터를 찾아서 가져온다. 데이터를 찾지 못할 시 null 반환
2. id 변수는 메서드의 매개변수로 받아오고 자료형은 Long으로 작성한다. GetMapping()어노테이션의 URL주소에 있는 id를 받아오는것이므로 데이터 타입 앞에 @PathVariable 어노테이션을 추가해준다.
3. 모델에 데이터를 등록할떄에는 메서드의 매개변수로 model 객체를 받아온다. article이라는 이름으로 앞에서 가져온 articleEntity를 등록하고, DB에서 가져온 데이터를 article이라는 이름으로 뷰 페이지에서 사용할 수 있다.
```

---
수정 폼 만들기
---

```
edit.mustache 생성, new.mustache와 구조가 비슷하므로 복사해서 가져온다음 헤더와 푸터 사이에 붙혀넣기해준다.
수정 페이지에서 Back 링크를 누르면 상세 페이지로 돌아가야하므로 href속성값을 "/articles/{{article.id}}로 수정한다.
```
<img width="583" height="302" alt="image" src="https://github.com/user-attachments/assets/9417abdd-c775-4496-9df9-0ca789be00c4" />

```
이후 수정 페이지에서 내용이 보일 수 있도록 value={{article.title}} 속성을 추가해준다.
상단 #article은 article 범위 전체 내에서 사용하겠다라는 의미이며, title, content, id 각각 value형태로 받기 위해서 중괄호 내부에 작성하였다.
```
<img width="748" height="371" alt="image" src="https://github.com/user-attachments/assets/8eeef06a-b0d0-4259-b567-cb01ecc667a2" />

<img width="858" height="491" alt="image" src="https://github.com/user-attachments/assets/de0deedc-6667-4f90-bf52-19b4bfbbdbb5" />

```
이렇게 수정폼이 출력이 되는걸 확인 할 수 있다.
```

---
7.3 DB갱신하기
---
```
클라이언트와 서버 간 처리 흐름
1. MVC: 서버 역할을 분담해서 처리하는 기법
2. JPA: 서버와 DB간 소통에 관여하는 기술
3. SQL: DB데이터를 관리하는 언어
4. HTTP: 데이터를 주고받기 위한 통신 규약
```

```
HTTP메서드
1. POST: 데이터 생성 요청
2. GET: 데이터 조회 요청
3. PATCH(PUT): 데이터 수정 요청
4. DELETE: 데이터 삭제 요청
```

---
더미 데이터 설정하기
---
1. SQL문 작성하기(resources 파일에 data.sql 작성)
<img width="695" height="85" alt="image" src="https://github.com/user-attachments/assets/f31ca24c-ec40-412d-a9a6-56fe7ff1fc66" />

2. application.properties에 옵션 추가하기
<img width="630" height="131" alt="image" src="https://github.com/user-attachments/assets/a3b6edb7-fd7f-4733-b09d-759216530b51" />

3. 더미데이터를 넣고 난 후 실행
<img width="597" height="380" alt="image" src="https://github.com/user-attachments/assets/4edcd3d7-e928-4449-885a-8ebf7fd82280" />

---
수정 페이지 변경하기
---
1. 템플릿 파일 폼 태그 수정
<img width="719" height="120" alt="image" src="https://github.com/user-attachments/assets/60510115-cdb8-4020-b91d-247ba6fb4851" />
edit.mustache에 폼태그 부분에 업데이트를 추가한다. PATCH가 아닌 POST를 사용한 이유? form태그는 GET과 POST 메서드만 지원하기 때문이다.

2. 수정 폼으로 제목, 내용, id까지 서버에 전송하기 위한 코드
<img width="452" height="56" alt="image" src="https://github.com/user-attachments/assets/278873af-67fe-493d-8083-f2f853c43250" />

---
수정 데이터를 DTO에 담기
---
<img width="484" height="186" alt="image" src="https://github.com/user-attachments/assets/e2e1ff48-c5ab-4e01-915a-63ab6ffe32b3" />

ArticleForm에 id와 관련된 변수 추가
<img width="642" height="476" alt="image" src="https://github.com/user-attachments/assets/9e4ca2eb-5b0a-49ca-ab43-194929b63a5e" />

컨트롤러에 로그를 찍어 확인하기
<img width="281" height="74" alt="image" src="https://github.com/user-attachments/assets/8c1a9cf3-3ac0-4d81-915a-724afe4ead71" />

`
현재는 오류가 뜰텐데, 9장에서 SQL쿼리 로그 확인하기에서 다룰 예정이니 일단은 넘어간다.
`

<img width="740" height="374" alt="image" src="https://github.com/user-attachments/assets/51e4413c-8cfb-46b3-8af5-4e03178bceeb" />

```
위 사진은 수정된 컨트롤러 코드이다. DB의 값을 저장하고 수정하는 역할을 한다.
이 실습에서는 클릭을 통해 수정 요청을 하므로 target이 null이 되지 않는다.
수정 시 입력 대상의 존재 여부를 확인하기 위한 if문이 사용되었습니다.
```

---
테스트
---

데이터를 수정해주고
<img width="475" height="451" alt="image" src="https://github.com/user-attachments/assets/f49f11f7-39bd-42b0-80c9-707fcdfc902e" />

JDBC URL 입력 후 실행하면 데이터가 바뀌어있는걸 확인 할 수있다.
<img width="218" height="181" alt="image" src="https://github.com/user-attachments/assets/a5b198ad-d895-41f7-8479-772c4ace7b57" />

이제 수정되면 반영된 페이지로 리다이렉트 해주는 코드를 작성해준다.
<img width="463" height="46" alt="image" src="https://github.com/user-attachments/assets/7758d225-aa22-4872-9c30-95cfc9089d35" />

수정된 결과를 반영한 페이지로 리다이렉트를 해준다.
<img width="787" height="385" alt="image" src="https://github.com/user-attachments/assets/3132f6bf-b649-483f-a730-5635d7b5b14c" />

---
SQL문으로 직접수정하기
---

```
localhost:8080/h2-console에 들어가서 실행한다.
Run해서 실행해준다.
article 테이블의 모든 제목을 KKK, 컨텐츠를 LLL로 바꿔보겠다.
```
<img width="412" height="264" alt="image" src="https://github.com/user-attachments/assets/60bb65ea-05b3-49f8-9845-23774a7203fc" />

```
실행 후 변경된 결과를 확인한다.
모두 바뀐걸 확인할 수 있다.
업데이트 이후 조회하려면 SELECT문으로 조회한다.
```
<img width="247" height="365" alt="image" src="https://github.com/user-attachments/assets/3a17b336-dda9-4885-8d2a-b1e1e155b44f" />

```
특정 글만 바꾸고 싶을때는 UPDATE문에 WHERE 조건절을 추가한다.
```

<img width="427" height="275" alt="image" src="https://github.com/user-attachments/assets/abc6e690-5ee2-421f-ab76-b93806ab1f04" />

<img width="305" height="378" alt="image" src="https://github.com/user-attachments/assets/bb812f9b-d5a2-4313-b6c6-8d6fafe29a16" />

---
확인 문제
---

```
데이터 생성   INSERT   (ㄱ)
(ㄴ)        SELECT   GET
데이터 수정   (ㄷ)      PATCH(PUT)
데이터 삭제   DELETE   DELETE
```
(ㄱ) POST
(ㄴ) 데이터 조회
(ㄷ) UPDATE




