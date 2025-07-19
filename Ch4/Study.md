---
4.1 롬복
---

`
롬복: 코드를 간소화 해주는 라이브러리, 롬복을 사용시 필수 코드를 간편하게 작성 할 수 있다.
로깅 기능은 println()문을 개선할 수 있음, 로깅이란 프로그램의 수행 과정을 기록으로 남기는것을 말한다.
`
---
4.2 롬복으로 리팩터링하기
---
1. 롬복 설치하는법
`
build.gradle에서 lombok 의존성을 추가
<img width="359" height="46" alt="image" src="https://github.com/user-attachments/assets/5838db9b-d84c-45d8-bc2a-653b16590813" />
`
2. DTO 리팩터링
`
ArticleForm.java를 간소화 해보겠다.
<img width="386" height="356" alt="image" src="https://github.com/user-attachments/assets/d788e1b0-1d3e-4cda-8a87-934492fc4d3f" />

`
3. 엔티티 리팩터링
`
<img width="395" height="461" alt="image" src="https://github.com/user-attachments/assets/2aa47adb-d6a0-4326-a752-6dc1ac091b25" />
`
4. 컨트롤러에 로그 남기는법
`
ArticleController.java에서 println()문이 아닌 로깅기능을 사용한다.
@Slf4j(로깅 기능 어노테이션)을 추가해준다.
<img width="266" height="157" alt="image" src="https://github.com/user-attachments/assets/c81582eb-29e6-468b-8a0a-3e096e87160b" />

그 후 하단에 있는 println()문을 주석처리하고, log.info문을 사용해준다.
<img width="379" height="91" alt="image" src="https://github.com/user-attachments/assets/0dbff98c-30fa-4989-af4f-78239aaa274d" />
<img width="377" height="129" alt="image" src="https://github.com/user-attachments/assets/7119b410-3383-4e45-8511-33c79b8698dd" />
`
5. 로깅 테스트
`
<img width="731" height="239" alt="image" src="https://github.com/user-attachments/assets/46385300-4c3a-43e7-8338-ff456b789c37" />

<img width="1130" height="25" alt="image" src="https://github.com/user-attachments/assets/0d0c4b6c-a9e0-4201-8088-a9f67c16f261" />
`

---
확인문제
---
1. (ㄱ) 롬복을 설치하기 위해 값 변경이 필요한 파일
2. (ㄴ) 모든 필드를 매개변수로 하는 생성자를 만드는 롬복 어노테이션
3. (ㄷ) toString()메서드를 대체하는 롬복 어노테이션
4. (ㄹ) 로깅 기능을 사용하기 위해 필요한 롬복 어노테이션
5. (ㅁ) 출력하기 원하는 데이터를 로그로 찍기 위해 사용하는 구문

(ㄱ) build.gradle
(ㄴ) @AllArgsConstructor
(ㄷ) @ToString
(ㄹ) @Slf4j
(ㅁ) log.info()







