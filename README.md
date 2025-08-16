# YourOpenInfo - Android App

## 1. 프로젝트 소개 (Introduction)

**YourOpenInfo**는 사용자의 공용 IP 주소를 기반으로 국가, 도시, ISP 등 공개된 정보를 조회하여 보여주는 간단한 안드로이드 애플리케이션입니다. 내 IP로 어떤 정보가 외부에 노출되는지 쉽고 빠르게 확인할 수 있도록 돕는 것을 목표로 합니다.

> 이 프로젝트는 학습 및 개인 정보 보호 인식 제고를 목적으로 제작되었습니다.

## 2. 앱 다운로드 (Download)

대한민국 앱 마켓인 **원스토어(ONE store)**에서 앱을 다운로드할 수 있습니다.

<a href="https://m.onestore.co.kr/ko-kr/apps/appsDetail.omp?prodId=0000753112" target="_blank">
    <img src="https://raw.githubusercontent.com/freeNanum/Android-YourOpenInfo-App/main/assets/onestore_badge.png" alt="Download on ONE store" width="200"/>
</a>

> **Note:** 위 배지 이미지를 표시하기 위해, 프로젝트의 `assets` 폴더에 원스토어 배지 이미지를 추가했습니다. 만약 이미지가 보이지 않는다면, `main` 브랜치에 `assets/onestore_badge.png` 파일이 있는지 확인해주세요.

## 3. 주요 기능 (Features)

- **IP 정보 조회:** 버튼 클릭 시, `ipinfo.io` API를 통해 현재 기기의 공용 IP 주소와 관련된 정보를 가져옵니다.
- **상세 정보 표시:** `ipinfo.io`의 무료 API가 제공하는 아래의 상세 정보를 표시합니다.
  - **IP:** 공용 IP 주소
  - **Hostname:** IP 주소의 호스트 이름
  - **City:** 도시
  - **Region:** 지역 (주 또는 도)
  - **Country:** 국가 코드
  - **Location:** 위도 및 경도 좌표
  - **Organization:** 인터넷 서비스 제공자(ISP) 또는 기관명
  - **Postal:** 우편번호
  - **Timezone:** 시간대

## 4. 사용된 기술 및 라이브러리 (Tech Stack & Libraries)

- **언어 (Language):** Java
- **플랫폼 (Platform):** Android
- **최소 SDK 버전:** 16
- **주요 라이브러리:**
  - `androidx.appcompat`: 다양한 안드로이드 버전에 대한 호환성 지원
  - `com.google.android.material:material`: 머티리얼 디자인 컴포넌트 사용
  - `androidx.constraintlayout`: 복잡한 레이아웃을 유연하게 구성
  - `androidx.navigation`: 프래그먼트 간의 이동을 관리
  - `java.net.HttpURLConnection`: 네트워킹
  - `org.json`: JSON 파싱
- **외부 API:**
  - **[ipinfo.io](https://ipinfo.io/)**: IP 주소 기반 위치 정보 조회를 위한 무료 API

## 5. 시작하기 (Getting Started)

### 사전 요구사항

- Android Studio 4.1 이상
- Android SDK

### 빌드 및 실행 방법

1. **저장소 복제 (Clone the repository):**
   ```bash
   git clone https://github.com/freeNanum/Android-YourOpenInfo-App.git
   ```

2. **Android Studio에서 프로젝트 열기:**
   - Android Studio를 실행하고 `Open an existing project`를 선택합니다.
   - 복제된 `Android-YourOpenInfo-App` 디렉토리를 엽니다.

3. **Gradle 동기화:**
   - 프로젝트를 열면 Android Studio가 자동으로 Gradle 동기화를 시작하여 필요한 의존성을 다운로드합니다.

4. **앱 실행:**
   - 상단의 `Run` 버튼을 클릭하거나 `Shift + F10`을 눌러 에뮬레이터 또는 연결된 실제 기기에서 앱을 실행합니다.

## 6. 프로젝트 구조 (Project Structure)

```
app
├── src
│   ├── main
│   │   ├── assets
│   │   │   └── onestore_badge.png      # 원스토어 배지 이미지
│   │   ├── java/com/opensupport/youropeninfo
│   │   │   ├── MainActivity.java       # 메인 액티비티
│   │   │   ├── FirstFragment.java      # 정보 조회 및 표시 화면
│   │   │   └── SecondFragment.java     # (추가 기능용)
│   │   ├── res
│   │   │   ├── layout/activity_main.xml # 메인 레이아웃
│   │   │   └── layout/fragment_first.xml  # 정보 표시 프래그먼트 레이아웃
│   │   └── AndroidManifest.xml         # 앱 기본 설정 및 권한
│   └── build.gradle                    # 앱 레벨 빌드 설정 및 의존성
└── build.gradle                        # 프로젝트 레벨 빌드 설정
```

## 7. 향후 개발 계획 (Future Work)

- [ ] **UI 개선:** 조회된 정보를 더 명확하고 보기 좋게 디자인 개선
- [ ] **AdMob 광고 제거:** 현재 포함된 샘플 AdMob ID 및 관련 코드 제거
- [ ] **오류 처리 개선:** 네트워크 연결 실패 또는 API 호출 오류 시 사용자에게 더 상세한 알림 표시

## 8. 라이선스 (License)

본 프로젝트는 [MIT 라이선스](LICENSE)를 따릅니다.