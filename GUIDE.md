# 🗺️ 서버 공부 가이드

## 📚 본편 14회차

### 1회차 — 개발환경 · 터미널 · Git

- **배울 것**: JDK/Gradle/IntelliJ 세팅, 프로젝트 구조(`src/main`, `src/test`), 첫 실행
- 🖥️ **명령어**: `pwd` `ls -al` `cd` `mkdir` `rm` / `git clone` `add` `commit` `push` `pull` `branch` `checkout`
- 🧠 **CS**: 클라이언트-서버 개념 / 컴파일 vs 인터프리터 / **JVM이 뭐고 왜 필요한가** / 포트 개념
- **실습**: 프로젝트 생성 → git 저장소 만들고 첫 커밋 → `./gradlew bootRun` 으로 띄우기

### 2회차 — 자바 / 코틀린 기본기

- **배울 것**: 클래스·인터페이스·상속, 제네릭, 예외 처리(checked/unchecked), 컬렉션(List/Map/Set)
- 🧠 **CS**: 객체지향 4대 특성 / **스택 vs 힙** / GC 개념 / null 안정성
- **실습**: 간단한 도메인 클래스 만들고 단위 테스트

### 3회차 — 스프링 부트 개념 · DI / Bean

- **배울 것**: `@SpringBootApplication`(자동설정 + Bean 생성), `SpringApplication.run()` → **내장 WAS**(톰캣 별도 설치 불필요), `@RestController`, `@GetMapping`
- 🖥️ **명령어**: `./gradlew build` / `clean` / `bootRun` / `test`, jar 실행 `java -jar`
- 🧠 **CS**: **IoC / DI 가 왜 필요한가** / 어노테이션 = 메타데이터 / 프레임워크 vs 라이브러리

### 4회차 — HTTP 와 REST API

- **배울 것**: `@PostMapping` `@PutMapping` `@DeleteMapping` `@RequestBody` `@PathVariable` `@RequestParam`
- 🖥️ **명령어**: ⭐ **`curl`** (`-X` `-H` `-d` `-G` `--data-urlencode`), `jq` 로 JSON 보기
- 🧠 **CS**: HTTP 메서드 의미 / **상태코드**(2xx·4xx·5xx) / 헤더 / **멱등성** / TCP vs HTTP / **동기 vs 비동기**
- **실습**: CRUD 4개 엔드포인트를 curl 로만 호출해보기 (Postman 말고 **일부러 터미널로**)

### 5회차 — 테스트 코드

- **배울 것**: JUnit, `MockMvc`(`perform`/`andExpect`), assertj `assertThat().isEqualTo()`, Lombok `@Getter` `@RequiredArgsConstructor`
- 🧠 **CS**: 단위 vs 통합 테스트 / **TDD 사이클(Red→Green→Refactor)** / 테스트가 리팩토링 안전망인 이유
- **실습**: 4회차 API 전부에 테스트 붙이기
- **JUnit 5**(`@ExtendWith` `@BeforeEach`)

### 6회차 — DB ① SQL · 테이블 설계

- **배울 것**: `SELECT` `WHERE` `JOIN`(INNER/LEFT) `GROUP BY` `ORDER BY`, INSERT/UPDATE/DELETE, PK·FK, 정규화 기초
- 🖥️ **도구**: DB 클라이언트 접속(IntelliJ Database), SQL 직접 실행
- 🧠 **CS**: RDB vs NoSQL / 스키마 개념 / **왜 앱 로컬DB(SQLite/Room)와 다른가 → 동시 접속자 수천 명**
- **실습**: 게시판 스키마 직접 설계 → 테이블 생성 → 데이터 넣고 조인 조회
- ⚠️ **ORM 전에 SQL을 반드시 먼저.** 순서 바꾸면 ORM이 평생 "마법"으로 남는다

### 7회차 — JDBC → ORM (JPA)

- **배울 것**: **JDBC 날것으로 한 번** → ORM과 **패러다임 불일치** → **JPA(표준) ← Hibernate(구현체) ← Spring Data JPA** 계층. `@Entity` `@Id` `@GeneratedValue` `@Column` `JpaRepository`
- **설계 원칙 2개** ⭐: **Entity 에 Setter 금지 → `@Builder`**, Entity 와 DTO **분리**
- 🧠 **CS**: 추상화 계층이 왜 생기는가 / 인터페이스와 구현체 분리의 이득
- **실습**: JDBC 버전 → JPA 버전으로 같은 기능 두 번 만들기

### 8회차 — API 계층 구조 · 영속성 컨텍스트

- **배울 것**: **Web / Service / Repository / Dto / Domain** 계층. `@Transactional`. **더티 체킹** — 트랜잭션 안에서 값만 바꾸면 update 쿼리 불필요
- **핵심 원칙** ⭐: **비즈니스 로직은 Domain 에.** Service 는 트랜잭션과 순서만 보장
- **JPA Auditing**: `@MappedSuperclass` `@CreatedDate` `@LastModifiedDate` `@EnableJpaAuditing`
- 🧠 **CS**: 계층 분리(관심사의 분리)가 왜 필요한가 / 캐시로서의 영속성 컨텍스트
- **실습**: 등록·수정·조회·삭제 전체 + `@SpringBootTest` 통합 테스트

### 9회차 — DB ② 인덱스 · 연관관계 · N+1

- **배울 것**: 인덱스 원리, **인덱스가 안 타는 경우**(컬럼 가공·형변환·선행 와일드카드), 실행계획 보기. `@OneToMany` `@ManyToOne`, **N+1 문제**, 페이징(`Pageable`)
- 🧠 **CS**: **B-Tree** / 시간복잡도(풀스캔 O(n) vs 인덱스 O(log n)) / 디스크 I/O
- **실습**: 데이터 10만 건 넣고 인덱스 전후 실행계획·속도 비교

### 10회차 — 트랜잭션

- **배울 것**: **ACID**, 커밋/롤백, 전파(propagation)
- **고립수준**: 표 암기 ❌ → **증상 → 원인** 순서로
  1. "같은 트랜잭션에서 두 번 조회했는데 값이 달라요" → Non-repeatable read
  2. "없던 행이 갑자기 생겼어요" → Phantom read
  3. → 그래서 고립수준이 이걸 막는 장치다
- 🧠 **CS**: **동시성** / 락(공유·배타) / 데드락 / 경쟁 상태
- **실습**: 세션 2개 열어서 동시에 같은 행 수정 → 락 걸리는 것 눈으로 보기

### 11회차 — 리눅스 · 서버 운영 기초

- 🖥️ **명령어**(이 회차의 본체)
  - 파일: `ls -al` `cat` `less` `head` `tail -f` `find` `grep` `vi`
  - 프로세스: `ps -ef | grep` `top` `kill -15` `nohup` `&`
  - 시스템: `df -h` `du -sh` `free -h` `netstat -an | grep 포트`
  - 권한: `chmod` `chown` (`chmod 600` 이 왜 필요한지)
  - 접속: `ssh` `scp`
- 🧠 **CS**: **프로세스 vs 스레드** / 포그라운드·백그라운드 / 표준출력·에러 / 시그널(SIGTERM vs SIGKILL) / 파일 권한
- **실습**: 서버에 접속해 **애플리케이션 로그를 `tail -f` 로 실시간 추적**하고, `grep` 으로 에러만 뽑아내기

### 13회차 — 메시지 큐 · 비동기

- **배울 것**: 큐/이벤트, 프로듀서-컨슈머, 재처리·DLQ
- 🧠 **CS**: 동기 vs 비동기 vs 논블로킹 / 결합도 낮추기 / 최소 1회 전달(at-least-once)

### 14회차 — 캐시

**(원본에 없음 — 추가)**

- **배울 것**: 캐시 계층, TTL, 무효화 전략, Redis
- 🧠 **CS**: 지역성 / 캐시 히트율 / **정합성 vs 성능 트레이드오프**
- 💡 **앵글** ⭐: **"배포했는데 왜 안 바뀌어요?"**
  - 실사례: 배치는 5초면 끝나는데 **조회서버 캐시 TTL 이 10분**이라 반영이 늦게 보였던 것
