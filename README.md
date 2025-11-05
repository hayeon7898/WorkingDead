## 🧩 Git 컨벤션

### (1) 커밋 메시지 규칙

| 타입 | 설명 |
|------|------|
| feat | 새로운 기능 추가 |
| fix | 버그 수정 |
| docs | 문서 수정 |
| style | 코드 포맷팅, 세미콜론 등 (로직 변경 없음) |
| refactor | 코드 리팩토링 |
| test | 테스트 코드 추가 |
| chore | 빌드, 패키지 관리, 파일 삭제 등 기타 작업 |
| hotfix | 긴급한 버그 수정 |

**예시**
feat: 회원가입 API 구현
fix: 잘못된 토큰 검증 로직 수정
docs: README 배포 절차 추가

---

### (2) 브랜치 관리 전략 (Git Flow)

| 브랜치 | 용도 |
|---------|------|
| main | 배포 환경 |
| develop | 개발 통합 환경 |
| hotfix | 긴급한 버그 수정 |
| feat/#이슈번호 | 새로운 기능 개발 시 사용 |

**예시**
feat/#12
fix/#45

---

## 🧾 Issue 컨벤션

### 이슈 제목 규칙

| 유형 | 예시 제목 |
|------|-----------|
| [Feature] | [Feature] 회원관리 기능 추가 |
| [Fix] | [Fix] 토큰 만료 예외 처리 수정 |
| [Documentation] | [Documentation] API 명세 문서 업데이트 |
| [Refactor] | [Refactor] Service 레이어 구조 개선 |
| [Test] | [Test] MidpointService 단위 테스트 추가 |
| [Chore] | [Chore] 불필요한 로그 삭제 |
| [Hotfix] | [Hotfix] 배포 환경 DB 설정 오류 수정 |
| [Security] | [Security] JWT 토큰 암호화 방식 강화 |

---

📘 **요약**
- 커밋 메시지는 `type: 내용` 형식으로 작성  
- 브랜치는 `Git Flow` 기반 (`main`, `develop`, `feat/*`, `hotfix/*`)  
- 이슈 제목은 `[Type] 설명` 형식으로 통일  
