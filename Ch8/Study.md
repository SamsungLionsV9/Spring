---
8.1 데이터 삭제 과정
---
RedirectAttritubes() 객체의 addFlashAttribute()라는 메서드는 리디렉트된 페이지에서 사용할 일회성 데이터를 등록 할 수 있다.

```
데이터 삭제 과정
show(상세페이지) -> 컨트롤러에 삭제 요청 -> 레포지토리가 테이블에서 삭제할 데이터 삭제 -> 컨트롤러가 클라이언트의 목록페이지로 삭제가 반영된 목록 페이지를 보여줌
```

---
8.2 데이터 삭제 실습
---

```

*버튼 추가(btn-danger는 빨간색이다.)
<img width="608" height="122" alt="image" src="https://github.com/user-attachments/assets/93620cdb-aa9d-4cac-ab96-0e54f797b89a" />

<img width="408" height="294" alt="image" src="https://github.com/user-attachments/assets/e9d2bf9d-19c3-4afc-bdcb-982c6483f76a" />

```

*Delete controller추가(ArticleController 하단에 delete()메서드를 추가한다.
<img width="577" height="274" alt="image" src="https://github.com/user-attachments/assets/88f73e46-d15a-43dd-ba13-583c7eae9c3a" />

<img width="636" height="246" alt="image" src="https://github.com/user-attachments/assets/63e73580-1829-424e-9ba9-750d1f283961" />

<img width="692" height="309" alt="image" src="https://github.com/user-attachments/assets/e196dcef-f38a-454d-846d-f1413307559c" />

---
8.3 삭제 완료 메세지
---

`
RedirectAttributes 객체로 리디렉트 페이지에서 사용할 데이터를 남길 수 있다고 했다. 컨트롤러에서는 delete() 메서드의 매개변수로 받아와야한다. 엔티티 삭제하는 if문에서 addFlashAttribute를 활용하면 완료 메세지를 남길 수 있다.
`

<img width="654" height="257" alt="image" src="https://github.com/user-attachments/assets/7ab45ec5-4a6b-4ca7-a95d-6beb96511803" />

---
팝업 형태의 삭제완료 메세지
---
<img width="779" height="135" alt="image" src="https://github.com/user-attachments/assets/416c297f-02ac-40c6-aed9-00c40c8d34c2" />

<img width="875" height="498" alt="image" src="https://github.com/user-attachments/assets/1e177b70-27d0-44eb-a0c6-3d0e9ce01da7" />


