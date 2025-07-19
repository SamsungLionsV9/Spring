# 3.1 폼 데이터

---
폼 데이터의 정의
---

`
Form data(폼 데이터)는 HTML요소인 <form>태그에 실려 전송되는 데이터를 의미한다.
데이터를 전송할 때 어디로, 어떻게 보낼지를 기재한다.
`

`
<form> 태그에 실려 보낸 데이터는 서버의 컨트롤러가 객체에 담아서 받는다. 이 객체는 DTO라고 불리고, DTO로 받은 데이터는 최종적으로 DB에 저장된다.
`

# 3.2 폼 데이터를 DTO로 받는 과정


<img width="372" height="123" alt="image" src="https://github.com/user-attachments/assets/3b34ed2c-77d3-4696-8ccb-beb95a818065" />
`
책과 같이 동일하게 경로를 설정해주고 new.mustache를 생성해준다.
또한, 2장에서 사용한 header와 footer를 그대로 써줄거니 경로는 layouts 디렉토리에 있는 헤더 푸터를 지정해준다
`
<img width="634" height="220" alt="image" src="https://github.com/user-attachments/assets/c68bd50c-3b67-4d1a-9935-2c604df655b2" />

`
articleController 생성하기
`
<img width="877" height="524" alt="image" src="https://github.com/user-attachments/assets/e3dc9f82-216d-47a3-b3a1-70ae4ec30efd" />

`
뷰 페이지 결과는 다음과 같이 잘 나오는것을 확인 할 수 있다.
`

<img width="857" height="600" alt="image" src="https://github.com/user-attachments/assets/8d0503dd-39a2-410b-99d0-0055ff9f6205" />

`
여기에 new.mustache 파일에다가 부트스트랩을 적용하면 위 사진처럼 너저분한 모습에서 바뀌게된다.
`
<img width="939" height="696" alt="image" src="https://github.com/user-attachments/assets/2db6f11c-a866-41c0-8460-463964ae0f7e" />

`
Submit을 Post방식으로 제출하기
`
<img width="519" height="37" alt="image" src="https://github.com/user-attachments/assets/44a20c23-1117-4424-ad43-3d43b69ba96b" />
<img width="304" height="107" alt="image" src="https://github.com/user-attachments/assets/82994996-f159-4417-b39c-a5a547b3dc36" />

---
DTO 만드는법
---

<img width="432" height="90" alt="image" src="https://github.com/user-attachments/assets/a5d317b3-ef53-426c-8e27-a6d7c8d21546" />
`
다음과 같은 경로로 설정해준다.
그 다음, 생성자를 만들어준다, content필드 다음 행에서 우클릭->생성자를 누르면 뜬다
`
<img width="869" height="743" alt="image" src="https://github.com/user-attachments/assets/b61c3426-28b4-42e8-b053-c83743f1ba85" />

`
생성자를 만들면 하단부분에 이런식으로 나타난다.
`
<img width="601" height="253" alt="image" src="https://github.com/user-attachments/assets/8253e8cc-a662-4c19-aa81-db20c2dc8296" />

`
toString()메서드를 추가
`
<img width="622" height="155" alt="image" src="https://github.com/user-attachments/assets/4bb85ea5-379b-443f-b403-09f0d040a84a" />
```
추가하는 이유?
데이터를 잘 받았는지 확인할 toString()메서드를 추가해주는것이다.
```

---
ArticleForm의 데이터 출력 확인
---
<img width="613" height="459" alt="image" src="https://github.com/user-attachments/assets/0c1a37f3-bc5f-4f49-b5dc-73de3f61018e" />
<img width="699" height="397" alt="image" src="https://github.com/user-attachments/assets/ddba2d54-8ddb-47f4-89c4-506f384a3566" />
<img width="643" height="332" alt="image" src="https://github.com/user-attachments/assets/b949c541-b928-41a4-ada5-d2adbec1f935" />

`
최종 코드는 다음과 같고
`
<img width="825" height="354" alt="image" src="https://github.com/user-attachments/assets/d7b51524-d4ae-47e6-a3f0-6e27829f612c" />

<img width="337" height="35" alt="image" src="https://github.com/user-attachments/assets/df7232d0-6ff4-4973-991d-235ee47a2648" />
`
인텔리제이 내부에서 데이터를 입력받은것임을 확인할 수 있다.
`

---
확인문제
---
```
다음 중 옳지 않은 것을 고르세요.
1. <form>태그의 action속성에는 데이터를 전달할 URL 주소가 담긴다.
2. <form>태그의 method 속성에는 get만 사용할 수 있다.
3. @PostMapping 어노테이션은 post 방식으로 전달된 요청을 받아 컨트롤러의 메서드에 전달한다.
4. 폼 데이터를 자동으로 받으려면 입력 폼에서 <input>, <textarea>태그의 name 속성과 DTO 클래스의 필드명이 같아야한다.

-> 2(Post, put, delete도 가능함)
```

---
# 3.3 DTO를 데이터베이스에 저장하기
---

```
스프링에서는 DB에 자바로 명령을 내리려면 JPA를 사용한다. 데이터를 객체 지향적으로 관리하게 도와준다.
구성으로는 다음과 같다.
  1. 엔티티: 자바 객체를 DB가 이해할 수 있게 만든 것, 이를 기반으로 테이블이 만들어진다.
  2. 레포지토리: 엔티티가 DB속 테이블에 저장 및 관리될 수 있게 하는 인터페이스이다.

클라이언트->DTO(컨트롤러)->엔티티(레포지토리)->DB
이런 형태로 진행된다.
즉, DTO와 엔티티가 DB에 저장해달라고 명령하는것이다.
```

---
Article 클래스 만들기
---
<img width="616" height="325" alt="image" src="https://github.com/user-attachments/assets/b469ce37-85e2-4a28-b01f-1c483acd0f50" />
<img width="933" height="290" alt="image" src="https://github.com/user-attachments/assets/e42b8d60-ae4e-4317-b06b-932687d17292" />

---
Entity메서드, Article메서드 만들기
---
ArticleController.java(Entity를 사용한다는걸 코드에서 명시에준다.)
<img width="556" height="520" alt="image" src="https://github.com/user-attachments/assets/f9c95e96-fc1c-4f75-9748-1a6f5cacc08c" />

ArticleForm.java
<img width="481" height="114" alt="image" src="https://github.com/user-attachments/assets/a4347415-c0e4-4a09-b393-73ee3bf393c9" />

Article.java(Article메서드 내부 인자들이 ArticleForm.java의 toEntity()메서드의 반환값으로 전달된다.)
<img width="632" height="544" alt="image" src="https://github.com/user-attachments/assets/31ec92ab-4994-4c97-a199-8f85b8840640" />

---
ArticleRepsitory 만들기
---
여기선 클래스가 아닌 인터페이스로 만들어야한다.
경로는 다음과 같다.
<img width="399" height="211" alt="image" src="https://github.com/user-attachments/assets/c8e0d8f4-75af-48cd-ae9c-d89244a00cf2" />

<img width="574" height="315" alt="image" src="https://github.com/user-attachments/assets/ad92fd0c-fb88-4e05-91a7-aae4e2066a64" />

---
@Autowired 어노테이션
---
`
스프링부트가 미리 생성해 놓은 객체를 가져다가 연결해준다.
`

---
최종 코드 정리
---
<img width="557" height="719" alt="image" src="https://github.com/user-attachments/assets/454cbff0-1ddb-4c90-aefb-dcb7ac8a2ac3" />

<img width="743" height="224" alt="image" src="https://github.com/user-attachments/assets/116ab687-5442-446c-a3e8-e53c76f80454" />

---
확인 문제
---

(ㄱ)란 JPA에서 제공하는 어노테이션으로, 이를 부여받은 클래스를 기반으로 DB속 테이블이 생성됩니다.
(ㄴ)란 JPA에서 제공하는 인터페이스로, 이를 상속해 엔티티를 관리(CRUD)할 수 있습니다. 해당 인터페이스는 2개의 제네릭 요소를 받습니다.
하나는 관리할 대상 엔티티의 클래스 타입이고, 또 다른 하나는 그 엔티티의 대푯값 타입입니다.
(ㄷ)은 스프링 부트에서 제공하는 어노테이션으로, 이를 컨트롤러의 필드에 부여할 수 있습니다. 해당 어노테이션은 스프링 부트가 만들어놓은 객체를 가져와 주입해줍니다.

(ㄱ)@Entity
(ㄴ)CrudRepository
(ㄷ)@Autowired

---
3.4 H2 DB
---
```
1. src>main>resources>application.properties에서 다음 코드 확인
<img width="280" height="23" alt="image" src="https://github.com/user-attachments/assets/ca5ef09e-1eb2-415b-b29d-d89720b127b5" />

2. application.properties에 다음 코드 추가
spring.h2.console.enabled=true

3. 서버 시작 후 JDBC URL에 인텔리제이의 Run 탭에서 ctrl+f를 눌러서 jdbc를 검색 후 나오는 결과를 JDBC URL칸에 입력해준다.
<img width="446" height="77" alt="image" src="https://github.com/user-attachments/assets/8abe83f6-2828-414d-9589-05868d126c2e" />

그 전에 build.gradle에 의존성부분에 runtimeOnly 'com.h2database:h2'를 추가해줘야 h2-console 창이 뜬다.
<img width="499" height="460" alt="image" src="https://github.com/user-attachments/assets/6a7028ea-5539-40c1-bed8-fe59812b92d8" />

<img width="545" height="371" alt="image" src="https://github.com/user-attachments/assets/b8beb39a-22ca-460c-8052-f9876bc30b6c" />

JDBC URL을 넣고 연결 시 <img width="859" height="711" alt="image" src="https://github.com/user-attachments/assets/d5a7117b-c77a-4c45-8015-99956ed7c765" />
다음과 같은 창이 뜬다. 정상적으로 접속한 것 이다.
```

---
3.4.2 데이터 조회
---
```
<img width="237" height="33" alt="image" src="https://github.com/user-attachments/assets/f47b24a4-49e8-4b74-90c4-b8d8fe8e55cc" />
여기서 Run 버튼을 누르면 테이블 조회가 가능한데, 데이터는 테이블에 행 단위로 저장이된다.
행 하나하나는 레코드라고 한다.

<img width="214" height="106" alt="image" src="https://github.com/user-attachments/assets/505cce61-9bfa-4c29-9e7d-0be0cd716f92" />

<img width="750" height="310" alt="image" src="https://github.com/user-attachments/assets/77b06fc1-ea7a-4dee-957d-a25de6934888" />
이제 데이터를 articles/new에 집어넣고 제출하면

<img width="750" height="310" alt="image" src="https://github.com/user-attachments/assets/d0c2ebd9-66eb-4e7f-9bd2-0c1afcf8afa6" />

테이블에 입력한 정보가 잘 들어간걸 확인할 수 있다.
```
레코드 직접 삽입하기
```
INSERT INTO article(id, title, content) VALUES(3, 'ccccc', '33333');을 DB입력창에 작성 후 실행하면
직접 입력된다.
<img width="147" height="23" alt="image" src="https://github.com/user-attachments/assets/6c568f5e-6db6-4ee1-9157-bbb3f7331e55" />
```

---
확인문제
---
```
(ㄱ) DB에서 데이터를 저장하는 틀
(ㄴ) 테이블의 행을 표현하는 다른 말
(ㄷ) 데이터의 생성/조회/수정/삭제를 뜻하는 말
(ㄹ) 테이블에 데이터를 생성하는 SQL문
(ㅁ) 테이블에 데이터를 조회하는 SQL문

(ㄱ) 테이블
(ㄴ) 레코드
(ㄷ) CRUD
(ㄹ) INSERT
(ㅁ) SELECT
```










