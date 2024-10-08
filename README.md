# <div align="center"> 🍀 성장의 비밀 🍀 </div>
[![code](https://img.shields.io/badge/Code-JAVA-orange)]
[![DBMS](https://img.shields.io/badge/DBMS-MySQL-blue)](https://www.mysql.com/downloads/)
> 교육용 콘텐츠 개발을 목적으로 한 식물 성장 파악 일지

## 📖 Description
- 초중고 수업시간에 식물 성장 관찰 일지를 쉽게 작성 할 수 있는 플랫폼 제공
- 일지 작성의 기본적인 구조를 지니고 있음
- 디자인 패턴을 사용하여 소프트웨어 구조 파악이 용이함

## 📋 Demo
- 사진

## 👩‍💻 Main Feature
### 로그인
- 사용자가 자신의 정보를 저장하고 일지를 작성했을 때 추후에 확인 가능하도록 함
### 일지 기록
- 식물의 성장 과정 기록
- 하나의 식물에 대한 일지를 작성 후 하위 목록에 날짜별 식물 성장 과정 기록 가능
- 로그인한 모든 사용자는 다른 사용자의 기록 확인 가능

## 💻 Usage Patterns
### MVC Pattern(사용자 인터페이스를 로직에서 분리하여 애플리케이션 구조 구성)
- Model(entity)
    - Day, Log, User
- View
    - 사용한 여러 html, js, css
- Controller
    - FindIDController : 이름, 생일 입력 받아 아이디 찾기
    - LogController : 게시글 관리(CRUD)
    - LoginController : 로그인 관리
    - UserController : 회원가입 관리
      
### Service Layer Pattern(비즈니스 로직과 데이터 엑세스 로직을 분리하는 서비스 레이어로 동작)
- DayService
- FindIDService
- LoginService
- LogService
- UserService
     
### Dependency Injection Pattern(@Autowired를 통한 Service 인스턴스 자동 주입)
### Repository Pattern(데이터베이스와의 상호작용을 캡슐화하여 데이터 엑세스 조직을 컨트롤러부터 분리)
- DayRepository
- FindIDRepository
- LogRepository
- UserRepository
  
### Singleton 패턴(@Bean으로 싱글톤 관리)
- SecutiryConfig : 비밀번호 암호화 관리

## ⚙️ Setting
- 개발 환경
   - IntelliJ
- 설치
   - DB : MySQL(ver 8.1.0)
   - Java : JDK17
- Spring boot version : 3.2.0


