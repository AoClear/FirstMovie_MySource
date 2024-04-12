# 🎞 Fisrt_Movie

## <span style="color:lightblue">🎈 프로젝트 주제

### 영화 예매가 가능한 영화관 브랜드 서비스

## <span style="color:lightblue"> ⌛️ 프로젝트 요약

|    분류     |           내용            |  
|:---------:|:-----------------------:|
|    주제     |       영화관 플랫폼        |
|    인원     |            5            |
|    기간     | 2023.11.28 ~ 2024.01.19 |
|   배포 링크   |         http://zonef.cafe24.com/main         |
<br>

---

## <span style="color:lightblue"> 🔨개발 환경 - 기술 스택

<!-- 테스트 : <img src="https://img.shields.io/badge/junit5-FFFFFF?style=flate&logo=junit5&logoColor=junit5"> <br> -->

개발 언어 : 
<img src="https://img.shields.io/badge/JAVA-17-FFFFFF?style=flate&logo=openjdk&logoColor=FFFFFF">
<br>
개발 프레임 워크: 
<img src="https://img.shields.io/badge/SpringBoot-3.1.1-6DB33F?style=flate&logo=SpringBoot&logoColor=6DB33F">
<br>
빌드 : 
<img src="https://img.shields.io/badge/maven-4.0.0-FFFFFF?style=flate&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABwAAAAcCAMAAABF0y+mAAAAzFBMVEVHcExwLIZpK4PIIDjJIDfXQS85KGyRHVP1lSKPL27odCbJIjflbSiZI2S5IEeGJnWpIFewIE6rIFWrIFMqJmPQNDPEIDvKJDfLIDb0kSPFIDvxjCPeWSvFIDvJIDe/IEDfWSvfWyvXQC+0IEx+KHyFJnaDJneBJ3m8IETOKTTjainoeSf0lSPndCfLIDbeWCzjaSl+KHuKJXN6KX27IER/KHu2IEmbImWGJnV/KHvKIDazIEy/IEDOJjTaSy7hYCrqeyaJJXPpeCbdVSxkhj7EAAAAOnRSTlMANkom8usWBP0MG8P5Ht7M96m24UdcpDeviP5xPpjl+NzOwUgkqbfgk/Jx5ufdiKnelGOdyo72UWrsTLVmUAAAANZJREFUKJF90VeTgjAUhuGAwQRFql13FcGuW3TXkgSw/P//5Dhe+oVzmWfeM5mEkLfpcV57P33NgHPe09jwsuF8gK3246wvN83a7yJ2nC22Vh6Pi2IFjVnWJL/HNsSvbGLl1hBahdJ6li07ED9E/VOILkPWobQrBK3gUD3DNgxtd9RW/X4Lhol0/5Qa4a2BDA5SLaCxKAqldBsQG34YST+Blp6uoR8c8cux2dzzpjtoxP6fna9TbMTw9vNffBvCbDPVZM+1pt6IYZSgWdUba5aE1VJEv/gAhbgShVrVkEQAAAAASUVORK5CYII=&logoColor=white">
<br>
API, 라이브러리 : 
<img src="https://img.shields.io/badge/JSTL-000000?style=flate&logoColor=white">
<img src="https://img.shields.io/badge/JDBC-000000?style=flate&logoColor=white">
<img src="https://img.shields.io/badge/Spring Data JPA-6DB33F?style=flate&logo=&logoColor=6DB33F">
<br>
데이터베이스 : 
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white" >
<br>
배포 :
<img src="https://img.shields.io/badge/AWS-232F3E?style=flat&logo=amazonaws&logoColor=white">
<img src="https://img.shields.io/badge/EC2-FF9900?style=flat&logo=amazonec2&logoColor=white">
<img src="https://img.shields.io/badge/RDS-527FFF?style=flat&logo=amazonrds&logoColor=white">
<img src="https://img.shields.io/badge/S3-569A31?style=flat&logo=amazons3&logoColor=white">
<img src="https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white">
<img src="https://img.shields.io/badge/NGINX-009639?style=flat&logo=nginx&logoColor=white">
<img src="https://img.shields.io/badge/Jenkins-D24939?style=flat&logo=jenkins&logoColor=white">
<img src="https://img.shields.io/badge/Portainer-13BEF9?style=flat&logo=portainer&logoColor=white">
<br>
협업 : <img src="https://img.shields.io/badge/GitHub-000000?style=flate&logo=GitHub&logoColor=white">
<img src="https://img.shields.io/badge/Notion -000000?style=flate&logo=Notion&logoColor=white">
<br>

---

### 🏚️ 아키텍쳐 구성도
<img src="docs/architecture-ver2.png" alt="Architecture Diagram"/>

<!--
### ER 다이어그램
<img src="docs/er-diagram-ver2.png" alt="ER-Diagram"/>
-->

### 🌊 플로우 차트
<img src="docs/flow-chart-ver1.png" alt="Flowchart"/>


--- 
## ⚒️ 개발 내용

### 📦 굿즈 / 공구
- 로그인한 유저는 판매글을 작성할 수 있다.
    - 이미지는 S3에 저장된다.
    - 옵션을 등록/수정/삭제할 수 있다. 
    - 배달방법을 등록/삭제할 수 있다.
    - 해시태그는 아티스트, 팀, 해시태그로 구분하여 저장한다.
- 로그인한 유저는 본인의 판매글을 조회/수정/삭제할 수 있다.
  - 조회 시에는 구독 중인 아티스트 글만 보기 / 판매 중인 판매글 중 구독중인 아티스트 글만 보기 조회할 수 있다.
- 유저는 판매글에 찜하기 누르기/취소할 수 있다.
- 로그인한 유저는 판매글에서 주문할 수 있다.
  - 본인의 주문을 조회할 수 있다.
- 판매글 작성자는 판매글의 주문을 조회/상태 변경을 할 수 있다.

---

<!--
### 🔼 버전 정보

#### 1️⃣ Ver 1.0 (24/xx/xx)
- 
-

#### 2️⃣ Ver 1.1 (24/xx/xx)
- 
-

-->
