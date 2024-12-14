# TestBoard 프로젝트

스프링 부트를 이용한 게시판 프로젝트입니다.

## 🛠 사용 기술

### Backend
- **Framework:** Spring Boot 2.7.18
- **Language:** Java 8
- **Build Tool:** Gradle
- **Database:** PostgreSQL
- **ORM:** MyBatis 2.3.1

### Frontend
- **Template Engine:** Thymeleaf
- **CSS Framework:** Bootstrap 5.3.0
- **Icons:** Font Awesome 6.0.0

### 주요 기능
- 게시글 CRUD (Create, Read, Update, Delete)
- 페이징 처리 (한 페이지당 10개 게시글)
- 조회수 기능

### 프로젝트 구조
```
src/main/java/com/springboot/testboard
├── DTO
│   ├── BoardDTO.java
│   └── PageDTO.java
├── controller
│   └── BoardController.java
├── service
│   └── BoardService.java
├── mapper
│   └── BoardMapper.java
└── config
    └── DatabaseConfig.java
```

### 개발 환경 설정
1. **데이터베이스 설정**
   - PostgreSQL 설치
   - application.properties에서 데이터베이스 연결 정보 설정

2. **프로젝트 실행**
   ```bash
   ./gradlew bootRun
   ```

3. **접속 정보**
   - URL: `http://localhost:8080/board`
   - 기본 페이지 크기: 10개 게시글/페이지

### 주요 기능 설명

#### 1. 게시글 목록
- 페이징 처리된 게시글 목록 표시
- 게시글 번호, 제목, 작성자, 작성일, 조회수 표시
- 부트스트랩을 활용한 반응형 디자인

#### 2. 게시글 작성
- 제목, 내용, 작성자 입력
- 유효성 검사

#### 3. 게시글 조회
- 게시글 상세 내용 표시
- 조회수 자동 증가

#### 4. 게시글 수정/삭제
- 게시글 수정 기능
- 게시글 삭제 기능

### 로깅
- Logback을 사용한 로깅 구현
- 로그 레벨 설정 및 파일 출력 구성

### 데이터베이스 스키마
```sql
CREATE TABLE board (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    author VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    view_count INTEGER DEFAULT 0
);
```
