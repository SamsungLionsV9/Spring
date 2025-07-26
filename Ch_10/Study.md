---
10.1 Rest API & JSON
---

`
Rest API: 서버의 자원을 클라이언트에 구애받지 않고 사용할 수 있게 하는 설계 방식이다. HTTP 요청에 대한 응답으로 서버의 자원을 반환합니다.
`

`
서버는 클라이언트의 요청에 대한 응답으로 화면이 아닌 데이터를 전송하고, 이때 사용하는 응답 데이터는 JSON이다.
`

`
API: 애플리케이션을 간편히 사용할 수 있게 하는, 미리 정해진 일종의 약속이다.
`

`
JSON: JSON 데이터는 키(key)와 값(value)로 구성된 정렬되지 않은 속성의 집합을 이야기하고, 항상 문자열인 경우에 ""로 감싸야한다. 
`

---
10.2 Rest API 동작
---
```
https://jsonplaceholder.typicode.com에서 가짜 API로 무료 테스트를 진행 가능하다.
사이트에서 Try it 부분에 HTTP 요청 코드가 작성되어있다. Run Script 버튼을 클릭하면 데이터가 확인 가능하다.
```

<img width="893" height="589" alt="image" src="https://github.com/user-attachments/assets/9122878a-2ff0-42ab-855a-852e9647716b" />

```
Rest API는 모든 HTTP 메서드를 지원하다. 하단에 있는 guide를 누르면 단일 데이터를 조회하는 예시가 나타난다.
```

<img width="566" height="424" alt="image" src="https://github.com/user-attachments/assets/26a992fb-8229-482f-b04a-586f52671870" />

<img width="890" height="471" alt="image" src="https://github.com/user-attachments/assets/c413f8d5-4f61-4390-b7e5-1d5adf515a37" />

<img width="911" height="499" alt="image" src="https://github.com/user-attachments/assets/5735b893-e34d-4f86-82de-b76e8e79a776" />

<img width="901" height="743" alt="image" src="https://github.com/user-attachments/assets/ee829fa9-5d61-4ea0-a95b-fcd5fc7d11d0" />

<img width="899" height="730" alt="image" src="https://github.com/user-attachments/assets/11f7fa7d-3c86-4d95-b95d-832dec806cc8" />

<img width="900" height="705" alt="image" src="https://github.com/user-attachments/assets/df5aef0b-8425-4b6b-8d3b-01012abf38ff" />

<img width="904" height="870" alt="image" src="https://github.com/user-attachments/assets/c3a43195-9e53-452b-ba8e-d047e2a10b33" />

---
GET 요청받고 응답받기
---

<img width="529" height="428" alt="image" src="https://github.com/user-attachments/assets/bb796460-33f5-4174-af99-f437685486df" />

<img width="788" height="616" alt="image" src="https://github.com/user-attachments/assets/c50abc99-2c93-43be-a444-547a75e5e63c" />

`
응답이 200으로 왔다는건 요청이 잘 처리되었다는 의미이다. 특정 게시물을 보려면 post/1 이런식으로 보면되고, 100번까지 조회가 가능하다.
`
<img width="838" height="644" alt="image" src="https://github.com/user-attachments/assets/ff83d8ce-5003-4d31-8505-0cfb3565160a" />

`
100을 넘어간 101부터는 404오류가 뜬다, 요청한 페이지를 찾을 수 없다는 뜻이다.
`

<img width="824" height="661" alt="image" src="https://github.com/user-attachments/assets/93db3d09-dea6-4db7-9b0f-9ecea8287d1b" />


```
HTTP 상태 코드
1-- : 요청이 수신되어 처리중
2-- : 요청이 정상처리됨
3-- : 요청을 완료하려면 추가 행동이 필요
4-- : 클라이언트의 요청이 잘못되어 서버가 요청 수행 불가
5-- : 서버 내부에 에러가 발생하여 요청 수행 불가

HTTP를 클릭하면 응답 메세지에 내용이 실려서 출력된다.

여기에는 시작라인, 헤더, 빈 라인, 본문 으로 구성된 메세지가 출력된다. 에러가 난 경우(404 에러)에는 본문이 비어서 나타난다.
```

---
POST 요청하고 응답받기
---

<img width="856" height="863" alt="image" src="https://github.com/user-attachments/assets/c294b8d9-8b63-421a-a2fa-b9de186c9bc7" />

<img width="821" height="700" alt="image" src="https://github.com/user-attachments/assets/e9c378cb-b709-48a0-9d2e-787bd733f7c8" />

`
JSON 문법을 잘못되게 사용한 경우 500 에러가 난다.
`

<img width="828" height="665" alt="image" src="https://github.com/user-attachments/assets/4eb3f263-de28-4614-ae0b-60ec5257c9c5" />

---
PATCH 요청하고 응답받기
---


<img width="843" height="643" alt="image" src="https://github.com/user-attachments/assets/55ef4da8-d26e-4f29-b9e4-5a7083639f39" />


<img width="816" height="426" alt="image" src="https://github.com/user-attachments/assets/d8d76d4c-9190-42da-a368-ab08d0e77441" />

`
내용이 수정된것을 확인 가능
`

---
DELETE 요청하고 응답받기
---


<img width="836" height="636" alt="image" src="https://github.com/user-attachments/assets/0e532d05-74b7-422c-afd3-de08c31cdf5d" />

`
본문이 비어있으므로 데이터가 잘 삭제된걸 확인 할 수 있다.
`

---
확인 문제
---

(ㄱ) : 클라이언트의 요청이 잘못됨
(ㄴ) : 요청이 정상적으로 처리됨
(ㄷ) : 서버 내부에 오류가 발생
(ㄹ) : 요청 완료하라면 추가 행동 필요
(ㅁ) : 요청이 수신되어 처리중

(ㄱ) : 4--
(ㄴ) : 2--
(ㄷ) : 5--
(ㄹ) : 3--
(ㅁ): 1--
