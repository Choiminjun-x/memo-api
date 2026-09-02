# 1주차 개념 정리

---

## Spring / Spring Boot 어원

**Spring** — 봄(계절). 2003년 오픈소스화. EJB 기반 J2EE 개발이 무겁고 고통스럽던 시기를 "겨울"에 비유하고, 거기서 벗어나는 새 시작이라는 뜻. 로고가 초록 잎사귀인 이유.

- 정체성 = 가벼움. 프레임워크 인터페이스를 상속하지 않은 평범한 자바 객체(POJO)를 컨테이너가 조립해준다.

**Boot** — bootstrap의 줄임. "스스로 일어선다", 컴퓨터 부팅과 같은 어원.

- 이전: WAR로 말아서 외부에 설치된 톰캣에 배포 (톰캣이 주인, 앱이 손님)
- 이후: 톰캣을 앱 안에 내장 → `main()` 실행만으로 스스로 서버가 뜬다

## 어노테이션

- 스프링 컨테이너가 시작하면서 클래스들을 훑고, 표시 발견 → 빈 생성
- Retention → 수명 (SOURCE, CLASS, RUNTIME)
- reflection → 실행 중에 어노테이션을 읽는 기능, 자바가 자기 자신을 들여다보는 것

## Jackson

- 라이브러리
- `spring-boot-starter-web`에 딸려 들어와 있음
- `@RequestBody` 어노테이션을 읽어두고, 요청이 오면 Jackson을 사용해서 JSON → record

## 요청당 스레드

- 서버는 기본이 멀티스레드고, "메인 스레드"라는 개념이 없다. 이 반전이 서버 개발에서 제일 먼저 적응해야 하는 부분
- main 스레드의 역할은 `[main] Started MemoApiApplication in 0.671 seconds` 여기까지
- 그다음 요청부터 하나당 하나의 스레드가 담당, "요청당 스레드(thread per request)" 모델

## 동시성 자료구조

### AtomicLong

- 증가와 읽기가 한 덩어리. 연산이 쪼개지지 않는 걸 보장한다.
- 같은 계열로 `AtomicInteger`, `AtomicBoolean`, `AtomicReference`

### ConcurrentHashMap

- `Map` 인터페이스의 구현체 중 동시 접근에 안전한 것.
- null key, null value 금지 → 동시성 상황에서 "값이 null"과 "키가 없음"을 구분할 수 없어서
- 순서 보장 없음 → 정렬이 필요하면 꺼낸 뒤에 `sorted()`로 처리

## application.yaml/yml

- Spring Boot의 설정 창구. 코드를 안 고치고 동작을 바꾸는 곳.
- 기본값과 다르게 하고 싶은 것만 적는 파일

---

# Java 기초

## JVM / JRE / JDK

**JVM**

- 바이트코드를 실행하는 프로그램
- `Memo.java` ──javac──→ `Memo.class` ──JVM──→ 실행

**JRE** — JVM + 기본 라이브러리 (실행만)

**JDK** — JRE + 컴파일러(javac) 등 개발 도구

## 세 종류의 변환

| | 무엇 → 무엇 | 누가 |
|---|---|---|
| 컴파일 | `.java` → `.class` | javac |
| 패키징 | `.class` → `.jar` | Gradle |
| JIT 컴파일 | 바이트코드 → 기계어 | JVM |

## 빌드 결과물의 정체

- **javac** — 빌드 도구. JVM 위에서 돌지만, 결과물엔 안 들어감
- **.class** — 바이트코드. CPU가 못 읽음
- **.jar** — `.class`들의 zip. 여전히 CPU가 못 읽음
- **JVM** — 실행 시점에 등장. 기계마다 다름. jar에 포함 안 됨

## .jar

- `./gradlew build` → `.jar` 생성
- 실행에 필요한 것이 다 모인 상태
- 내 코드 + 톰캣 + 스프링 + 설정 파일이 한 덩어리로 묶인 것

---

# 컴퓨터 기초

## 플랫폼 워드 크기

CPU의 레지스터 크기, 연산 한 번에 처리하는 데이터 덩어리의 크기

- 32비트 CPU → 레지스터 32비트 → 워드 4바이트
- 64비트 CPU → 레지스터 64비트 → 워드 8바이트

---

# 개발 도구

## Gradle — "빌드 도구"

- 의존성 관리 — 라이브러리를 인터넷에서 받아옴
- 빌드 — 컴파일하고 실행 가능한 형태로 묶음
- 태스크 실행 — 테스트, 실행, 정리 같은 작업

### build.gradle.kts

- 핵심 파일
- 무엇을 쓰고 어떻게 빌드할지 적는 곳
- `.kts` → Kotlin Script
- 설정 파일이 아니라 실행되는 Kotlin 코드

### settings.gradle.kts

- 어떤 프로젝트들이 이 빌드에 포함되는가를 정하는 파일

### gradlew

- Gradle Wrapper 실행 스크립트(macOS/Linux용), 셸 스크립트
- `gradle-wrapper.properties`에서 버전 확인
- 해당 버전 없으면 다운로드
- 해당 버전으로 빌드 실행

## curl

- 터미널에서 HTTP 요청을 보내는 도구
- client URL의 줄임, 맥에 기본으로 깔려 있음
