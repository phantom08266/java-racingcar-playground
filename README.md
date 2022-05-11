## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

### Todo List
```
- 문자열이 주어지면 덧셈 연산을 한다.[0]
  - 빈 문자열, Null 입력 시 0을 반환한다. [0] checker method
  - 숫자 하나인 문자열은 그대로 숫자를 반환한다. [0] checker method
  - 음수를 입력할 경우 RuntimeException이 발생한다. [0] valid method
  - 커스텀 구분자인지 아닌지 구별할 수 있어야 한다.[0] checker method
    - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열로 구분자 처리를 하여 덧셈연산을 한다. [0] 
    - 커스텀 구분자를 지정할 수 있다.(// 와 \n 사이에 있는 문자로 커스텀 한다.) [0]
  - 숫자 위치에 이외의 값을 입력한 경우는 RuntimeException이 발생한다. [0] valid method
```

### 고민했던 부분들과 크루원과 같이 논의해볼 내용
```
1. 단위 테스트 이름은 대충! 대신 Junit5에서 지원하는 @DisplayName을 잘 작성하자! => 테스트는 해당 프로그램에 대한 기능의 명세이기 때문!
2. 정규표현식 개념 정리
```
