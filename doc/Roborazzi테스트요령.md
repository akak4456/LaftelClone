# Roborazzi 테스트 요령
Roborazzi 를 이용해서 스크린샷 테스트를 한다.

## gradle properties 설정법
- 기존 이미지와 비교만 하고 덮어쓰지 않기를 하려면 gradle.properties 파일의 roborazzi.test.record 를 false 로 선언해야 한다.
- 새로운 이미지를 기존 이미지로 덮어쓰려면 roborazzi.test.record 를 true 로 선언해야 한다.
=> 다시 말해 새로운 화면을 만들었다면 roborazzi.test.record 를 true 로 기존 화면에 대한 회귀테스트를 진행하려면 false 로 선언해야 한다는 뜻이며 프로젝트 개발 초기에는 기본적으로 roborazzi.test.record 를 true 로 선언하다가 안정화가 되면 roborazzi.test.record 를 기본적으로 false 로 선언하고 화면이 변경될 때만 true 로 설정하는 식으로 한다.