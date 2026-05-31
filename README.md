[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/GVYXGiSz)
# 🦁 5주차: 자바로 배우는 IoC/DI (의존성 주입과 제어의 역전)

`Service`가 `Repository`를 직접 생성하지 않도록 리팩토링하며, 스프링(Spring) 프레임워크의 근간이자 객체지향 설계의 핵심인 **의존성 주입(DI)**과 **제어의 역전(IoC)**의 필요성을 구조적으로 이해하는 과제입니다.

자세한 내용은 PBL 사이트를 참고 하세요. [5주차 - 자바로 배우는 IoC/DI](https://likelion-pbl-five.vercel.app/springboot/2f044860a4f48110b935cf9dc900b42b)

## 🎯 과제 목표
* **결합도 완화**: 강한 결합의 문제점을 이해하고, 인터페이스 기반의 느슨한 결합이 가진 장점을 설명할 수 있다.
* **의존성 주입**: 의존성 주입(DI)이 무엇이고 왜 필요한지, 생성자 주입 방식을 사용하는 이유를 이해합니다.
* **제어의 역전**: 객체의 생성 및 관리 제어권이 외부로 이동하는 제어의 역전(IoC)의 개념을 이해합니다.
* **인터페이스 활용**: 인터페이스 기반 설계가 코드의 유연성과 유지보수성을 어떻게 높이는지 학습합니다.
* **아키텍처 확장**: 4주차 코드가 Repository, Service, Main의 3개 레이어로 어떻게 분리되는지 비교 분석합니다.

## 🛠 기술 스택
* **Language**: Java (JDK 17 이상)
* **Environment**: Console (CLI)
* **Key Concepts**: IoC(Inversion of Control), DI(Dependency Injection), Layered Architecture, Interface

## 📋 주요 기능
1. **레이어 분리 및 구조화**: 멤버 관리 로직을 Repository(저장), Service(비즈니스), Main(실행)으로 분리
2. **다중 저장소 구현**: 실제 데이터를 다루는 `Memory` 저장소와 더미 데이터를 반환하는 `Mock` 저장소 구축
3. **구현체 동적 교체**: `Main`에서 저장소 객체를 교체하는 것만으로 `Service` 코드 수정 없이 동작을 변경

## 🚀 실행 흐름 (Implementation Logic)
본 미션은 강한 결합에서 느슨한 결합으로 나아가는 2단계 리팩토링으로 진행됩니다.

| 단계 | 주요 작업 내용 |
| :--- | :--- |
| **Step 1** | 아키텍처 레이어 분리 및 구현 (`Service` 내부에서 `Repository`를 직접 생성하여 강하게 결합) |
| **Step 2** | `Repository`를 인터페이스로 추상화하고, `Service` 생성자를 통해 외부에서 의존성을 주입(DI) |

### 🔍 Step 1 vs Step 2 비교

| 항목 | Step 1 (직접 생성) | Step 2 (생성자 주입) |
| :--- | :--- | :--- |
| **객체 생성 위치** | `Service` 내부 | `Main` (외부) |
| **의존 대상** | 클래스 (구현체) | 인터페이스 |
| **구현체 교체 시** | `Service` 코드 수정 필요 | `Main`만 수정 |
| **결합도** | **강함** | **느슨함** |

## ⚠️ 제약 사항 및 유의 사항
- [ ] **인터페이스 의존**: Step 2에서 `Service`는 오직 `Repository` 인터페이스에만 의존해야 합니다.
- [ ] **직접 생성 금지**: `Service` 내부에서 `new` 키워드를 사용하여 저장소 객체를 직접 생성하지 않습니다.
- [ ] **불변성 유지**: 생성자로 주입받는 `Repository` 필드는 한 번 설정되면 변경되지 않도록 상수로 선언합니다.
- [ ] **패키지 준수**: 지정된 단계별 패키지 구조(`package1`, `package2`)와 공용 도메인 패키지를 반드시 준수합니다.
- [ ] **검증 범위 제한**: 유효성 검증은 복잡한 로직을 제외하고 '이름 중복 확인'만 구현하여 아키텍처에 집중합니다.

---
*이 프로젝트는 [멋쟁이사자처럼(LIKELION) PBL](https://likelion-pbl-five.vercel.app/) 과정을 바탕으로 제작되었습니다.*
