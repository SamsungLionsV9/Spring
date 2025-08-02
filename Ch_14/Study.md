---
14.1 댓글 기능
---

```
게시글에 여러개의 댓글이 달리는데 이는 1:n 일대다 관계이다.
반대로 댓글 입장에선 n:1 다대일 관계이다.

DB에는 어떤식으로 저장되는가?

id같이 자기 자신을 대표하는 속성은 대표키이다. comment 테이블에는 연관 대상을 가리키는 article_id가 하나 더 있는데, article_id와 같이 연관 대상을 가리키는 속성을 외래키 라고 부른다. 외래키를 따라가면 해당 댓글이 어떤 게시글에 달린것인지 알 수 있다. 외래키는 항상 연관된 테이블의 대표키를 가리킨다.

JPA로 DB에 명령을 내리는데, 개념을 다시 복습해보자면, 엔티티는 DB 데이터를 담는 자바 객체고, 테이블이 엔티티를 기반으로 생성된다.
레포지토리가 엔티티를 관리해주는 인터페이스이며, 데이터 CRUD등의 기능을 제공한다.
```

---
14.2 댓글 엔티티 만들기
---

먼저 엔티티를 만들떄 필요한 어노테이션과 각각의 역할은 다음과 같다.
<img width="511" height="248" alt="image" src="https://github.com/user-attachments/assets/95507eab-3769-4630-9f0c-c7e07571831d" />

그리고 필요한 컬럼들을 지정해준다. 각각의 역할은 다음과 같다.

<img width="596" height="207" alt="image" src="https://github.com/user-attachments/assets/2509ad8f-6d09-4e49-8c60-590838c8cea6" />


```
@ManyToOne 어노테이션 => 엔티티와 엔티티를 다대일 관계로 지정해준다. 
@JoinCollum(name="외래키명") => 외래키 매핑을 위해 사용하는 어노테이션이다.
```

최종 정리하면 Comment.java는 다음과 같다.

<img width="859" height="640" alt="image" src="https://github.com/user-attachments/assets/33fe3ae6-7d17-47c8-8405-69f3855a5e77" />

그 후에 매핑이 잘 되었는지 확인하기 위해서 FirstProjectApplication을 실행한다.

<img width="522" height="191" alt="image" src="https://github.com/user-attachments/assets/93e22234-7464-421a-87d5-278fcba8c81d" />

콘솔을 보면 다음과 같이 테이블이 잘 생성되었음을 확인 가능하다.

<img width="426" height="182" alt="image" src="https://github.com/user-attachments/assets/b1c958b9-5574-47bf-8a99-5f237f645ea5" />

h2-console로 들어가면 테이블이 정확히 생성되어있음을 확인 가능하다.

<img width="521" height="438" alt="image" src="https://github.com/user-attachments/assets/14adf595-686f-46cc-a3fb-8f05b1437635" />

---
더미 데이터 추가
---

```
data.sql에 다음과 같이 추가해준다.

INSERT INTO article(title, content) VALUES ('가가가가', '1111');
INSERT INTO article(title, content) VALUES ('나나나나', '2222');
INSERT INTO article(title, content) VALUES ( '다다다', '3333');

INSERT INTO article(title, content) VALUES('당신의 인생 영화는?', '댓글');
INSERT INTO article(title, content) VALUES('당신의 소울 푸드는?', '댓글 ㄱ');
INSERT INTO article(title, content) VALUES('당신의 취미는?', '댓글 ㄱㄱ');

INSERT INTO comment(article_id, nickname, body) VALUES (4, 'A', '태극기휘날리며');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'B', '비긴어게인');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'C', '올드보이');

INSERT INTO comment(article_id, nickname, body) VALUES (5, 'D', '치킨');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'E', '피자');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'F', '초밥');

INSERT INTO comment(article_id, nickname, body) VALUES (6, 'G', '메이플스토리');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'F', '배틀그라운드');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'K', '오버워치');
```

<img width="851" height="577" alt="스크린샷 2025-08-02 17 47 22" src="https://github.com/user-attachments/assets/09ea6fcc-aa16-4cb9-a8e9-308b44c74d46" />

h2-console에도 잘 반영되어있음을 알 수 있다.

<img width="638" height="663" alt="image" src="https://github.com/user-attachments/assets/d71e718b-8d9d-4b6b-98dc-d8adc5177155" />

