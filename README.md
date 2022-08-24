# SSAFYBUCKS
> O2O기반 스마트 스토어 서비스

> 1학기 최종 플젝
## 시연 영상
[![싸피벅스_시연동영상](https://img.youtube.com/vi/gzNCZnyfRGg/0.jpg)](https://youtu.be/gzNCZnyfRGg)

## 기능
### 기본 기능 (공동 작업)
+ Online에서 상품을 주문하고 Offline에서 상품을 받는 O2O 스마트 스토어 기능
  + 장바구니, 후기 작성, 회원 등급, 상품 주문 등
+ NFC, Beacon, 위치 기반 서비스 등
### 추가 기능
+ 부트페이 API를 이용한 결제 기능
+ 관리자용 앱 (주문 관리, 일별 매출, 제품 판매 현황 등 통계 확인)
+ 손님과 관리자간 주문 상태를 주고 받기 (feat. fcm)
## 팀 구성
+ 강태웅
+ 김영진
## 역할
- 웹, 서버, 기본 기능은 공통 과제
- 아키텍처 설계
- fcm 수신
- 백스택 관리
- 비콘 연동
- 부트페이 API 연동
- REST API 추가
## 개발 환경
### Agile-PairProgramming
### Android
+ Android Studio
+ Kotlin
+ MVVM

+ Retrofit2, OkHttp3 - 네트워크 통신
+ Room - 로컬 DB 저장
+ AAC (ViewModel, DataBinding, LiveData, LifeCycles) - 아키텍처 관련 컴포넌트
+ Coroutines - 비동기 처리
+ Firebase - FCM
+ BootPay API - 결제 프로세스
+ Beacon, NFC - 근거리 네트워크 통신
+ Glide - 이미지 처리
+ Navigation - 프래그먼트 스택 관리
+ AnyChart-Anrdoid - 통계 라이브러리
+ Google Map - 지도
+ GPS
+ Beacon
+ NFC

### Web
+ Visual Studio Code
+ JavaScript
+ MVVM

+ Vue.js - 자바스크립트 프레임워크
+ Vuex - 상태관리
+ router - 페이지 이동

### Server
+ Eclipse
+ Java
+ MVC

+ Spring - 서버 개발 프레임워크
+ Spring Boot - 프로젯트 셋팅 라이브러리
+ MySQL - RDBMS
+ mybatis - SQL 매핑 프레임워크
+ Firebase - FCM
+ Swagger - API Documentation

## 시스템 구조
![image](https://user-images.githubusercontent.com/66052467/172126089-ec22102e-ae82-4dde-bce6-7a5c82c0184a.png)
+ fcm 수신은 앱이 포그라운드면 클라이언트 앱에서 처리, 백그라운드면 기기에 설치된 fcm sdk에서 처리

## 플로우 차트
![image](https://user-images.githubusercontent.com/66052467/172125828-7b8c400b-7141-4b03-b46f-33bf9cc1ea8d.png)

## 아키텍처
![image](https://user-images.githubusercontent.com/66052467/172125897-60b341c5-fdaa-4cd9-ad01-8fe74240f758.png)
