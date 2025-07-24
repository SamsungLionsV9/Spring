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

---
8.4 SQL문으로 직접 삭제하기
---

`
(형식) DELETE [FROM] 테이블명 WHERE 조건;
`

<img width="545" height="510" alt="image" src="https://github.com/user-attachments/assets/91ba575e-6418-4f20-abe0-07d4199717ef" />

`
여기서 id가 3인 데이터를 삭제해보겠다.
`

<img width="558" height="443" alt="image" src="https://github.com/user-attachments/assets/3463fd28-5890-4a52-bd33-f810dfec5e83" />

<img width="598" height="489" alt="image" src="https://github.com/user-attachments/assets/b3038d16-3f5b-40ce-8db2-9f80e1c14ba4" />


---
확인문제
---

*다음 중 옳지 않은 것은?
1. HTTP는 POST, GET, PATCH(PUT), DELETE등의 다양한 메서드를 제공한다.
2. 데이터 삭제 요청은 반드시 HTTP의 DELETE 메서드로만 할 수 있다.
3. @PathVariable은 클라이언트의 요청 중 특정 URL값을 매개변수로 가져온다.
4. CrudRepository는 데이터 삭제를 위해 delete()메서드를 제공한다.
5. RedirectAttributes 객체를 활용하면 리다이렉트 페이지에서 사용할 일회성 데이터를 등록할 수 있다.

-> (2), SQL문으로 직접 삭제도 가능하다.


