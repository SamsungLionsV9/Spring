---
18.1 댓글 수정의 개요
---

`
댓글 수정 페이지는 부트스트랩에서 제공하는 모달 기능을 이용하여 만든다. 모달(modal)은 웹 페이지에서 새 창을 띄우는 팝업 창과 다르게 같은 웹 페이지 내부에서 상위 레이어를 띄우는 방식이다. 부트스트랩 페이지에서 Live demo modal(모달 시연)을 클릭하면 모달 창을 확인 가능하다.
`

<img width="860" height="975" alt="image" src="https://github.com/user-attachments/assets/4e44fa2d-8d87-4713-b6e4-5563228ba992" />

---
18.2 댓글 수정 뷰 페이지 만들기
---

_list.mustache 파일을 열고, {{nickname}} 다음 행에 <button> 태그를 넣는다. 그리고 부트스트랩에서 제공하는 모달 코드를 사용한다.

<img width="809" height="358" alt="image" src="https://github.com/user-attachments/assets/81bd192f-2126-4861-9cb7-b707ff099234" />

파랗게 드래그 한 부분을 복사하여 붙여넣기 해준다. 그 후에 용도에 알맞게 모달 트리거 부분 코드를 수정해준다.

<img width="492" height="188" alt="image" src="https://github.com/user-attachments/assets/43404723-7665-499d-b758-0f8bef152d0b" />

가독성을 위해서 버튼 태그의 class 속성을 수정해준다.

<img width="459" height="207" alt="image" src="https://github.com/user-attachments/assets/3f50dd51-a67c-4efa-bbad-f675e87468fa" />

```
그 후에 모달 부분에서 수정 사항들을 모두 수정해준다.
1. 모달의 id -> comment-edit-modal로 변경, data-bs-target 속성 값도 같이 바꿔준다. 이렇게되면 버튼을 클릭시 해당 모달이 뜬다.
2. 모달에 필요없는 속성인 aria-labelledby="exampleModalLabel" aria-hidden="true"속성을 삭제한다. 
3. 모달 제목을 변경한다. (Modal title -> 댓글 수정)
4. [Close]와 [Save changes] 버튼은 삭제한다.(modal-footer 영역)
```
<img width="383" height="39" alt="image" src="https://github.com/user-attachments/assets/fb894005-618a-4100-b82e-9aa45639681a" />

<img width="667" height="403" alt="image" src="https://github.com/user-attachments/assets/738a796e-ac13-4806-8458-f34a613b39dd" />

게시글에 들어간 후 댓글 수정 버튼을 누르면 모달 창이 뜨는걸 확인 가능하다.

<img width="850" height="464" alt="image" src="https://github.com/user-attachments/assets/5e95335a-e82a-40fb-b63c-74c6536574d0" />

---
18.3 수정 폼 삽입하기
---

<img width="864" height="485" alt="image" src="https://github.com/user-attachments/assets/68afed2d-a605-4127-af3a-f68be7e997a7" />

_new.mustache에서 form 부분을 복사한다.

<img width="728" height="382" alt="image" src="https://github.com/user-attachments/assets/c009991e-d9ff-4746-9587-cb7048c8d30c" />

그 후 _list.mustache의 modal-body내부에 복사한 form을 붙혀넣기 해준다.

<img width="955" height="447" alt="image" src="https://github.com/user-attachments/assets/05e51d45-d61b-40cf-ba0f-14d06776ec3d" />

```
<form 수정사항>
1. id 값에서 new를 전부 edit으로 수정(수정하는 기능이기 때문)
2. 히든 인풋의 머스태치 변수를 삭제한다.
3. <input> 구문의 value 속성은 필요가없다. id를 edit-comment-id(댓글의 id)로 수정하고, <input> 구문을 하나 더 만들고, id를 edit-comment-article-id(부모 게시글의 id)로 수정한다.
4. 전송 버튼의 id를 comment-update-btn(수정 버튼)으로 수정한다. 그리고 버튼 제목도 변경해준다.
```

이제 웹페이지에서 수정 버튼을 누르면 다음과 같은 모달 창이 뜬다.

<img width="862" height="613" alt="image" src="https://github.com/user-attachments/assets/ac7b7b7b-5bbd-416f-a7ba-3df6337e8af2" />

---
18.4 자바스크립트로 댓글 수정하기
---

댓글을 수정하려면 이전 댓글 데이터를 가져와야한다. 댓글 수정 버튼을 클릭했을 때 수정 폼에 이전 댓글 데이터가 전달 될 수 있게 한다.

```
1. data-bs-id 속성을 추가하고 현재 댓글의 {{id}}값을 저장한다.
2. data-bs-nickname 속성을 추가하고 현재 댓글의 {{nickname}}값을 저장한다.
3. data-bs-body 속성을 추가하고 현재 댓글의 {{body}}값을 저장한다.
4. data-bs-article-id 속성을 추가하고 현재 댓글의 {{articleId}}값을 저장한다.
```

<img width="588" height="210" alt="image" src="https://github.com/user-attachments/assets/bc2be153-20b2-4f9a-8e1f-393524a0d9aa" />

data- 로 시작하는 속성은 데이터 속성이라고 칭한다. 데이터 속성은 HTML 요소에 추가 정보를 저장하고 싶을 때 사용한다. 개수에 제한이 없으므로 하나의 요소에 여러 데이터 속성을 사용할 수 있다. data- 로 시작하고 그 다음에 자유롭게 붙이면 된다.

<img width="747" height="253" alt="image" src="https://github.com/user-attachments/assets/0e0f744d-0612-434f-9f15-2c63d7ad1785" />

코드 맨 아래에 스크립트 태그를 넣고 중괄호를 넣어서 영역을 잡아준다. 모달 이벤트 처리를 위해서는 먼저 모달을 선택해야한다. querySelector() 메서드로 모달을 선택하고 commentEditModal 변수에 저장해준다.

<img width="631" height="139" alt="image" src="https://github.com/user-attachments/assets/0fc58744-113f-46fb-82ba-b632045a3653" />

또한, 모달 이벤트를 감지할때 addEventListener()메서드를 사용하여 감지해준다.

<img width="590" height="79" alt="image" src="https://github.com/user-attachments/assets/557d8616-53c6-4c9a-804c-c270780932e4" />

function(event)는 모달이 열리는 이벤트를 매개변수로 받아 실행되는 함수이다. 이는 이벤트 핸들러라고 부른다.

```
show.bs.modal: 모달이 열리기 직전 발생하는 이벤트
function(event): 이벤트를 받아 처리하는 함수, 이벤트 핸들러
function(event)의 event: 발생된 이벤트 정보를 가리키는 매개변수, 여기서는 show.bs.modal을 칭함
```

개요는 다음과 같다.

<img width="732" height="425" alt="image" src="https://github.com/user-attachments/assets/58a912f9-29d8-4b62-863d-ef3fd55edf76" />

이 상태에서 수정 버튼을 누르면 기존 댓글에 대한 정보가 나타난다.

<img width="853" height="621" alt="image" src="https://github.com/user-attachments/assets/03a6af39-61f4-4d10-8756-20bac14545bb" />

---
18.5 자바스크립트로 REST API 호출하고 응답 처리하기
---

스크립트 부분에서 수정 완료 버튼을 선택 후 댓글 생성에서 했던 것 처럼 querySelector(#comment-update-btn)으로 선택한 후 commentUpdateBtn 변수로 가져온다.

<img width="711" height="291" alt="image" src="https://github.com/user-attachments/assets/a8ed5fb0-09e1-4244-9707-b1ee198d5f93" />

<img width="653" height="114" alt="image" src="https://github.com/user-attachments/assets/eccd710c-623c-4886-be4b-9d30d7815775" />

```
클릭 이벤트를 처리하기 위한 addEventListener 메서드를 활용한다. 17장에서 했던 것 처럼 객체를 변수로 선언하는 객체 리터럴 방식으로 만든다. 객체의 키는 id, nickname, body, articleId고, 각 키의 값을 querySelector()로 댓글 수정 폼의 각 요소를 선택한 후 value값을 가져온다. 그리고 나서 콘솔에 로그를 찍어서 객체가 잘 만들어졌는지 확인한다.
```

<img width="679" height="272" alt="image" src="https://github.com/user-attachments/assets/91681700-6b4c-4dd3-9e7b-20928b0b7549" />

그 후에 하단에 fetch()함수를 사용한다. 
```
1. 첫 번째 전달값: API 주소를 가지고 있는 url을 넘김
2. 두 번째 전달값: 요청 메서드, 헤더 정보, 전송 본문을 전달함, 헤더 정보에는 전송 본문 데이터의 타입이 JSON임을 명시하는 내용을 넣는다.
```

빌드 후 웹 페이지에 접속해서 점검해본다.

<img width="386" height="185" alt="image" src="https://github.com/user-attachments/assets/366f46c1-baad-40c1-b6cc-7789983ce27e" />

인텔리제이에서 update문이 실행되었으면 정상적으로 커밋된것이다. 또한 h2-console에서도 확인해보면 잘 바뀐걸 확인 가능하다.

<img width="266" height="33" alt="image" src="https://github.com/user-attachments/assets/060f4d84-a485-43b3-a036-4f89121eb489" />

이제 사용자 입장에서 수정이 잘 되었는지 확인 가능한 response 구문을 작성해보겠다. 17장과 마찬가지로 응답처리와 새로고침 기능을 추가해준다.

<img width="685" height="172" alt="image" src="https://github.com/user-attachments/assets/54bf8532-164b-4a03-9a2a-f3751c2b2553" />

<img width="860" height="597" alt="image" src="https://github.com/user-attachments/assets/10b12e0a-6657-4796-9f27-f76b1874bbcd" />

<img width="856" height="579" alt="image" src="https://github.com/user-attachments/assets/d46cfc88-9bd1-4504-8b57-bcb594748a69" />

댓글이 잘 수정되고 반영된걸 확인할 수 있다.

<img width="836" height="241" alt="image" src="https://github.com/user-attachments/assets/245b55f7-3f7d-4015-8ad0-f5ab10bd2240" />

---
확인 문제
---

```
1. 다음중 옳은것을 모두 고르세요
-> (1), (3), (4)

   (2)번 오답이유: show.bs.modal 이벤트는 모달이 보여지기 직전에 실행됨
   (5)번 오답이유: JSON.stringify()는 자바스크립트 객체를 JSON 문자열로 변환시키는 역할을 한다.
```

