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

폼을 전부 알맞게 수정하면 다음과 같은 형태로 바뀐다. 추가적으로 하단에서 fetch()함수를 쓰려면 제출을 button형태로 해야한다.

<img width="798" height="349" alt="image" src="https://github.com/user-attachments/assets/30c6d920-2016-493a-bc2e-9745bf225f55" />

여기서 히든 인풋을 사용해야하는데, 댓글은 부모 게시글의 id를 가져야하기 때문이다. 

`
히든 인풋(hidden input): 웹 페이지에 표시되지 않는 요소, 보이지는 않지만 값을 가지고 있어야 할 때 사용함
`

<img width="705" height="120" alt="image" src="https://github.com/user-attachments/assets/9aaf6485-3ac5-4558-9799-b41016e6b447" />

히든 인풋을 적용하여 부모 게시글의 id값을 가진 댓글의 속성을 만들었다. 하단 제출 버튼에도 댓글 작성으로 변경하였다.

<img width="865" height="993" alt="image" src="https://github.com/user-attachments/assets/09ec0897-958a-4524-95b0-41b86f2749cf" />

이렇게 5번 게시글 하단에 댓글 작성 폼이 추가된걸 확인 가능하다.

---
17.3 자바스크립트 댓글 달기 기능
---

_new.mustache 하단에 <script> 코드를 추가하고 내부를 {}블록으로 잡아준다.

<img width="257" height="171" alt="image" src="https://github.com/user-attachments/assets/e49f285f-d20d-4733-8187-a1f11ce3bc31" />

```
자바스크립트의 querySelector() 메서드는 웹 페이지에서 특정 요소를 선택할 때 사용한다. id, name, class 등등의 태그에 값을 입력하면 해당 속성 값을 가진 대상을 반환해준다. 여기서는 id값으로 특정 요소를 선택해준다.
```

<img width="805" height="193" alt="image" src="https://github.com/user-attachments/assets/2349d632-acf0-403e-8303-75a7c125019c" />

```
댓글 작성 버튼의 id값인 comment-create-btn을 #과 함께 querySelector()메서드로 입력하고, 이렇게 찾은 댓글 작성 버튼을 상수 타입의 commentCreateBtn 변수에 저장한다.
```

https://developer.mozilla.org/en-US/docs/Web/API/Element/querySelector에 자세히 기재되어있음.

<img width="852" height="700" alt="image" src="https://github.com/user-attachments/assets/4c77ceed-05e0-43b4-93d5-b6abcb0cd7ff" />


스크립트 부분의 각 객체들(body부분에선 id)를 가져와서 #을 활용해서 적어준다. 댓글 객체가 잘 만들어졌는지 확인을 위한 콘솔 출력을 한다.

<img width="657" height="172" alt="image" src="https://github.com/user-attachments/assets/ef126561-2c4a-4692-939c-16224e99880b" />

---
17.4 자바스크립트로 REST API 호출하고 응답 처리하기
---

fetch()함수를 활용하여 웹 페이지에서 GET, POST, PATCH, DELETE같은 요청을 보내고 응답을 받을 수 있다.

<img width="737" height="270" alt="image" src="https://github.com/user-attachments/assets/17344d40-6c6e-4db2-a07b-80a520d7c500" />

```
1. 첫 번째 전달값으로 API 주소를 가지고 있는 url을 넘긴다.
2. 두 번째 전달값으로 요청 메서드, 헤더 정보, 전송 본문을 넘김, 전송 본문은 comment 객체를 JSON 형태로 변환하여 전송하기 위해서
JSON.stringify() 메서드를 사용한다. 헤더 정보에 전송 본문의 데이터 타입이 JSON임을 명시하는 내용이 들어간다.
```

추가적으로 여기에 댓글이 잘 등록되었다는 alert문을 추가해준다. 댓글 생성 후 메세지까지 출력되었다면, 웹 페이지를 새로고침해준다.

<img width="673" height="238" alt="image" src="https://github.com/user-attachments/assets/b8d88fd6-e156-4dbf-9bee-8bbd0e93d5eb" />

<img width="857" height="1028" alt="image" src="https://github.com/user-attachments/assets/dc554424-94b3-4fca-bad2-50115deb86f4" />





