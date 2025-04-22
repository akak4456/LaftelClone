
# jetpack compose 선택 이유
그러고보면 개발 2년 동안에는 주로 xml 을 이용해서 개발을 해왔던 것 같다. 그래서 학습 목적이 있기도 하고 실제로 jetpack compose 에서 강조하는 장점들이 맞는지 확인하고자 한다.

## 기존 xml 방식의 한계
🔧 1. UI와 로직 분리가 명확하지 않음
XML은 UI를 담당하고 Java/Kotlin은 로직을 담당하지만, 뷰를 조작하기 위해 findViewById() 등을 사용해야 하기 때문에 UI와 코드가 강하게 결합됨.

유지보수 시 UI 변경이 로직에 영향을 주거나, 반대로 로직 변경이 UI에 영향을 주기 쉬움.

view binding 을 사용하면 ui와 로직을 어느정도는 분리할 수 있겠지만 완벽한 것은 아니다.

✅ View Binding을 사용하면 어떤 점이 좋아질까?
🔹 1. findViewById() 제거 → 타입 안전성 확보
findViewById()는 런타임에 NullPointerException이 발생할 수 있지만,
ViewBinding은 컴파일 타임에서 타입 체크가 가능하므로 더 안전함.

```kotlin
val binding = ActivityMainBinding.inflate(layoutInflater)
binding.textView.text = "Hello"  // 타입 안정적!
```

🔹 2. UI 요소 접근이 더 직관적이고 간결
binding.button.setOnClickListener { ... }처럼
id를 직접 접근할 수 있어 가독성이 좋아짐.

🔹 3. 코드와 XML 간 연결이 명확해짐
레이아웃 이름 → 자동으로 바인딩 클래스 생성 → XML에서 무엇을 사용하고 있는지 명확하게 추적 가능.

❗하지만 View Binding으로도 완전히 해결되지 않는 문제들
🔸 1. 여전히 명령형 코드로 UI 상태를 조작
UI 상태 변화가 많을수록 조건문과 뷰 속성 조작 코드가 복잡해짐.

```kotlin
if (isUserLoggedIn) {
    binding.profileView.visibility = View.VISIBLE
} else {
    binding.profileView.visibility = View.GONE
}
```

→ 선언형 Compose에서는 `if (isUserLoggedIn) { ProfileView() }`처럼 더 간결하게 처리 가능.

🔸 2. 동적 UI 생성은 여전히 불편
동적으로 여러 뷰를 생성하려면 LayoutInflater, addView() 등을 사용해야 하므로 여전히 번거로움.

🔸 3. 레이아웃 재사용성 부족
XML에서의 뷰 재사용은 include, ViewStub 등을 써야 하고, 구조가 복잡해짐.

반면 Compose는 컴포저블 함수로 손쉽게 재사용 가능.

🔸 4. 테스트/프리뷰의 어려움
View Binding도 결국 실제 레이아웃 파일에 의존하므로, UI 단위 테스트나 프리뷰가 어렵고 느림.

⚙️ 2. 런타임 오류 발생 가능성
XML에서 선언한 id가 변경되었거나, 해당 뷰가 존재하지 않는 경우에도 컴파일 타임에서는 에러가 발생하지 않음.

예: `findViewById<TextView>(R.id.myText)` → NullPointerException 가능성.

📐 3. 복잡한 레이아웃 구성의 어려움
복잡한 동적 UI를 구성하려면 LayoutInflater, ViewStub, ViewGroup 조작 등 복잡한 절차가 필요.

특히 리스트 안에 리스트가 있는 경우, XML 기반 UI는 가독성이 떨어지고 유지보수가 어렵다.

📱 4. 상태 기반 UI 구현의 어려움
XML은 선언적이지 않아서, 어떤 조건에 따라 특정 UI 상태를 변경하려면 imperative(명령형) 코드로 뷰 속성을 직접 조작해야 함.

예: `textView.visibility = View.GONE` 등 상태별 조건문이 늘어나 복잡해짐.

🔄 5. 재사용성 및 테스트 한계
XML은 코드 수준에서 재사용이 어렵고, 뷰 단위의 유닛 테스트 작성도 제한적임.

재사용 가능한 컴포넌트를 만들려면 include, merge, ViewStub 등 XML 트릭을 사용해야 해서 복잡도 상승.

🧱 6. 디자인 시스템 적용의 비효율
공통 스타일 적용이 어렵고, 테마/스타일을 XML에서 반복 선언해야 함.

디자인 시스템을 코드 레벨로 추상화하기 어렵고, 스타일 일관성 유지에 많은 비용이 듬.

## jetpack compose 의 장점
🌟 1. 선언형 UI (Declarative UI)
상태(state)에 따라 UI가 자동으로 업데이트됨.

```kotlin
val isLoggedIn = remember { mutableStateOf(false) }

if (isLoggedIn.value) {
    Text("Welcome!")
} else {
    Text("Please log in")
}
```

→ 복잡한 setVisibility(), invalidate() 등을 직접 호출하지 않아도 됨.

🧠 선언형 UI와 함수형 프로그래밍의 관계
1. 🔁 Side-effect 최소화 → 순수 함수 지향
선언형 UI는 특정 상태(state)에 따라 어떤 UI를 보여줄지를 명확히 정의합니다.

Compose의 @Composable 함수는 주어진 입력(state)에 대해 항상 같은 출력(UI) 을 반환해야 하며, 외부 상태에 의존하지 않는 것이 이상적입니다.

```kotlin
@Composable
fun Greeting(name: String) {
    Text("Hello, $name!")
}
```

➡️ name이 같으면 항상 같은 UI.
➡️ 이는 전형적인 순수 함수(pure function) 의 특성입니다.

2. 💡 명령형 vs 선언형 사고방식의 차이

| 패러다임 | 명령형 (Imperative) | 선언형 (Declarative) |
| -------- | ------------------ | ------------------ |
| 방식     | "어떻게 그릴지" 명령  | "무엇을 그릴지" 선언 |
| 예시     | `view.visibility = GONE` | `if (showView) { View() }` |
| 관리     | 상태 변화 직접 제어   | 상태 기반으로 UI 자동 갱신 |

→ 함수형 프로그래밍도 데이터가 바뀌면 새로운 값을 반환하는 식으로 사고합니다. Compose 역시 동일합니다.

3. 🔄 상태와 UI를 자연스럽게 연결
함수형 프로그래밍에서 상태는 불변성을 중요시하며, 상태 변화는 새로운 상태를 생성하는 방식으로 처리합니다.

Compose에서도 remember, mutableStateOf 등을 통해 상태를 선언하고, 그 상태가 바뀌면 UI가 자동으로 업데이트되도록 설계되어 있습니다.

```kotlin
val counter = remember { mutableStateOf(0) }

Button(onClick = { counter.value++ }) {
    Text("Clicked ${counter.value} times")
}
```

➡️ 이건 사실상 counter라는 상태에 따라 UI를 "다시 그리는" 함수형 사고 방식입니다.

4. 🧩 컴포저블 함수는 재사용 가능한 함수 단위 UI 컴포넌트
컴포저블 = 순수 함수 → 테스트, 재사용, 조합이 용이

```kotlin
@Composable
fun Profile(name: String, age: Int) {
    Text("Name: $name, Age: $age")
}
```

➡️ 조합 가능한 작고 예측 가능한 함수로 구성된 UI.

🎯 결론
Jetpack Compose의 선언형 UI는

📌 "UI = 상태(state)를 기반으로 한 순수 함수의 조합"

이라는 함수형 프로그래밍의 철학을 안드로이드에 적용한 결과입니다.

즉,

선언형 UI의 장점 = 함수형 프로그래밍의 장점

예측 가능성

상태와 출력의 분리

재사용성

테스트 용이성

side-effect 최소화

🌟 2. 코드 기반 UI 구성으로 재사용성과 확장성 향상
UI를 함수 단위로 분리하고 재사용 가능.

```kotlin
@Composable
fun UserCard(name: String) {
    Text("Hello, $name")
}
```

🌟 3. XML, findViewById, ViewBinding 필요 없음
모든 UI를 Kotlin 코드로 작성 → 뷰 바인딩 및 리소스 참조의 불편함 해결

🌟 4. 미리보기 기능과 실시간 렌더링 (Preview)
Android Studio에서 @Preview를 통해 코드 기반 UI를 즉시 시각적으로 확인 가능

```kotlin
@Preview
@Composable
fun PreviewUserCard() {
    UserCard("Alice")
}
```

🌟 5. 애니메이션과 상태전환이 쉬움
animate*AsState() 같은 API 제공 → 부드럽고 간결한 애니메이션 처리 가능

🌟 6. 정확한 UI 상태 관리 가능
remember, mutableStateOf, LaunchedEffect 등을 통해 UI 상태와 로직이 밀접하게 동기화됨

## jetpack compose 의 한계 및 단점 해결법

⚠️ 1. 학습 곡선
기존 XML에 익숙한 개발자에게는 완전히 새로운 개념 (선언형, Compose lifecycle 등)

🛠️ 해결 방법: 공식 문서 예제 및 코드랩 활용, 기존 XML 프로젝트와 병행 가능 (Hybrid UI)

⚠️ 2. 호환성 문제 (특히 커스텀 뷰나 서드파티 라이브러리)
일부 서드파티 UI 라이브러리는 Compose와 호환되지 않거나 별도 처리 필요

🛠️ 해결 방법: AndroidView 컴포저블을 사용하여 기존 View를 Compose 내부에서 사용할 수 있음

```kotlin
AndroidView(factory = { context ->
    CustomLegacyView(context)
})
```

⚠️ 3. 성능 문제 (초기에는 있었음)
초창기에는 recomposition 오버헤드, 배터리 효율 이슈가 있었으나 현재는 대부분 개선됨

🛠️ 해결 방법: remember, key, derivedStateOf 등을 적절히 사용해 recompose 최적화

⚠️ 4. 디버깅 도구 부족 (점점 나아지고 있음)
Layout Inspector 등은 Compose 지원이 제한적이었으나, Android Studio 최신 버전에서 개선됨

🛠️ 해결 방법: Compose-specific tools (Recomposition counter, Debug inspector 등) 활용

⚠️ 5. XML로 작성된 앱과의 통합
점진적 도입이 가능하지만, XML과 Compose가 혼합되면 관리가 복잡해질 수 있음

🛠️ 해결 방법: 전체 UI를 Compose로 마이그레이션하거나, 화면 단위로 명확히 분리

## jetpack 을 써야 하는 이유
이를 종합해보면 아직 버전에 따라 인터페이스가 변경되는 등 불안한 모습이 있기는 하지만 그럼에도 장기적인 관점에서 여러 장점이 있기도 하고 구글이 공식적으로 밀고 있으므로 학습 프로젝트 용도 뿐만 아니라 실제 상업 용도로도 충분히 쓸만하다는 판단이 든다.
