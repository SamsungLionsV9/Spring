---
17.1 댓글 등록의 개요
---

```
<실습 개요>
1. _new에 댓글 입력 폼 만들기
2. 댓글 작성 버튼을 클릭하여 REST API 요청 보내기
3. API를 활용하여 댓글을 자바스크립트 객체로 만들고, 이 객체를 JSON 문자열로 변환하는것의 목표
```

```
<사용 될 자바스크립트 API>
1. document.querySelector(): 웹 페이지에서 특정 요소(버튼)을 찾아서 반환함
2. addEventListener(): 특정 요소에 이벤트가 발생(버튼 클릭) 했을 때 특정 동작(댓글 객체 전달)을 수행함.
3. fetch(): 웹 페이지에서 REST API 요청(POST 요청)을 보냄.
```

---
17.2 댓글 생성 뷰 페이지 만들기
---

부트스트랩 홈페이지에서 부트스트랩 v5.0.2를 선택하고 card로 검색하고 Body 스타일을 찾고 코드를 복사한다.

<img width="870" height="742" alt="image" src="https://github.com/user-attachments/assets/dea15040-41c6-4cf9-ba60-e3cc29e7148d" />

_new.mustache 파일을 열고 빈 화면에 복사한 코드를 붙혀 넣은 후에 코드를 작성해준다. 작성한 코드는 다음과 같다. 여백을 2만큼 줘야한다.

<img width="802" height="843" alt="image" src="https://github.com/user-attachments/assets/6ff8805e-99d6-4bf7-abe6-90bd04efd9ee" />

form에서 Overview 스타일의 코드를 찾고 복사후 붙혀넣어준다. 그리고 form-check 부분을 지워준다.

<img width="862" height="437" alt="image" src="https://github.com/user-attachments/assets/70ee80e6-7b74-4eea-94b5-49372e5b4056" />

폼을 전부 알맞게 수정하면 다음과 같은 형태로 바뀐다.

<img width="798" height="349" alt="image" src="https://github.com/user-attachments/assets/30c6d920-2016-493a-bc2e-9745bf225f55" />

여기서 히든 인풋을 사용해야하는데, 댓글은 부모 게시글의 id를 가져야하기 때문이다. 

`
히든 인풋(hidden input): 웹 페이지에 표시되지 않는 요소, 보이지는 않지만 값을 가지고 있어야 할 때 사용함
`

<img width="629" height="205" alt="image" src="https://github.com/user-attachments/assets/803477cc-6000-4fc0-a9f1-10a190a7d084" />

히든 인풋을 적용하여 부모 게시글의 id값을 가진 댓글의 속성을 만들었다. 하단 제출 버튼에도 댓글 작성으로 변경하였다.

<img width="865" height="993" alt="image" src="https://github.com/user-attachments/assets/09ec0897-958a-4524-95b0-41b86f2749cf" />

이렇게 5번 게시글 하단에 댓글 작성 폼이 추가된걸 확인 가능하다.

