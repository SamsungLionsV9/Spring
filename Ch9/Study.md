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
==================
2. SELECT문
```
특정 데이터를 조회할 때 사용한다. 예시로 실습에서 아까 만든 id=4의 데이터를 조회해보면, 로그가 아래처럼 남는다.
WHERE절이 추가되었는데, WHERE절은 id가 ?인 데이터를 가져오라고 되어있는데, id가 4인 데이터를 조회하라는 쿼리가 수행된 것이다.
```

<img width="896" height="231" alt="image" src="https://github.com/user-attachments/assets/8278b880-2d69-4f2c-b723-bb16a44caa4e" />

====================
3. UPDATE문

