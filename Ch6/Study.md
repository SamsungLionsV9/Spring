---
6.1 링크/리다이렉트
---
```
*link: 미리 정해놓은 요청을 간편히 전송하는 기능(클라이언트->서버)
*리다이렉트: 클라이언트가 보낸 요청을 마친 후 계속해서 처리할 다음 요청 주소를 재지시하는것.(리다이렉트를 지시받은 클라이언트는 지시받은 주소로 다시 요청을 보냄)
```

---
6.2 링크와 리다이렉트 실습
---
<img width="397" height="64" alt="image" src="https://github.com/user-attachments/assets/f95498f2-7244-4673-9512-4915f5dff336" />
`
<a href> 태그를 이용하면 해당 링크를 만들 수 있다.
`
<img width="698" height="360" alt="image" src="https://github.com/user-attachments/assets/ac7ba4bf-cfa3-4ed8-bc6e-5279494ec597" />

<img width="829" height="378" alt="image" src="https://github.com/user-attachments/assets/90d0f0ff-c94f-41d9-b994-a0811ed1d65c" />

```
첫 번째 사진의 링크를 클릭하면 새 글을 적을 수 있는 창으로 리다이렉트 해주는 걸 알 수있다.
다음과 같은 형식으로 작성이 가능하다.
return "redirect:URL_주소";
```
*게시글 마다 리다이렉트하는법
`
ArticleController.java(id에 따른 재요청 URL을 완성가능
`
<img width="351" height="25" alt="image" src="https://github.com/user-attachments/assets/ab89f2b7-b0e7-4c78-8189-153a8c974b3f" />
`
Article.java(롬복으로 Getter 어노테이션 추가->saved.getId()의 오류를 해결해줌)
`
<img width="257" height="110" alt="image" src="https://github.com/user-attachments/assets/f8a5f8a1-3b91-4534-887c-82150c597de8" />

결과
<img width="603" height="222" alt="image" src="https://github.com/user-attachments/assets/cccf0b48-2fd4-42c3-8a20-39e4874434e6" />
`
다음처럼 URL주소가 id번호를 갖는걸 확인할 수 있다.
`

---
상세페이지->목록페이지
---
```
1. ArticleController에 있는 show() 메서드를 찾는다.
2. 해당 메서드의 return문을 찾고 article/show로 돌아가게끔 해준다.
3. show.mustache의 table아래에 되돌아가는 링크를 추가한다.
```
<img width="285" height="33" alt="image" src="https://github.com/user-attachments/assets/47a0e0fc-bda4-4f2e-aac8-66e489963643" />

<img width="600" height="216" alt="image" src="https://github.com/user-attachments/assets/1e9faf61-2331-49f2-a085-0e118d48fc35" />

<img width="871" height="411" alt="image" src="https://github.com/user-attachments/assets/cf9cb8d8-f3c6-41be-b604-70ddabb25dfd" />

다음과 같은 되돌아가기 링크가 나타난다.


---
목록페이지->상세페이지
---
<img width="586" height="453" alt="image" src="https://github.com/user-attachments/assets/9a41128c-cf90-48aa-a970-efd1911b63ae" />
링크를 게시물 제목에다 걸어두어서 제목을 누르면 리다이렉트 되게 수정한다.
<img width="609" height="349" alt="image" src="https://github.com/user-attachments/assets/38ad4dd0-8736-4fbd-b38e-a2633d2f95cb" />
<img width="609" height="324" alt="image" src="https://github.com/user-attachments/assets/fecefb91-1b0e-4d39-b5d1-f3cc4dc840fa" />

```
이런식으로 게시물마다 리다이렉트 되게끔 해준다.
```

---
확인문제
---
(ㄱ)이란 특정 페이지로 이동하는 HTML 태그로, 클릭 시 href 속성에 적힌 URL주소로 요청을 보냅니다.
(ㄴ)이란 컨트롤러의 특정 메서드 수행을 종료한 후 계속해서 처리할 다음 요청 주소를 지시하는 것이다. 이를 통해 분리된 기능을 연속적인 하나의 흐름으로 연결 할 수 있다.

(ㄱ) a href
(ㄴ) 리다이렉트

