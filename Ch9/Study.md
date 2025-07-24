---
9.1 JPA 로깅 설정
---

```
로깅: 시스템이 작동할 때 당시의 상태와 작동 정보를 기록하는것을 의미한다.
로깅 설정은 application.properties 파일에서 가능하다.
```

<img width="302" height="29" alt="image" src="https://github.com/user-attachments/assets/00650f23-6572-41c0-8d81-bf89d678484b" />

```
<로깅 레벨 7단계>
1. TRACE: DEBUG 레벨보다 더 상세한 정보
2. DEBUG: 응용 프로그램을 디버깅하는데 필요한 세부 정보
3. INFO: 응용 프로그램의 순조로운 진행 정보
4. WARN: 잠재적으로 유해한 상황 정보
5. ERROR: 응용 프로그램이 수행할 수 있는 정도의 오류 정보
6. FATAL: 응용 프로그램이 중단될만한 심각한 오류 정보
7. OFF: 로깅 기능 해제

서버를 실행하면 아래 사진과 같이 SQL 쿼리가 로그로 찍힌다. org.hibernate.SQL 이라는 문구가 뜨면 된다.
```

<img width="1226" height="123" alt="image" src="https://github.com/user-attachments/assets/4bed957c-2cbd-4dc5-bf84-c04564b40fb0" />

```
여기서 쿼리 줄바꿈을 통해 가독성을 향상 시킬 수 있다. 쿼리 줄바꿈은 application.properties에 다음과 같은 코드를 추가해주면 된다.
```
<img width="416" height="33" alt="image" src="https://github.com/user-attachments/assets/11ce0718-bb99-415b-822a-cc69ced4a038" />

<img width="659" height="198" alt="image" src="https://github.com/user-attachments/assets/710f7684-01be-470f-922d-d0a6b3d87823" />

```
매개변수 값을 볼 수 있게 해주는 설정을 추가하면 SQL 쿼리문에서 나타나는 ?값을 볼수있게 해준다.
```

<img width="521" height="19" alt="image" src="https://github.com/user-attachments/assets/61d37578-86f2-4c13-85b6-800b64fab3ae" />

```
H2 DB에서 JDBC URL을 항상 새로 검색해서 입력했지만 고정시키는 방법이있다. 유니크 URL을 FALSE로 지정하고, 어떤 값을 고정 URL로 할지 적어줘야한다.
```

<img width="365" height="42" alt="image" src="https://github.com/user-attachments/assets/71272239-b712-41d5-8770-64f1d2341492" />

```
URL 설정이 testdb로 바뀐걸 확인할 수 있다.
```

<img width="388" height="215" alt="image" src="https://github.com/user-attachments/assets/14f6964d-b794-468e-81a9-c6d8ec48bc63" />

<img width="609" height="471" alt="image" src="https://github.com/user-attachments/assets/f1058325-c631-4b40-b662-78fda550774d" />

<img width="858" height="521" alt="image" src="https://github.com/user-attachments/assets/8e6460da-12cf-4084-a6c3-623d1fbe95b2" />

---
9.2 SQL 쿼리 로그 확인하기
---
1. INSERT문
```
기존 실습에서 data.sql파일에 더미 데이터를 넣어놨었는데, DB에 새로운 값을 넣을때 id값이 중복되면 안되므로 기본키(Primary key)를
지정해주어야 한다. Article.java 파일 내에서 DB가 id를 자동으로 생성하게 해주는 코드를 추가해준다.
@GeneratedValue 어노테이션에서 (strategy = GenerationType.IDENTITY)를 추가해주면, DB가 데이터를 생성할 때마다 id에 알아서 값을 넣어준다.
```

<img width="417" height="24" alt="image" src="https://github.com/user-attachments/assets/d1dd93b0-6f1f-46be-bed0-d289070587da" />

```
위에서 어노테이션에 옵션을 추가해주었으므로 SQL문에서 id를 삭제해주면 된다.
```

<img width="791" height="148" alt="image" src="https://github.com/user-attachments/assets/57c7da94-1356-4a5f-8119-6d2620b4c653" />

<img width="586" height="214" alt="image" src="https://github.com/user-attachments/assets/341903e1-619a-4752-b45a-2172dac01de8" />

```
이렇게하면 id값이 겹쳐서 무결성이 위배되는 경우를 해결할 수 있다.
```

2. SELECT문

```
특정 데이터를 조회할 때 사용한다. 예시로 실습에서 아까 만든 id=4의 데이터를 조회해보면, 로그가 아래처럼 남는다.
WHERE절이 추가되었는데, WHERE절은 id가 ?인 데이터를 가져오라고 되어있는데, id가 4인 데이터를 조회하라는 쿼리가 수행된 것이다.
```

<img width="896" height="231" alt="image" src="https://github.com/user-attachments/assets/8278b880-2d69-4f2c-b723-bb16a44caa4e" />


3. UPDATE문
`
edit버튼을 눌러서 데이터를 수정하면 UPDATE 쿼리가 수행될 것이다.
`
<img width="822" height="398" alt="image" src="https://github.com/user-attachments/assets/838ebdad-c033-4af6-9ad7-ec51665832da" />

<img width="901" height="402" alt="image" src="https://github.com/user-attachments/assets/80880193-6dc6-408f-86ae-8f28ad459eff" />

4. DELETE문
`
DELETE 버튼을 눌러서 DELETE 쿼리를 수행할 수 있다. 이 쿼리는 article 테이블에서 id=4인 데이터를 삭제한다.
`

<img width="861" height="412" alt="image" src="https://github.com/user-attachments/assets/6c8ab378-a24c-4062-8d84-efe2b3d2732c" />

<img width="1012" height="512" alt="image" src="https://github.com/user-attachments/assets/6639bc1e-3c1e-425a-ad87-2aa12bfdef3a" />

---
9.3 기본 SQL쿼리 작성하기
---
```
테이블 만들기(인텔리제이 실행창에서 CREATE 검색 후 테이블이 생성된걸 확인가능함)
먼저 h2-console에서 테이블을 생성해주면 된다.

기본 CREATE TABLE문의 형식은 이렇다.
  CREATE TABLE 테이블명 (
    속성1 자료형,
    속성2 자료형,
    PRIMARY KEY(기본키)
  );

이 형식대로 coffee테이블이 생성된걸 확인 할 수 있다.
```

<img width="430" height="343" alt="image" src="https://github.com/user-attachments/assets/a1e33799-14dc-4b8a-8d4e-faa2fa51131d" />

<img width="366" height="324" alt="image" src="https://github.com/user-attachments/assets/b15ac78d-56a3-4be4-9ff1-b6884a68a25a" />

---
9.3.1 데이터 생성 및 조회
---

<img width="448" height="355" alt="image" src="https://github.com/user-attachments/assets/96a81b56-01bc-4228-967f-68669765bea6" />

<img width="350" height="374" alt="image" src="https://github.com/user-attachments/assets/41795913-4ebd-4a68-8b85-47631a1c66b6" />

---
9.3.2 데이터 수정하기
---
```
id = 1인 아메리카노의 가격을 2500원으로 인하하려고 한다.
이럴때 SQL문으로 값을 수정해주면된다.
```

<img width="240" height="348" alt="image" src="https://github.com/user-attachments/assets/67bbb886-5403-47ae-bfb3-2da9a0b5f249" />

<img width="269" height="382" alt="image" src="https://github.com/user-attachments/assets/9cefeec3-8027-4619-93b6-6c3a98754885" />

---
9.3.3 데이터 삭제
---
```
카페모카 메뉴가 단종되어서 데이터베이스에서 삭제하려고 할떄를 가정하고 쿼리문으로 데이터를 삭제했다.
성공적으로 삭제가 반영된걸 확인 할 수 있다.
```

<img width="347" height="334" alt="image" src="https://github.com/user-attachments/assets/2ed158b8-098c-4a5e-b75b-0050fd230b8f" />

<img width="292" height="340" alt="image" src="https://github.com/user-attachments/assets/6d469f3b-af6a-4d08-8b7b-64faaf34824e" />

---
확인문제
---

coffee 테이블에서 가격이 4600원인 커피를 찾으려고 한다. 이를 위한 쿼리문은?
  SELECT *
  FROM
    coffee
  WHERE
    price = 4600;
