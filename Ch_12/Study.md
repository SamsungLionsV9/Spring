---
12.1 서비스&트랜잭션
---

```
서비스: 컨트롤러와 리파지터리 사이에 위치하는 계층, 서버의 핵심 기능(비즈니스 로직)을 처리하는 순서를 총괄함
트랜잭션: 서비스 업무 처리의 단위, 모두 성공해야 하는 일련의 과정을 의미한다.
롤백: 트랜잭션이 실패로 돌아갈 경우 진행 초기단계로 돌리는 것을 의미한다.
```

---
12.2 서비스 계층 만들기
---

```
1. ArticleApiController 전체 주석 처리
2. 객체 주입된 리파지터리를 서비스화
```

<img width="553" height="237" alt="image" src="https://github.com/user-attachments/assets/f418514a-1a5b-4b9f-aeea-a14eb99e9fbb" />

```
3. ArticleService 패키지 생성 후 ArticleService(자바 클래스)를 service 패키지에서 생성
4. @Service 어노테이션을 붙히기, 자동적으로 스프링부트에 서비스 객체를 생성한다.
5. @Autowired를 통해서 ArticleService 클래스를 REST 컨트롤러에서 연결해서 가져온다.
6. ArticleService에서 레포지토리와 협업을 위해서 게시글 레포지토리 객체를 주입하고, 앞서 주석처리한걸 하나씩 풀면서 리팩터링한다.
```

<img width="568" height="418" alt="image" src="https://github.com/user-attachments/assets/65f77a4b-b92f-4f15-89db-ad3daf8d779f" />

<img width="686" height="297" alt="image" src="https://github.com/user-attachments/assets/9281275d-9336-4323-9eae-5358ac4e9e35" />

---
12.3 게시글 조회 요청 개선
---

```
컨트롤러에서 GET 메서드 부분을 전부 주석 해제하고, 다음과 같이 컨트롤러를 수정한다.
```

<img width="423" height="281" alt="image" src="https://github.com/user-attachments/assets/0bb3ca59-b6ed-425c-8740-2be862e11fda" />

```
그리고 index라는 메서드를 ArticleService에 생성한다.
```

<img width="422" height="97" alt="image" src="https://github.com/user-attachments/assets/c8a8b088-5e4b-485d-a014-2734c6e8c5bc" />

```
그리고 ArticleService에 return articleRepository.findAll();를 넣고 DB에서 조회한 결과를 반환하게 한다.
```

<img width="623" height="226" alt="image" src="https://github.com/user-attachments/assets/77da00f7-54c9-444a-9d7a-522d404e9c33" />

```
이 후에 서버 실행 후 API test를 하면 다음과 같이 정상적으로 데이터가 조회되는걸 확인 가능하다.
```

<img width="864" height="820" alt="image" src="https://github.com/user-attachments/assets/66ec58f6-18e6-4d24-b61b-da23f9f2ea77" />


