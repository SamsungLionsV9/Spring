---
19.1 댓글 삭제의 개요
---

```
<과정>
1. 댓글 삭제 버튼 추가하기
2. 삭제 버튼 클릭하여 REST API 요청 보내기

2단계에서 삭제 버튼 클릭 이벤트를 처리할 때 삭제 버튼을 통해 댓글의 id값을 전달하는 과정
어느 댓글에서 삭제 요청하였는지 알아야 서버를 통하여 댓글 삭제가 가능하기 때문에 주의하여야한다.
```

---
19.2 댓글 삭제 버튼 추가하기
---

댓글 삭제 버튼을 수정 버튼 우측에 추가하겠다.

<img width="731" height="295" alt="image" src="https://github.com/user-attachments/assets/e0a55bf9-40b5-465c-b766-50d5a3b7e56c" />

클래스 선택자(.class)의 형태로 HTML 문서의 요소를 선택 가능하다. 17~18장에서는 (#id)로 했었다. 하단 사진참고

<img width="522" height="25" alt="image" src="https://github.com/user-attachments/assets/7eac8a88-63af-4195-bdf9-8530d0535b23" />

<img width="854" height="1022" alt="image" src="https://github.com/user-attachments/assets/1a4178a7-afa0-464c-a4a5-6ea33a187831" />

웹 페이지에 접속해보면 수정 버튼 옆에 삭제 버튼이 추가된것을 확인 가능하다.

---
19.3 자바스크립트로 댓글 삭제하기
---

```
<개요>
1. _list.mustache의 최 하단에 스크립트를 작성하여 클릭 이벤트를 감지할 것 이다.
2. 삭제 버튼을 변수로 받아온다. 클래스 선택자를 이용할것이므로 document.querySelector(".comment-delete-btn")으로 삭제 버튼을 클릭 후 commentDeleteBtn 변수에 저장한다.
```

<img width="722" height="302" alt="image" src="https://github.com/user-attachments/assets/6c8ce9db-9fb6-424a-9f97-a61ae0e1dcc6" />

<img width="522" height="25" alt="image" src="https://github.com/user-attachments/assets/d8c190c5-b003-4884-b502-462f47fdcf58" />


