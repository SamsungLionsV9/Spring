---
16.1 댓글 보기의 개요
---

```
보통 게시판의 특정 게시글을 클릭하면 상세 페이지가 뜨면서 그 하단에 댓글이 보인다.
기존 댓글을 보여주는 list와, 새 댓글을 입력하는 new가 있음
두 영역은 별도의 뷰 페이지를 만들어서 상세 페이지 아래에 삽입하는 형태로 구현한다.
```

---
16.2 댓글 뷰 페이지 삽입하기
---

<img width="849" height="484" alt="image" src="https://github.com/user-attachments/assets/2741f9ed-9cc3-4885-8273-dbc1d29de357" />

```
프로젝트 탐색기의 controller 패키지에 있는 ArticleController를 열면, 이 컨트롤러가 상세 페이지를 보여 달라는 요청을 받아서 처리한다. 여기에서 show() 메서드가 /articles/{id}로 접속했을때 보여주는 페이지를 반환하고 있다. 반환하는 뷰 페이지는 show.mustache인걸 확인 가능하다.
```

<img width="671" height="225" alt="image" src="https://github.com/user-attachments/assets/8b669f9b-4969-49b7-b0b4-262841c17bcf" />

show 페이지에 댓글은 페이지 하단이므로 footer 바로 위에 {{>comments/_comments}}를 추가해준다.

<img width="608" height="141" alt="image" src="https://github.com/user-attachments/assets/40bd8ad5-c2b8-4676-91bd-cc15a49d5c17" />

그 후에 _comments.mustache 파일을 만든다. 

<img width="847" height="520" alt="image" src="https://github.com/user-attachments/assets/4c6fa865-4d83-4060-96fb-17cb02a8b3d9" />

그리고 댓글을 볼 수 있게 _comments.mustache에 코드를 작성하겠다.

<img width="417" height="212" alt="image" src="https://github.com/user-attachments/assets/0f4ee8cc-dff9-48ef-8c08-0ff937f722f0" />

그리고 comments 디렉터리에 _list와 _new 머스태치 파일 두개를 만들어준다.

<img width="507" height="309" alt="image" src="https://github.com/user-attachments/assets/e01cc472-86ec-4b3c-9157-289c9a909414" />

```
_list파일에는 부트스트랩의 카드 요소를 사용하였다, 또한 여기서는 뷰 페이지에서 사용하는 commentDtos를 모델에 등록해야한다.
MVC패턴에 따라서 화면(view), 컨트롤러(controller)가 사용자가 볼 화면을 반환한다. 이때 화면에 필요한 데이터는 Model에 등록한다.
```

<img width="734" height="416" alt="image" src="https://github.com/user-attachments/assets/7646246d-b174-4b6e-82d9-75aec206fca8" />

그 후에 commentService를 객체 주입해준다. 이러면 이 컨트롤러에서 commentService를 사용가능하다. (@Autowired 사용)

<img width="390" height="85" alt="image" src="https://github.com/user-attachments/assets/d50ba708-3b51-4af8-80ee-e38decaa072e" />

<img width="629" height="24" alt="image" src="https://github.com/user-attachments/assets/53451e01-d23a-4db2-9fdf-52cadcc3fdf2" />

받아온 댓글 목록(commentDtos)을 모델에 등록하기 위해서 다음 코드를 작성한다.

