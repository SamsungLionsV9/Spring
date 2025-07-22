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
<img width="749" height="385" alt="image" src="https://github.com/user-attachments/assets/baaa0247-5a51-4558-bfb6-df7b70c6e250" />






