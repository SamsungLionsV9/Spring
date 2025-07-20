---
5.1 데이터 조회
---

```
1. 사용자가 데이터를 조회해달라고 웹 페이지에서 URL 요청을 보냅니다.
2. 서버의 컨트롤러가 요청을 받아 해당 URL에서 찾으려는 데이터 정보를 레포지토리로 전달합니다.
3. 레포지토리는 정보를 가지고 DB에 데이터 조회를 요청합니다.
4. DB는 해당 데이터를 찾아 이를 엔티티로 반환합니다.
5. 반환된 엔티티는 모델을 통해 뷰 템플릿으로 전달됩니다.
6. 최종적으로 결과 뷰 페이지가 완성되어 사용자의 화면에 출력됩니다.
```

---
5.2 단일 데이터 조회하기
---

```
예를 들어, localhost:8080/articles/1 이런식으로 게시글 1번을 조회할 수 있다.
즉, 1번부터~n번까지 게시물 번호마다 볼 수 있게 해주는 URL이다.

하지만, 이걸 하지 않으면 오류가 뜰것이다.
컨트롤러 코드에 {}를 활용하여 id번호를 변수로 사용할 수 있다.
```
<img width="492" height="258" alt="image" src="https://github.com/user-attachments/assets/27e57ed8-4b90-45c8-94ea-bffa1b8d98eb" />

이 코드를 추가해준다면

<img width="910" height="40" alt="image" src="https://github.com/user-attachments/assets/e4af29b8-6019-4d92-8b4c-cff19c242d99" />

페이지가 실제로 로드는 안되지만, 로그에는 찍힌다는것을 확인 할 수 있다.

```
정리를 해보자면
클라이언트가 /articles/1을 요청하면
컨트롤러가 받고, 그걸 모델로 전달한 후, 뷰로 출력하는 형태이다.
```

---
데이터를 조회하여 출력 및 조회
---
<img width="576" height="220" alt="image" src="https://github.com/user-attachments/assets/8aaa8cb2-801e-40aa-87dd-0d531345ad9a" />

<img width="453" height="477" alt="image" src="https://github.com/user-attachments/assets/f05b9df0-d5ae-48fd-afb8-03b2f79fb6f5" />

```
상단 사진에서 보듯이 컨트롤러 하단에 id를 조회하는 코드와 모델에 데이터를 등록하고, 뷰 페이지를 반환하는 형태의 코드를 작성하였고,
뷰 페이지 반환에서 show를 반환하기에, show.mustache를 작성하였다.

모델을 사용하기 위해 id 조회에서 model객체를 받아오는걸 괄호안에 적었디, 모델에 데이터를 등록할때엔 문자열명, 오브젝트값 이 순서인데
오브젝트값은 Spring이 자동으로 넣어주는 파라미터가 아니기 때문에 안적어도 작동이됨. 오히려 적으니 오류가 발생하는 상황
또한, 머스태치 파일에서는 값들을 모두 중괄호 처리하여 변수처리하였다.


하지만, 데이터를 웹에서 입력하면 막상 데이터는 제대로 들어가지 않음을 확인할 수 있다.
2025-07-20T16:20:20.437+09:00  INFO 2015 --- [nio-8080-exec-5] c.e.f.p.controller.ArticleController     : id: 1
2025-07-20T16:20:56.252+09:00  INFO 2015 --- [nio-8080-exec-8] c.e.f.p.controller.ArticleController     : ArticleForm(title=오늘은, content=뭐하지)
2025-07-20T16:20:56.252+09:00  INFO 2015 --- [nio-8080-exec-8] c.e.f.p.controller.ArticleController     : Article(id=null, title=null, content=null)
2025-07-20T16:20:56.290+09:00  INFO 2015 --- [nio-8080-exec-8] c.e.f.p.controller.ArticleController     : Article(id=1, title=null, content=null)
2025-07-20T16:20:56.292+09:00  WARN 2015 --- [nio-8080-exec-8] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'POST' is not supported]
2025-07-20T16:27:36.809+09:00  WARN 2015 --- [l-1 housekeeper] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Retrograde clock change detected (housekeeper delta=28s11ms), soft-evicting connections from pool.
```

---
기본 생성자 추가
---
@NoArgsConstructor
`
이 어노테이션을 사용하면 기본 생성자를 추가해준다.
`
<img width="482" height="380" alt="image" src="https://github.com/user-attachments/assets/97944db0-66d7-4f99-a793-f5d09ebc3991" />
```
이 어노테이션을 추가하면 하단 Article 생성자가 다음과 같은 양식으로 작성되면 된다.
title과 content 이런식으로 뷰에서 보이는 입력되는 데이터 수와 동일하게 맞추어 주면 된다.
```
<img width="722" height="66" alt="image" src="https://github.com/user-attachments/assets/5dd397dd-020e-4c2f-87e2-126a863c6f12" />

그 후에 /articles/1에 접속하면 저장이 된다고 떠야하는데 아직 뷰 부분이 완성되지 않았기에 나오진않음.

---
확인 문제
---

*(ㄱ)이란 URL 요청으로 들어온 전달값을 컨트롤러의 매개변수로 가져오는 어노테이션이다.
*(ㄴ)이란 JPA의 CrudRepostitory가 제공하는 메서드로, 특정 엔티티의 id값을 기준으로 데이터를 찾아 Optional 타입으로 반환한다.

(ㄱ) @PathVariable
(ㄴ) findById()

---
5.3 데이터 목록 조회
---
```
캐스팅(형 변환)을 활용하여 메서드의 반환타입으로 맞춰줄 수 있다.
업캐스팅 -> 넓은 범위로 해석
다운캐스팅 -> 좁은 범위로 해석
```
<img width="501" height="88" alt="image" src="https://github.com/user-attachments/assets/a0cf3bbf-9167-4fca-b8b2-66e7190f6bdc" />
```
ArrayList(Class)->List(interface)->Collection(interface)->Iterable(interface)
```

5장에 있는 컨트롤러부분을 완성하면 다음과 같다.
<img width="669" height="426" alt="image" src="https://github.com/user-attachments/assets/460a7056-25fe-4483-b39b-5695bee3dea2" />

경로
<img width="351" height="123" alt="image" src="https://github.com/user-attachments/assets/2fb532db-a0a8-4fad-a7cc-268e53fad1fa" />


---
데이터 입력 후 조회
---
<img width="860" height="331" alt="image" src="https://github.com/user-attachments/assets/ff60a3af-1b87-46fc-91cb-a4c40c2161fc" />

<img width="1169" height="209" alt="image" src="https://github.com/user-attachments/assets/7163e6f7-05b2-4c54-b2c6-d9e8fa951d66" />

---
확인문제
----

1. (ㄱ)이란 JPA의 CrudRepository가 제공하는 메서드로, 특정 엔티티를 모두 가져와 Iterable 타입으로 반환합니다.

(ㄱ) findAll()

