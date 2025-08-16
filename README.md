# YourOpenInfo - Android App

## 1. 프로젝트 소개 (Introduction)

**YourOpenInfo**는 사용자의 공용 IP 주소를 기반으로 국가, 도시, ISP 등 공개된 정보를 조회하여 보여주는 간단한 안드로이드 애플리케이션입니다. 내 IP로 어떤 정보가 외부에 노출되는지 쉽고 빠르게 확인할 수 있도록 돕는 것을 목표로 합니다.

> 이 프로젝트는 학습 및 개인 정보 보호 인식 제고를 목적으로 제작되었습니다.

## 2. 주요 기능 (Features)

- **IP 정보 조회:** 버튼 클릭 시, 현재 기기의 공용 IP 주소와 관련된 정보를 가져옵니다.
- **상세 정보 표시:** 조회된 정보를 아래와 같은 항목으로 나누어 명확하게 보여줍니다.
  - IP 주소 (IP Address)
  - 국가 (Country)
  - 도시 (City)
  - 지역 (Region)
  - ISP (Internet Service Provider)
  - 시간대 (Timezone)
  - 위도 및 경도 (Latitude & Longitude)
- **간단한 UI:** 직관적인 UI를 통해 누구나 쉽게 사용할 수 있습니다.

## 3. 사용된 기술 및 라이브러리 (Tech Stack & Libraries)

- **언어 (Language):** Java
- **플랫폼 (Platform):** Android
- **최소 SDK 버전:** 16
- **주요 라이브러리:**
  - `androidx.appcompat`: 다양한 안드로이드 버전에 대한 호환성 지원
  - `com.google.android.material:material`: 머티리얼 디자인 컴포넌트 사용
  - `androidx.constraintlayout`: 복잡한 레이아웃을 유연하게 구성
  - `androidx.navigation`: 프래그먼트 간의 이동을 관리
- **외부 API:**
  - **[ip-api.com](http://ip-api.com/)**: IP 주소 기반 위치 정보 조회를 위한 무료 API

## 4. 시작하기 (Getting Started)

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

## 5. 프로젝트 구조 (Project Structure)

```
app
├── src
│   ├── main
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

## 6. 향후 개발 계획 (Future Work)

- [ ] **IP 정보 조회 로직 구현:** `FirstFragment.java`에 `ip-api.com` API를 호출하고 결과를 파싱하여 `TextView`에 표시하는 기능 추가
- [ ] **인터넷 권한 추가:** `AndroidManifest.xml`에 인터넷 사용 권한 추가
- [ ] **UI 개선:** 조회된 정보를 더 명확하고 보기 좋게 디자인 개선
- [ ] **AdMob 광고 제거:** 현재 포함된 샘플 AdMob ID 및 관련 코드 제거
- [ ] **오류 처리:** 네트워크 연결 실패 또는 API 호출 오류 시 사용자에게 알림 표시

## 7. 라이선스 (License)

본 프로젝트는 [MIT 라이선스](LICENSE)를 따릅니다.