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
2. 모달에 필요없는 속성인 aria-labelledby="exampleModalLabel" aria-hidden="true"을 삭제한다. 
3.  
4.
```
