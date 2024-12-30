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

## 구현 기능

### 1. 인증 시스템 (Authentication)

#### 1.1 로그인 기능
- Spring Security를 활용한 인증 구현
- 사용자 정보는 PostgreSQL DB에 저장
- 비밀번호 암호화 (BCryptPasswordEncoder 사용)
- 로그인 성공/실패 처리
- 세션 관리

#### 1.2 회원가입 기능
- 이메일, 사용자명, 비밀번호 입력
- 중복 이메일/사용자명 검사
- 비밀번호 확인 기능
- 암호화된 비밀번호 저장

#### 1.3 로그아웃 기능
- 세션 무효화
- JSESSIONID 쿠키 삭제
- 로그아웃 후 메인 페이지 리다이렉트

### 2. 기술 스택

#### 2.1 Backend
- Spring Boot 2.7.18
- Spring Security
- MyBatis
- PostgreSQL
- Lombok

#### 2.2 Frontend
- Thymeleaf
- Bootstrap 5
- HTML/CSS/JavaScript

### 3. 주요 컴포넌트

#### 3.1 Controller
- `LoginController`: 로그인/회원가입/로그아웃 처리

#### 3.2 Service
- `UserService`: UserDetailsService 구현
- `UserServiceImpl`: 사용자 인증 및 회원가입 로직 구현

#### 3.3 Mapper
- `UserMapper`: MyBatis를 통한 데이터베이스 연동
  - 로그인 조회
  - 회원가입
  - 사용자명/이메일 중복 확인
  - 사용자 정보 조회

#### 3.4 Security
- `SecurityConfig`: Spring Security 설정
  - URL 접근 권한 설정
  - 로그인/로그아웃 설정
  - 비밀번호 인코더 설정
  - CSRF 보호

### 4. 데이터베이스

#### 4.1 Users 테이블 (tusers)
- id: 사용자 고유 식별자
- email: 이메일 주소
- username: 사용자명
- password_hash: 암호화된 비밀번호
- created_date: 계정 생성일

### 5. 보안 기능
- 비밀번호 암호화 저장
- CSRF 보호
- 세션 관리
- URL 접근 제어
- 인증된 사용자만 특정 페이지 접근 가능

### 6. 프로젝트 구조
```
src/main/
├── java/com/springboot/testboard/
│   ├── config/
│   │   └── SecurityConfig.java
│   ├── controller/
│   │   └── LoginController.java
│   ├── DTO/
│   │   └── UserDTO.java
│   ├── mapper/
│   │   └── UserMapper.java
│   └── service/
│       ├── UserService.java
│       └── UserServiceImpl.java
└── resources/
    ├── mybatis/mapper/
    │   └── UserMapper.xml
    └── templates/auth/
        ├── login.html
        └── signup.html
```

## 시작하기

### 필수 조건
- JDK 17
- PostgreSQL
- Gradle

### 설정
1. PostgreSQL 데이터베이스 생성
2. `application.properties` 파일에 데이터베이스 연결 정보 설정
3. Gradle로 의존성 설치
4. 애플리케이션 실행

## 다음 단계
- [ ] 비밀번호 재설정 기능
- [ ] 이메일 인증
- [ ] 사용자 프로필 관리
- [ ] 권한 관리 (Admin/User)
