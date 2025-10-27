# Spring Batch Practice

Spring Batch의 구조와 실행 흐름을 이해하기 위한 학습 프로젝트

---

## 프로젝트 개요

| 항목 | 내용 |
|------|------|
| **Framework** | Spring Batch 5.x |
| **Language** | Java 21 |
| **Build Tool** | Gradle |
| **Database** | MySQL 8.x |
| **Purpose** | 배치 시스템 학습 |

---

## 학습 목표

실무에서 필요한 **대용량 데이터 처리, 정산, 로그 수집** 등의 배치 작업을 안정적으로 설계하고 운영할 수 있는 역량을 기르기 위한 프로젝트입니다.

### 핵심 학습 주제

1. **기본 구조 이해**
  - Job, Step, Chunk 기반 처리 구조
  - Reader → Processor → Writer 패턴

2. **트랜잭션 및 상태 관리**
  - JobRepository를 통한 메타데이터 관리
  - Commit Interval과 Chunk Size 최적화

3. **안정성 및 복원력**
  - 에러 처리 및 재시도(Retry) 전략
  - Skip 정책과 재시작(Restart) 메커니즘

---

## 기술 스택 선택 이유

- **Spring Batch 5.x**: 최신 버전 기반으로 학습하여 현업에서 바로 적용 가능한 코드 작성 능력 확보
- **Java 21**: LTS
- **MySQL**: 배치 메타데이터 저장 및 실제 데이터 처리 실습을 위한 RDBMS

---

## 실습 내용

### 1단계: 기본 Job 구성
- [ ] 단순 Tasklet 기반 Job 구현
- [ ] Chunk 기반 Step 구현
- [ ] JobParameters를 활용한 동적 실행

### 2단계: 실전 시나리오 적용
- [ ] CSV 파일 읽기 → DB 저장 배치
- [ ] DB 데이터 읽기 → 가공 → 다른 테이블 저장
- [ ] 페이징 처리 및 대용량 데이터 최적화

### 3단계: 안정성 강화
- [ ] 에러 발생 시 Skip 및 Retry 정책 적용
- [ ] 실패한 Job 재시작 처리
- [ ] 배치 실행 이력 및 모니터링

---

## 참고 자료

- [Spring Batch 공식 문서](https://spring.io/projects/spring-batch)
- [Spring Batch 4 → 5 마이그레이션 가이드](https://github.com/spring-projects/spring-batch/wiki/Spring-Batch-5.0-Migration-Guide)
- 『스프링 배치 완벽 가이드』 - 마이클 민셀라

---

> **Note**: Spring Batch 학습 과정을 기록하는 프로젝트입니다. 개념 학습과 실습을 병행하며 점진적으로 완성도를 높여가고 있습니다.
